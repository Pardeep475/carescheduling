package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import com.example.carescheduling.CustomViews.DatePickerHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
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
}
