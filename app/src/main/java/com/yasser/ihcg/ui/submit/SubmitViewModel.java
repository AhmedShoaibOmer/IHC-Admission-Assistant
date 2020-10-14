package com.yasser.ihcg.ui.submit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SubmitViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SubmitViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}