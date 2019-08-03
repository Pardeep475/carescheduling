package com.example.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.HomeScreen.View.ClientInfoPersonalDetails;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCarePersonalDetailsBean;
import com.example.carescheduling.Ui.Profile.View.EditProfileInfo;
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBean;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ClientInfoPersonalDetailsViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public ClientInfoPersonalDetailsViewModel(@NonNull Application application) {
        super(application);
        context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<EditProfileInfoBean> getProfileDetails(String customerId, String branchId, String clientId) {
        final MutableLiveData<EditProfileInfoBean> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.GetClientPersonDetail(customerId, branchId, clientId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<ClientCarePersonalDetailsBean>>() {
                        @Override
                        public void accept(Response<ClientCarePersonalDetailsBean> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful()) {
                                if (loginBeanRetroResponse.body() != null) {
                                    data.setValue(getProfileData(loginBeanRetroResponse.body()));

                                } else {
                                    data.setValue(null);
                                    Toast.makeText(getApplication(), (String) loginBeanRetroResponse.body().getResponseMessage(), Toast.LENGTH_SHORT).show();
                                }
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
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
        return data;
    }


    private EditProfileInfoBean getProfileData(ClientCarePersonalDetailsBean clientCarePersonalDetailsBean) {
        EditProfileInfoBean editProfileInfoBean = new EditProfileInfoBean();
        if (clientCarePersonalDetailsBean.getData() != null) {
            editProfileInfoBean.setFirstName(checkIsNotNull(clientCarePersonalDetailsBean.getData().getFirstName()));
            editProfileInfoBean.setMiddleName(checkIsNotNull((String) clientCarePersonalDetailsBean.getData().getMiddleName()));
            editProfileInfoBean.setMaidenName(checkIsNotNull((String) clientCarePersonalDetailsBean.getData().getMaidenName()));
            editProfileInfoBean.setSurName(checkIsNotNull(clientCarePersonalDetailsBean.getData().getSurname()));
            editProfileInfoBean.setDateOfBirth(checkIsNotNull(clientCarePersonalDetailsBean.getData().getDateOfBirth()));
//            editProfileInfoBean.setGender(checkIsNotNull(clientCarePersonalDetailsBean.getData().getGenderTypeName()));
            editProfileInfoBean.setGender("N/A");
            editProfileInfoBean.setPrefix(checkIsNotNull(clientCarePersonalDetailsBean.getData().getPrefixTypeName()));
            editProfileInfoBean.setLanguage(checkIsNotNull(clientCarePersonalDetailsBean.getData().getLanguageName()));
            editProfileInfoBean.setNationality(checkIsNotNull(clientCarePersonalDetailsBean.getData().getNationality()));


// marital status
            editProfileInfoBean.setMaritalStatus(checkIsNotNull(clientCarePersonalDetailsBean.getData().getMaritialStatus()));
            // ethnicity
            editProfileInfoBean.setEthnicity(checkIsNotNull(clientCarePersonalDetailsBean.getData().getEthnicity()));
            // disability
            editProfileInfoBean.setDisability(false);
            editProfileInfoBean.setDisabaility(checkIsNotNull(clientCarePersonalDetailsBean.getData().getDisability()));
// religion
            editProfileInfoBean.setReligion(checkIsNotNull(clientCarePersonalDetailsBean.getData().getReligion()));
            editProfileInfoBean.setSexuality(checkIsNotNull(clientCarePersonalDetailsBean.getData().getSexuality()));


        }


        return editProfileInfoBean;
    }

    private String checkIsNotNull(String value) {
        return value != null && !value.equalsIgnoreCase("") ? value : "N/A";
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}