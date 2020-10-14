package com.yasser.ihcg.ui.submit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.yasser.ihcg.R;

public class SubmitFragment extends Fragment {

    private SubmitViewModel submitViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        submitViewModel =
                ViewModelProviders.of(this).get(SubmitViewModel.class);
        View root = inflater.inflate(R.layout.fragment_submit, container, false);
        /*final TextView textView = root.findViewById(R.id.text_tools);
        submitViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
}