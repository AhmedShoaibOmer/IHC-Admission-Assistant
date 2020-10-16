package com.yasser.ihcg.ui.notifications;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yasser.ihcg.R;

import java.util.Objects;

public class NotificationDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_display_activity);
        final TextView title = findViewById(R.id.title_tv);
        final TextView body = findViewById(R.id.body_tv);
        title.setText(Objects.requireNonNull(getIntent().getExtras()).getString("titleArg"));
        body.setText(getIntent().getExtras().getString("bodyArg"));
    }
}
