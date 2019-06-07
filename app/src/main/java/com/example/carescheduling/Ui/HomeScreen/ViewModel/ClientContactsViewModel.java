package com.example.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.HomeScreen.beans.ClientCareContactsBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientContactsBean;
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

public class ClientContactsViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public ClientContactsViewModel(@NonNull Application application) {
        super(application);
        context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<ArrayList<ClientContactsBean>> getClientContact(String customerId, String branchId, String clientId) {
        final MutableLiveData<ArrayList<ClientContactsBean>> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.GetClientContacts(customerId, branchId, clientId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<ClientCareContactsBean>>() {
                        @Override
                        public void accept(Response<ClientCareContactsBean> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful()) {
                                if (loginBeanRetroResponse.body() != null) {
                                    data.setValue(getClientCareContact(loginBeanRetroResponse.body()));
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

    private ArrayList<ClientContactsBean> getClientCareContact(ClientCareContactsBean careContactsBean) {
        ArrayList<ClientContactsBean> clientContactsBeanArrayList = new ArrayList<>();

        if (careContactsBean.getDataList() != null) {
            for (int i = 0; i < careContactsBean.getDataList().size(); i++) {
                ClientContactsBean clientContactsBean = new ClientContactsBean();
                clientContactsBean.setAddress("N/A");
                clientContactsBean.setEmail("N/A");
                clientContactsBean.setPostCode("N/A");
                clientContactsBean.setMobile("N/A");
                clientContactsBean.setTelephone("N/A");
                clientContactsBean.setType(checkIsNotNull(careContactsBean.getDataList().get(i).getContactTypeName()));
                clientContactsBean.setName("N/A");

                clientContactsBeanArrayList.add(clientContactsBean);
            }
        }
        return clientContactsBeanArrayList;
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