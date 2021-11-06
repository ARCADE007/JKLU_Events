package com.example.jkluevents.ui.coding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CodingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CodingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is coding fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}