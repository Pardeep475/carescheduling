package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ProfileImageListViewModel extends AndroidViewModel {

    public ProfileImageListViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getImagePath(String imgPath){
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(imgPath);
        return mutableLiveData;
    }
}
