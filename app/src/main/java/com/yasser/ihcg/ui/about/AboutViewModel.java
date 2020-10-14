package com.yasser.ihcg.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.yasser.ihcg.BuildConfig;

public class AboutViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(BuildConfig.VERSION_NAME);
    }

    public LiveData<String> getText() {
        return mText;
    }
}