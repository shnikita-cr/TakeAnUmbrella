package com.example.takeanumbrella.ui.umbrellas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UmbrellasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public UmbrellasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is umbrellas fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}