package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.bean.DataList;
import com.example.carescheduling.Ui.Profile.bean.ProfileImageList;
import com.example.carescheduling.Ui.Profile.bean.ProfileImageRetro;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;
import com.google.gson.JsonElement;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

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
    private Context context;

    public ProfileImageListViewModel(@NonNull Application application) {
        super(application);
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<ArrayList<ProfileImageList>> getImagePath(ProfileImageRetro profileBean) {
        MutableLiveData<ArrayList<ProfileImageList>> mutableLiveData = new MutableLiveData<>();
        ArrayList<ProfileImageList> profileImageLists = new ArrayList<>();

        if (profileBean != null && profileBean.getDataList() != null && profileBean.getDataList().size() > 0) {
            for (int i = 0; i < profileBean.getDataList().size(); i++) {
                ProfileImageList profileImageList = new ProfileImageList();
                profileImageList.setDefault(profileBean.getDataList().get(i).getIsDefault());
                profileImageList.setImageBitMap(ImageFromBase64(profileBean.getDataList().get(i).getImage().getImageHexString()));
                profileImageLists.add(profileImageList);
            }
        }
        mutableLiveData.setValue(profileImageLists);
        return mutableLiveData;
    }


    public LiveData<ProfileImageRetro> getProfileImages(String personId, String customerId, String branchId) {
        final MutableLiveData<ProfileImageRetro> data = new MutableLiveData<>();

        Disposable disposable = apiService.getProfileImages(personId, customerId, branchId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ProfileImageRetro>>() {
                    @Override
                    public void accept(Response<ProfileImageRetro> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful()) {
                            data.setValue(loginBeanRetroResponse.body());
                        } else {
                            data.setValue(null);
                            Toast.makeText(getApplication(), loginBeanRetroResponse.message(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("LoginSuccess", "error" + throwable.toString());
                        data.setValue(null);
                        Toast.makeText(getApplication(), throwable.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        compositeDisposable.add(disposable);
        return data;
    }


    public LiveData<String> getEditProfilePost(ProfileBean.Data profileImageRetro) {
        final MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        Disposable disposable = apiService.EditMyImages(profileImageRetro)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ProfileImageRetro>>() {
                    @Override
                    public void accept(Response<ProfileImageRetro> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful()) {
                            if (loginBeanRetroResponse.body() != null)
                                mutableLiveData.setValue(loginBeanRetroResponse.body().getResponseMessage());
                        } else {
                            mutableLiveData.setValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        mutableLiveData.setValue(throwable.toString());
                    }
                });
        compositeDisposable.add(disposable);

        return mutableLiveData;
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
