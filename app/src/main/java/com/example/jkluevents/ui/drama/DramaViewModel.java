package com.example.jkluevents.ui.drama;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DramaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DramaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is drama fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

