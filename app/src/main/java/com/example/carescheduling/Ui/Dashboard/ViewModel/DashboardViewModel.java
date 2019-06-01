package com.example.carescheduling.Ui.Dashboard.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.Dashboard.beans.EditMyProfile;
import com.example.carescheduling.Ui.LoginActivity.beans.LoginBeanRetro;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;

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

public class DashboardViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public DashboardViewModel(@NonNull Application application) {
        super(application);
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
        context = application;
    }

    public LiveData<EditMyProfile> getEditMyProfileData(String customerId) {
        final MutableLiveData<EditMyProfile> data = new MutableLiveData<>();

        Disposable disposable = apiService.editMyProfile(customerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<EditMyProfile>>() {
                    @Override
                    public void accept(Response<EditMyProfile> editMyProfileResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (editMyProfileResponse.isSuccessful() && editMyProfileResponse.body() != null) {
                            Toast.makeText(context, (String) editMyProfileResponse.body().getResponseMessage(), Toast.LENGTH_SHORT).show();
                            if (editMyProfileResponse.body().getData() != null) {
                                data.setValue(editMyProfileResponse.body());
                            } else {
                                data.setValue(null);
                            }
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
