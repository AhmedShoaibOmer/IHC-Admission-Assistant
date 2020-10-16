package com.yasser.ihcg.ui.submit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SubmitViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<StudentAdmissionDetails> _submissionDetails = new MutableLiveData<>();
    public LiveData<StudentAdmissionDetails> submissionDetails = _submissionDetails;

    public SubmitViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tools fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void sendAdmission(StudentAdmissionDetails studentAdmission) {
        _submissionDetails.setValue(studentAdmission);
    }

}