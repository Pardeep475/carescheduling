package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.View.EditProfileAddress;
import com.example.carescheduling.Ui.Profile.bean.EditProfileAddressBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class EditProfileAddressViewModel extends AndroidViewModel {

    public EditProfileAddressViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<EditProfileAddressBean> getEditProfileAddressBean(ProfileBean profileBean) {
        MutableLiveData<EditProfileAddressBean> editProfileAddressBeanMutableLiveData = new MutableLiveData<>();
        EditProfileAddressBean editProfileAddressBean = new EditProfileAddressBean();
//      get person email
        ArrayList<String> personAddress = new ArrayList<>();
        ArrayList<String> personNumber = new ArrayList<>();
        ArrayList<String> personEmail = new ArrayList<>();
//        email
        if (profileBean != null) {
            if (profileBean.getData().getPerson().getPersonEmail().size() > 0) {
                for (int i = 0; i < profileBean.getData().getPerson().getPersonEmail().size(); i++) {
                    personEmail.add(checkIsNotNull(profileBean.getData().getPerson().getPersonEmail().get(i).getEmailTypeName()));
                }
            }
            //   phone number
            if (profileBean.getData().getPerson().getPersonPhone().size() > 0) {
                for (int i = 0; i < profileBean.getData().getPerson().getPersonPhone().size(); i++) {
                    personNumber.add(checkIsNotNull(profileBean.getData().getPerson().getPersonPhone().get(i).getPhoneTypeName()));
                }
            }
//       phone number
            if (profileBean.getData().getPerson().getPersonAddress().size() > 0) {
                for (int i = 0; i < profileBean.getData().getPerson().getPersonAddress().size(); i++) {
                    personAddress.add(checkIsNotNull(profileBean.getData().getPerson().getPersonAddress().get(i).getAddressTypeName()));
                }
            }

            editProfileAddressBean.setAddressArray(personAddress);
            editProfileAddressBean.setPhoneArray(personNumber);
            editProfileAddressBean.setEmailArray(personEmail);

            editProfileAddressBeanMutableLiveData.setValue(editProfileAddressBean);
        }

        return editProfileAddressBeanMutableLiveData;
    }

    private String checkIsNotNull(String value) {
        return value != null ? value : "";
    }
}
