package com.yasser.ihcg.ui.submit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;
import com.yasser.ihcg.R;

import java.util.Objects;

public class SubmitFragment extends Fragment {

    private SubmitViewModel submitViewModel;
    private View mView;
    private TextInputEditText in_name, in_type, in_degree, in_section;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        submitViewModel =
                ViewModelProviders.of(requireActivity()).get(SubmitViewModel.class);
        mView = inflater.inflate(R.layout.fragment_submit, container, false);
        final Button submitButton = mView.findViewById(R.id.send);
        in_name = mView.findViewById(R.id.input_name);
        in_type = mView.findViewById(R.id.input_type);
        in_degree = mView.findViewById(R.id.input_degree);
        in_section = mView.findViewById(R.id.input_section);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
        return mView;
    }

    private void submit() {
        String name, type, degree, section;
        name = Objects.requireNonNull(in_name.getText()).toString();
        if (name.isEmpty()) {

        } else {
            type = Objects.requireNonNull(in_type.getText()).toString();
            if (type.isEmpty()) {

            } else {
                degree = Objects.requireNonNull(in_degree.getText()).toString();
                if (degree.isEmpty()) {

                } else {
                    section = Objects.requireNonNull(in_section.getText()).toString();
                    if (section.isEmpty()) {

                    } else {
                        submitViewModel.sendAdmission(new StudentAdmissionDetails(
                                name,
                                type,
                                degree,
                                section)
                        );
                    }
                }
            }
        }
    }
}