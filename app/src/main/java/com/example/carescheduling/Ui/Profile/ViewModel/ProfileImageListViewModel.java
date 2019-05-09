package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.bean.ProfileImageList;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ProfileImageListViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    public ProfileImageListViewModel(@NonNull Application application) {
        super(application);
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
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

    public LiveData<ProfileBean> getEditProfilePost(ProfileBean.Data profileBean) {
        final MutableLiveData<ProfileBean> data = new MutableLiveData<>();

        Disposable disposable = apiService.editMyProfilePost(profileBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ProfileBean>>() {
                    @Override
                    public void accept(Response<ProfileBean> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful()) {
                            data.setValue(loginBeanRetroResponse.body());
                        } else {
                            data.setValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("LoginSuccess", "error" + throwable.toString());
                        data.setValue(null);
                    }
                });
        compositeDisposable.add(disposable);
        return data;
    }



    private Bitmap ImageFromBase64(String img) {
        byte[] decodedString = Base64.decode(img, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    public String ConvertBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
