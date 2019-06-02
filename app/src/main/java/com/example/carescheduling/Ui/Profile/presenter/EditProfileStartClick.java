package com.example.carescheduling.Ui.Profile.presenter;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;

public interface EditProfileStartClick {
    void EditMyProfileInfo(ProfileBean profileResultBean);
    void EditMyAddress(ProfileBean profileResultBean);
    void EditMyPicture(ProfileBean profileResultBean);
    void EditChangePassword(ProfileBean profileResultBean);
}
