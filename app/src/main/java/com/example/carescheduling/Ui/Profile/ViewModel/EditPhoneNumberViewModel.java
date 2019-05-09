package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.bean.EditPhoneNumberBean;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Local.DatabaseInitializer;
import com.example.carescheduling.data.Local.DatabaseTable.CountryCode;
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

public class EditPhoneNumberViewModel extends AndroidViewModel {
    private Context context;
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    public EditPhoneNumberViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<List<CountryCode>> getCountryCode() {
        return DatabaseInitializer.loadCountryCode(AppDataBase.getAppDatabase(context));
    }

    public LiveData<EditPhoneNumberBean> getEditPhoneNumberBean(String value, ProfileBean profileBean) {
        MutableLiveData<EditPhoneNumberBean> editPhoneNumberBeanMutableLiveData = new MutableLiveData<>();
        EditPhoneNumberBean editPhoneNumberBean = new EditPhoneNumberBean();

        if (profileBean != null && profileBean.getData() != null && profileBean.getData().getPerson() != null) {
            for (int i = 0; i < profileBean.getData().getPerson().getPersonPhone().size(); i++) {
                if (value.equalsIgnoreCase(profileBean.getData().getPerson().getPersonPhone().get(i).getPhoneTypeName())) {
                    editPhoneNumberBean.setDefault(profileBean.getData().getPerson().getPersonPhone().get(i).getIsDefaultPhone());
                    editPhoneNumberBean.setPhoneNumber(profileBean.getData().getPerson().getPersonPhone().get(i).getPhoneNumber());
                    editPhoneNumberBean.setCountryCode(profileBean.getData().getPerson().getPersonPhone().get(i).getCountryTelephonePrefix());
                }
            }
            editPhoneNumberBeanMutableLiveData.setValue(editPhoneNumberBean);
        }

        return editPhoneNumberBeanMutableLiveData;
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

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

}
