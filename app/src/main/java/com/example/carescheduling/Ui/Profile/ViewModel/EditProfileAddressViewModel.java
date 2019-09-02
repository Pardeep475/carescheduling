package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.Profile.View.EditProfile;
import com.example.carescheduling.Ui.Profile.bean.EditAddressAllData;
import com.example.carescheduling.Ui.Profile.bean.EditAllAddressData;
import com.example.carescheduling.Ui.Profile.bean.ImageDataBean;
import com.example.carescheduling.Ui.Profile.bean.PersonAddress;
import com.example.carescheduling.Ui.Profile.bean.PersonAddressList;
import com.example.carescheduling.Ui.Profile.bean.PersonEmailList;
import com.example.carescheduling.Ui.Profile.bean.PersonPhoneList;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Local.DatabaseTable.PersonAllAddressEntity;
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
import androidx.lifecycle.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class EditProfileAddressViewModel extends AndroidViewModel {

    private Context context;
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;

    public EditProfileAddressViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<EditAllAddressData> GetMyAddressEdit(String personId, String customerId, String branchId) {
        final MutableLiveData<EditAllAddressData> data = new MutableLiveData<>();

        Disposable disposable = apiService.GetMyAddressEdit(personId, customerId, branchId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<EditAddressAllData>>() {
                    @Override
                    public void accept(Response<EditAddressAllData> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful() && loginBeanRetroResponse.body().getData() != null) {
                            data.setValue(loginBeanRetroResponse.body().getData());
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

    public LiveData<Boolean> DeleteAddress(PersonAddress personAddressList) {
        final MutableLiveData<Boolean> data = new MutableLiveData<>();

        Disposable disposable = apiService.DeleteAddress(personAddressList)
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

    public LiveData<Boolean> DeletePhone(PersonPhoneList personPhoneList) {
        final MutableLiveData<Boolean> data = new MutableLiveData<>();

        Disposable disposable = apiService.DeletePhone(personPhoneList)
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

    public LiveData<Boolean> DeleteEmail(PersonEmailList personEmailList) {
        final MutableLiveData<Boolean> data = new MutableLiveData<>();

        Disposable disposable = apiService.DeleteEmail(personEmailList)
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

    public LiveData<EditAllAddressData> getDataFromLocal(Context activity) {
        final MutableLiveData<EditAllAddressData> data = new MutableLiveData<>();


        return data;
    }

    public LiveData<ArrayList<PersonAddressList>> getDataFromLocalAddress(Context activity){
        final MutableLiveData<ArrayList<PersonAddressList>> data = new MutableLiveData<>();

        AppDataBase.getAppDatabase(context).profileDao().getAllPersonAllAddressEntity().observe(((EditProfile) activity), new Observer<List<PersonAllAddressEntity>>() {
            @Override
            public void onChanged(List<PersonAllAddressEntity> profileInfo) {
                if (profileInfo != null && profileInfo.size() > 0) {
                    data.setValue(getAddressList(profileInfo));
                }
            }
        });

        return data;
    }

    public LiveData<ArrayList<PersonPhoneList>> getDataFromLocalPhone(Context activity){
        final MutableLiveData<ArrayList<PersonPhoneList>> data = new MutableLiveData<>();
        AppDataBase.getAppDatabase(context).profileDao().getAllPersonPhoneList().observe(((EditProfile) activity), new Observer<List<PersonPhoneList>>() {
            @Override
            public void onChanged(List<PersonPhoneList> profileInfo) {
                if (profileInfo != null && profileInfo.size() > 0) {
                    ArrayList<PersonPhoneList> arrayList = new ArrayList<>(profileInfo);
                    data.setValue(arrayList);
                }
            }
        });

        return data;
    }

    public LiveData<ArrayList<PersonEmailList>> getDataFromLocalEmail(Context activity){
        final MutableLiveData<ArrayList<PersonEmailList>> data = new MutableLiveData<>();
        AppDataBase.getAppDatabase(context).profileDao().getAllPersonEmailList().observe(((EditProfile) activity), new Observer<List<PersonEmailList>>() {
            @Override
            public void onChanged(List<PersonEmailList> profileInfo) {
                if (profileInfo != null && profileInfo.size() > 0) {
                    ArrayList<PersonEmailList> arrayList = new ArrayList<>(profileInfo);
                    data.setValue(arrayList);
                }
            }
        });

        return data;
    }


    private ArrayList<PersonAddressList> getAddressList(List<PersonAllAddressEntity> profileInfo) {
        ArrayList<PersonAddressList> personAddressLists = new ArrayList<>();
        for (int i = 0; i < profileInfo.size(); i++) {
            PersonAllAddressEntity personAllAddressEntity = profileInfo.get(i);
            PersonAddressList personAddressList = new PersonAddressList();
            personAddressList.setCountryCode(personAllAddressEntity.getCountryCode());
            personAddressList.setDefaultAddress(personAllAddressEntity.getDefaultAddress());
            personAddressList.setDefaultAddress(personAllAddressEntity.getDefaultAddress());
            personAddressList.setAddressTypeName(personAllAddressEntity.getAddressTypeName());
            PersonAddress personAddress = new PersonAddress();
            personAddress.setAddressId(personAllAddressEntity.getAddressId());
            personAddress.setAddressTypeName(personAllAddressEntity.getAddressTypeName());
            personAddress.setIsDefaultAddress(personAllAddressEntity.getDefaultAddress());
            personAddress.setCustomerId(personAddress.getCustomerId());
            personAddress.setPersonId(personAddress.getPersonId());
            personAddressList.setPersonAddress(personAddress);
            personAddressLists.add(personAddressList);
        }
        return personAddressLists;
    }

    private String checkIsNotNull(String value) {
        return value != null ? value : "";
    }
}
