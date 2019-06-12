package com.example.carescheduling.Ui.Dashboard.ViewModel;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.Dashboard.beans.ClientBookingListModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCarePlan;
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

public class HomeFViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;

    public HomeFViewModel(@NonNull Application application) {
        super(application);
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<ClientBookingListModel> getClientBookingList(String employeeId, String branchId, String customerId) {
        final MutableLiveData<ClientBookingListModel> data = new MutableLiveData<>();

        Disposable disposable = apiService.GetNextVisitClientBookingList(employeeId, branchId, customerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ClientBookingListModel>>() {
                    @Override
                    public void accept(Response<ClientBookingListModel> loginBeanRetroResponse) throws Exception {
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


    public LiveData<ClientCarePlan> GetClientAndClientCarePlan(String customerId, String branchId, String clientId) {
        final MutableLiveData<ClientCarePlan> data = new MutableLiveData<>();

        Disposable disposable = apiService.GetClientAndClientCarePlan(customerId, branchId, clientId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ClientCarePlan>>() {
                    @Override
                    public void accept(Response<ClientCarePlan> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful() && loginBeanRetroResponse.body() != null) {
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


    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
