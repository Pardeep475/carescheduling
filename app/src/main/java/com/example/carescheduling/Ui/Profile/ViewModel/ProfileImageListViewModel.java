package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.bean.ProfileImageList;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ProfileImageListViewModel extends AndroidViewModel {

    public ProfileImageListViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<ProfileImageList>> getImagePath(ProfileBean profileBean) {
        MutableLiveData<ArrayList<ProfileImageList>> mutableLiveData = new MutableLiveData<>();
        ArrayList<ProfileImageList> profileImageLists = new ArrayList<>();

        if (profileBean != null && profileBean.getData() != null && profileBean.getData().getPersonImage() != null) {
            for (int i = 0; i < profileBean.getData().getPersonImage().size(); i++) {
                ProfileImageList profileImageList = new ProfileImageList();
                profileImageList.setDefault(profileBean.getData().getPersonImage().get(i).isDefault());
                profileImageList.setImageBitMap(ImageFromBase64(profileBean.getData().getPersonImage().get(i).getImageHexString()));
                profileImageLists.add(profileImageList);
            }
        }


        mutableLiveData.setValue(profileImageLists);
        return mutableLiveData;
    }

    private Bitmap ImageFromBase64(String img) {
        byte[] decodedString = Base64.decode(img, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
}
