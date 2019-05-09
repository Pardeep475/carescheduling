package com.example.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VisitArchiveViewModel extends AndroidViewModel {
    public VisitArchiveViewModel(@NonNull Application application) {
        super(application);
    }
    public MutableLiveData<String> datePicker(String date) {
        final MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(date);
        return mutableLiveData;
    }
}
