package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.View.EditEmail;
import com.example.carescheduling.Ui.Profile.bean.EditEmailBean;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class EditEmailViewModel extends AndroidViewModel {

    public EditEmailViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<EditEmailBean> getEditEmailBean(String value, ProfileBean profileBean) {
        MutableLiveData<EditEmailBean> editEmailBeanMutableLiveData = new MutableLiveData<>();
        EditEmailBean editEmailBean = new EditEmailBean();

        if (profileBean != null && profileBean.getData() != null && profileBean.getData().getPerson() != null) {
            for (int i = 0; i < profileBean.getData().getPerson().getPersonEmail().size(); i++) {
                if (value.equalsIgnoreCase(profileBean.getData().getPerson().getPersonEmail().get(i).getEmailTypeName())) {
                    editEmailBean.setDefault(profileBean.getData().getPerson().getPersonEmail().get(i).getIsDefaultEmail());
                    editEmailBean.setEmail(profileBean.getData().getPerson().getPersonEmail().get(i).getEmailAddress());
                }
            }
            editEmailBeanMutableLiveData.setValue(editEmailBean);
        }

        return editEmailBeanMutableLiveData;
    }
}
