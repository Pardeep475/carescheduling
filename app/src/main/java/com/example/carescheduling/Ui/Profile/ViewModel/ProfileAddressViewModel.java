package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.bean.ProfileAddressBean;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ProfileAddressViewModel extends AndroidViewModel {

    public ProfileAddressViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ProfileAddressBean> getProfileAddressBean(String value, ProfileBean profileBean) {
        MutableLiveData<ProfileAddressBean> profileAddressBeanMutableLiveData = new MutableLiveData<>();
        ProfileAddressBean profileAddressBean = new ProfileAddressBean();
        if (profileBean != null && profileBean.getData() != null) {
            for (int i = 0; i < profileBean.getData().getPersonAddresses().size(); i++) {
                if (value.equalsIgnoreCase(profileBean.getData().getPersonAddresses().get(i).getAddressTypeName())) {
                    profileAddressBean.setPostCode(checkIsNotNull(profileBean.getData().getPersonAddresses().get(i).getAddress().getPostCodeName()));
                    profileAddressBean.setStreetName(checkIsNotNull(profileBean.getData().getPersonAddresses().get(i).getAddress().getStreetName()));
                    profileAddressBean.setCountry(checkIsNotNull(profileBean.getData().getPersonAddresses().get(i).getAddress().getCountryName()));
                    profileAddressBean.setHouseName(checkIsNotNull(profileBean.getData().getPersonAddresses().get(i).getAddress().getBuildingName()));
                    profileAddressBean.setHouseNumber(checkIsNotNull(profileBean.getData().getPersonAddresses().get(i).getAddress().getBuildingNumber()));
                }
            }
            profileAddressBeanMutableLiveData.setValue(profileAddressBean);
        }
        return profileAddressBeanMutableLiveData;
    }

    private String checkIsNotNull(String value) {
        return value != null ? value : "";
    }
}
