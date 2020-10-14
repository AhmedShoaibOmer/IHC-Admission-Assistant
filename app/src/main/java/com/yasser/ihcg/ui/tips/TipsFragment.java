package com.yasser.ihcg.ui.tips;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.yasser.ihcg.R;

public class TipsFragment extends Fragment {

    private TipsViewModel tipsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tipsViewModel =
                ViewModelProviders.of(this).get(TipsViewModel.class);
        return inflater.inflate(R.layout.fragment_tips, container, false);
    }
}