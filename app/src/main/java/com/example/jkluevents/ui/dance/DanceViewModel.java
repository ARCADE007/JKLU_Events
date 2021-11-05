package com.example.jkluevents.ui.dance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DanceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DanceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dance fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
