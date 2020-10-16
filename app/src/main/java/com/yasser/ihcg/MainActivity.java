package com.yasser.ihcg;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.yasser.ihcg.ui.submit.StudentAdmissionDetails;
import com.yasser.ihcg.ui.submit.SubmitViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity OnCreate:";
    private AppBarConfiguration mAppBarConfiguration;
    private String token;
    private DatabaseReference mDatabase;
    private SubmitViewModel submitViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the notifications Service
        FirebaseMessaging.getInstance().subscribeToTopic("pushNotifications");

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        token = task.getResult();

                        // Log and toast
                        Log.d(TAG, token);
                        Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });
// ...
        mDatabase = FirebaseDatabase.getInstance().getReference();

        submitViewModel = ViewModelProviders.of(this).get(SubmitViewModel.class);
        submitViewModel.submissionDetails.observe(this, new Observer<StudentAdmissionDetails>() {
            @Override
            public void onChanged(StudentAdmissionDetails studentAdmissionDetails) {
                writeNewUser(studentAdmissionDetails.getName(),
                        studentAdmissionDetails.getType(),
                        studentAdmissionDetails.getDegree(),
                        studentAdmissionDetails.getSection());
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_about_university, R.id.nav_tips, R.id.nav_guide,
                R.id.nav_submit, R.id.nav_notification,
                R.id.nav_about)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void writeNewUser(String name, String type, String degree, String section) {
        StudentAdmissionDetails sAD = new StudentAdmissionDetails(token, name, type, degree, section);

        mDatabase.child("students").child(token).setValue(sAD);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
