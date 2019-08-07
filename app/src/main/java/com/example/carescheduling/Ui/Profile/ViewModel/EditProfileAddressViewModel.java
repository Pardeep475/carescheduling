package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.View.EditProfileAddress;
import com.example.carescheduling.Ui.Profile.bean.AddAddressBeanRetro;
import com.example.carescheduling.Ui.Profile.bean.EditAddressAllData;
import com.example.carescheduling.Ui.Profile.bean.EditAdressBeanRetro;
import com.example.carescheduling.Ui.Profile.bean.EditProfileAddressBean;
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBean;
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBeanRetro;
import com.example.carescheduling.Ui.Profile.bean.GetMyProfileEdit;
import com.example.carescheduling.Ui.Profile.bean.PersonAddressList;
import com.example.carescheduling.Ui.Profile.bean.PersonEmailList;
import com.example.carescheduling.Ui.Profile.bean.PersonPhoneList;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Local.DatabaseInitializer;
import com.example.carescheduling.data.Local.DatabaseTable.PhoneType;
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

    public LiveData<EditAddressAllData.Data> GetMyAddressEdit(String personId, String customerId, String branchId) {
        final MutableLiveData<EditAddressAllData.Data> data = new MutableLiveData<>();

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

    public LiveData<Boolean> DeleteAddress(PersonAddressList.PersonAddress personAddressList) {
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


    private String checkIsNotNull(String value) {
        return value != null ? value : "";
    }
}
