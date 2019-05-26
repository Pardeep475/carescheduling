package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.util.Log;

import com.example.carescheduling.Ui.Profile.bean.UserViewModel;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;
import com.google.gson.JsonElement;

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

public class ChangePasswordViewModel extends AndroidViewModel {
    private ApiService apiService;
    private CompositeDisposable compositeDisposable;

    public ChangePasswordViewModel(@NonNull Application application) {
        super(application);
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<String> EditUserInfo(UserViewModel.Data userViewModel) {
        final MutableLiveData<String> data = new MutableLiveData<>();

        Disposable disposable = apiService.EditMyUser(userViewModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<JsonElement>>() {
                    @Override
                    public void accept(Response<JsonElement> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful()) {
                            data.setValue("Your data saved successfully");
                        } else {
                            data.setValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("LoginSuccess", "error" + throwable.toString());
                        data.setValue(throwable.toString());
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
