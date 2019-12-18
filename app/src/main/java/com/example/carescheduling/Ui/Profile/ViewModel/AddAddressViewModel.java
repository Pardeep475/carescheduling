package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.Profile.bean.AddAddressBeanRetro;
import com.example.carescheduling.Ui.Profile.bean.AddressByPostCode;
import com.example.carescheduling.Ui.Profile.bean.AddressData;
import com.example.carescheduling.Ui.Profile.bean.ProfileAddressBean;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Local.DatabaseInitializer;
import com.example.carescheduling.data.Local.DatabaseTable.AddressType;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;
import com.google.gson.JsonElement;

import org.json.JSONObject;

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

public class AddAddressViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public AddAddressViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<List<Nationality>> getNationality() {
        return DatabaseInitializer.loadNationality(AppDataBase.getAppDatabase(context));
    }

    public LiveData<List<AddressType>> getAddressType() {
        return DatabaseInitializer.loadAddressType(AppDataBase.getAppDatabase(context));
    }


    private String checkIsNotNull(String value) {
        return value != null ? value : "";
    }

    public LiveData<AddressByPostCode> getAddressByPostCode(String value,  String postCode) {
        String  postalCode = postCode;

        final MutableLiveData<AddressByPostCode> profileAddressBeanMutableLiveData = new MutableLiveData<>();

        if (value != null && postalCode != null) {
            Disposable disposable = apiService.fetchAddressByPostalCode(value, postalCode)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<AddressByPostCode>>() {
                        @Override
                        public void accept(Response<AddressByPostCode> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful() && loginBeanRetroResponse.body() != null
                                    && loginBeanRetroResponse.body().getData() != null
                                    && loginBeanRetroResponse.body().getData().getCountryPostCode() != null) {
                                profileAddressBeanMutableLiveData.setValue(loginBeanRetroResponse.body());

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


    public LiveData<ArrayList<AddressData>> FetchAddressSpinnerData(AddressByPostCode addressByPostCode) {
        MutableLiveData<ArrayList<AddressData>> stringMutableLiveData = new MutableLiveData<>();
        ArrayList<AddressData> stringArrayList = new ArrayList<>();
        for (int i = 0; i < addressByPostCode.getData().getCountryPostCode().getAddress().size(); i++) {
            AddressData addressData = new AddressData();
            if (addressByPostCode.getData().getCountryPostCode().getAddress().get(i).getOrganisationName() != null)
            addressData.setAddressType(addressByPostCode.getData().getCountryPostCode().getAddress().get(i).getOrganisationName());
            else{
                addressData.setAddressType(addressByPostCode.getData().getCountryPostCode().getAddress().get(i).getStreetName());
            }
            addressData.setAddressId(addressByPostCode.getData().getCountryPostCode().getAddress().get(i).getAddressId());

            stringArrayList.add(addressData);
        }
        stringMutableLiveData.setValue(stringArrayList);
        return stringMutableLiveData;
    }

    public LiveData<ArrayList<ProfileAddressBean>> FetchAddressSpinnerContent(AddressByPostCode addressByPostCode) {
        MutableLiveData<ArrayList<ProfileAddressBean>> stringMutableLiveData = new MutableLiveData<>();
        ArrayList<ProfileAddressBean> profileAddressBeanArrayList = new ArrayList<>();

        for (int i = 0; i < addressByPostCode.getData().getCountryPostCode().getAddress().size(); i++) {
            ProfileAddressBean profileAddressBean = new ProfileAddressBean();
            profileAddressBean.setPostCode(checkIsNotNull(addressByPostCode.getData().getCountryPostCode().getAddress().get(0).getPostCodeName()));
            profileAddressBean.setStreetName(checkIsNotNull(addressByPostCode.getData().getCountryPostCode().getAddress().get(0).getStreetName()));
            profileAddressBean.setCountry(checkIsNotNull(addressByPostCode.getData().getCountryPostCode().getAddress().get(0).getCountryName()));
            profileAddressBean.setHouseName(checkIsNotNull(addressByPostCode.getData().getCountryPostCode().getAddress().get(0).getBuildingName()));
            profileAddressBean.setHouseNumber(checkIsNotNull(addressByPostCode.getData().getCountryPostCode().getAddress().get(0).getBuildingNumber()));
            profileAddressBean.setTown(checkIsNotNull(addressByPostCode.getData().getCountryPostCode().getPostTownName()));
            profileAddressBeanArrayList.add(profileAddressBean);
        }
        stringMutableLiveData.setValue(profileAddressBeanArrayList);
        return stringMutableLiveData;
    }





    public LiveData<Boolean> AddAddress(AddAddressBeanRetro addAddressBeanRetro) {
        final MutableLiveData<Boolean> data = new MutableLiveData<>();

        Disposable disposable = apiService.AddAddress(addAddressBeanRetro)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<JsonElement>>() {
                    @Override
                    public void accept(Response<JsonElement> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful()) {
                            JSONObject jsonObject = new JSONObject(loginBeanRetroResponse.body().toString());
                            boolean isSuccess = jsonObject.getBoolean("Success");
                            data.setValue(isSuccess);
                            if (jsonObject.getString("ResponseMessage") != null)
                                Toast.makeText(context, jsonObject.getString("ResponseMessage"), Toast.LENGTH_SHORT).show();

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


    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

}
