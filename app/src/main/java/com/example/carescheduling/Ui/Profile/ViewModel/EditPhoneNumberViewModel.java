package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.content.Context;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.bean.EditPhoneNumberBean;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Local.DatabaseInitializer;
import com.example.carescheduling.data.Local.DatabaseTable.CountryCode;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class EditPhoneNumberViewModel extends AndroidViewModel {
    private Context context;

    public EditPhoneNumberViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
    }

    public LiveData<List<CountryCode>> getCountryCode() {
        return DatabaseInitializer.loadCountryCode(AppDataBase.getAppDatabase(context));
    }

    public LiveData<EditPhoneNumberBean> getEditPhoneNumberBean(String value, ProfileBean profileBean) {
        MutableLiveData<EditPhoneNumberBean> editPhoneNumberBeanMutableLiveData = new MutableLiveData<>();
        EditPhoneNumberBean editPhoneNumberBean = new EditPhoneNumberBean();

        if (profileBean != null && profileBean.getData() != null && profileBean.getData().getPerson() != null) {
            for (int i = 0; i < profileBean.getData().getPerson().getPersonPhone().size(); i++) {
                if (value.equalsIgnoreCase(profileBean.getData().getPerson().getPersonPhone().get(i).getPhoneTypeName())) {
                    editPhoneNumberBean.setDefault(profileBean.getData().getPerson().getPersonPhone().get(i).getIsDefaultPhone());
                    editPhoneNumberBean.setPhoneNumber(profileBean.getData().getPerson().getPersonPhone().get(i).getPhoneNumber());
                    editPhoneNumberBean.setCountryCode(profileBean.getData().getPerson().getPersonPhone().get(i).getCountryTelephonePrefix());
                }
            }
            editPhoneNumberBeanMutableLiveData.setValue(editPhoneNumberBean);
        }

        return editPhoneNumberBeanMutableLiveData;
    }
}
