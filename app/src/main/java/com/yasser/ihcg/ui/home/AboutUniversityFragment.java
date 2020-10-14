package com.yasser.ihcg.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.yasser.ihcg.R;

public class AboutUniversityFragment extends Fragment {

    private AboutUniversityViewModel aboutUniversityViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutUniversityViewModel =
                ViewModelProviders.of(this).get(AboutUniversityViewModel.class);
        return inflater.inflate(R.layout.fragment_about_university, container, false);
    }
}