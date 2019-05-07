package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.bean.AddressByPostCode;
import com.example.carescheduling.Ui.Profile.bean.ProfileAddressBean;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Local.DatabaseInitializer;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;

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

public class ProfileAddressViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public ProfileAddressViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<List<Nationality>> getNationality() {
        return DatabaseInitializer.loadNationality(AppDataBase.getAppDatabase(context));
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
                    profileAddressBean.setTown(checkIsNotNull(profileBean.getData().getPersonAddresses().get(i).getCountryPostCode().getPostTownName()));
                }
            }
            profileAddressBeanMutableLiveData.setValue(profileAddressBean);
        }
        return profileAddressBeanMutableLiveData;
    }

    private String checkIsNotNull(String value) {
        return value != null ? value : "";
    }

    public LiveData<ProfileAddressBean> getAddressByPostCode(String value, ProfileBean profileBean) {
        String country = null, postalCode = null;
        if (profileBean != null && profileBean.getData() != null) {
            for (int i = 0; i < profileBean.getData().getPersonAddresses().size(); i++) {
                if (profileBean.getData().getPersonAddresses().get(i).getAddressTypeName().equalsIgnoreCase(value)) {
                    country = profileBean.getData().getPersonAddresses().get(i).getCountryPostCode().getCountryName();
                    postalCode = profileBean.getData().getPersonAddresses().get(i).getCountryPostCode().getPostCodeName();
                }
            }
        }

        final MutableLiveData<ProfileAddressBean> profileAddressBeanMutableLiveData = new MutableLiveData<>();
        if (country != null && postalCode != null) {
            Disposable disposable = apiService.fetchAddressByPostalCode(country, postalCode)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<AddressByPostCode>>() {
                        @Override
                        public void accept(Response<AddressByPostCode> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful()) {
                                if (loginBeanRetroResponse.body() != null && loginBeanRetroResponse.body().getData() != null && loginBeanRetroResponse.body().getData().getCountryPostCode() != null) {
                                    ProfileAddressBean profileAddressBean = new ProfileAddressBean();
                                    for (int i = 0; i < loginBeanRetroResponse.body().getData().getCountryPostCode().getAddress().size(); i++) {
                                        profileAddressBean.setPostCode(checkIsNotNull(loginBeanRetroResponse.body().getData().getCountryPostCode().getAddress().get(0).getPostCodeName()));
                                        profileAddressBean.setStreetName(checkIsNotNull(loginBeanRetroResponse.body().getData().getCountryPostCode().getAddress().get(0).getStreetName()));
                                        profileAddressBean.setCountry(checkIsNotNull(loginBeanRetroResponse.body().getData().getCountryPostCode().getAddress().get(0).getCountryName()));
                                        profileAddressBean.setHouseName(checkIsNotNull(loginBeanRetroResponse.body().getData().getCountryPostCode().getAddress().get(0).getBuildingName()));
                                        profileAddressBean.setHouseNumber(checkIsNotNull(loginBeanRetroResponse.body().getData().getCountryPostCode().getAddress().get(0).getBuildingNumber()));
                                        profileAddressBean.setTown(checkIsNotNull(loginBeanRetroResponse.body().getData().getCountryPostCode().getPostTownName()));
                                    }
                                    profileAddressBeanMutableLiveData.setValue(profileAddressBean);
                                }
                            } else {
                                profileAddressBeanMutableLiveData.setValue(null);
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Log.e("LoginSuccess", "error" + throwable.toString());
                            profileAddressBeanMutableLiveData.setValue(null);
                        }
                    });
            compositeDisposable.add(disposable);
        }
        return profileAddressBeanMutableLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

}
