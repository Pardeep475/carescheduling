package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.content.Context;

import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Local.DatabaseInitializer;
import com.example.carescheduling.data.Local.DatabaseTable.Ethnicity;
import com.example.carescheduling.data.Local.DatabaseTable.Gender;
import com.example.carescheduling.data.Local.DatabaseTable.MaritialStatus;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Local.DatabaseTable.Prefix;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class EditProfileInfoViewModel extends AndroidViewModel {
    private Context context;


    public EditProfileInfoViewModel(@NonNull Application application) {
        super(application);
        this.context = application;

    }

    public MutableLiveData<String> datePicker(String date) {
        final MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(date);
        return mutableLiveData;
    }

    public LiveData<List<PersonLanguage>> getPersonLanguage(){
        return DatabaseInitializer.loadLanguages(AppDataBase.getAppDatabase(context));
    }
    public LiveData<List<Ethnicity>> getEthnicity(){
        return DatabaseInitializer.loadEthnicity(AppDataBase.getAppDatabase(context));
    }
    public LiveData<List<Gender>> getGender(){
        return DatabaseInitializer.loadGender(AppDataBase.getAppDatabase(context));
    }
    public LiveData<List<MaritialStatus>> getMaritalStatus(){
        return DatabaseInitializer.loadMaritialStatus(AppDataBase.getAppDatabase(context));
    }
    public LiveData<List<Prefix>> getPrefix(){
        return DatabaseInitializer.loadPrefix(AppDataBase.getAppDatabase(context));
    }
}
