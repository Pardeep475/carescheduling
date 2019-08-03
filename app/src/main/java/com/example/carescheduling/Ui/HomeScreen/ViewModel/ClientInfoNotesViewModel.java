package com.example.carescheduling.Ui.HomeScreen.ViewModel;


import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.HomeScreen.beans.ClientCareNoteBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientNoteAdapterBean;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;

import java.util.ArrayList;

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

public class ClientInfoNotesViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public ClientInfoNotesViewModel(@NonNull Application application) {
        super(application);
        context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<ArrayList<ClientNoteAdapterBean>> getClientNotes(String customerId, String branchId, String clientId) {
        final MutableLiveData<ArrayList<ClientNoteAdapterBean>> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.GetClientNotes(customerId, branchId, clientId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<ClientCareNoteBean>>() {
                        @Override
                        public void accept(Response<ClientCareNoteBean> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful()) {
                                if (loginBeanRetroResponse.body() != null) {
//                                    data.setValue();
                                    data.setValue(getClientAdapterBean(loginBeanRetroResponse.body()));
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

    private ArrayList<ClientNoteAdapterBean> getClientAdapterBean(ClientCareNoteBean clientCareNoteBean) {
        ArrayList<ClientNoteAdapterBean> noteAdapterBeans = new ArrayList<>();
        if (clientCareNoteBean != null && clientCareNoteBean.getDataList() != null) {
            for (int i = 0; i < clientCareNoteBean.getDataList().size(); i++) {
                ClientNoteAdapterBean clientNoteAdapterBean = new ClientNoteAdapterBean();
                clientNoteAdapterBean.setDate(checkIsNotNull(clientCareNoteBean.getDataList().get(i).getDate()));
                clientNoteAdapterBean.setDescription(checkIsNotNull(clientCareNoteBean.getDataList().get(i).getFullNote()));
                clientNoteAdapterBean.setShortDescription(checkIsNotNull(clientCareNoteBean.getDataList().get(i).getTitle()));
                clientNoteAdapterBean.setTitle(checkIsNotNull(clientCareNoteBean.getDataList().get(i).getTitle()));
                clientNoteAdapterBean.setWrittenBy(checkIsNotNull(clientCareNoteBean.getDataList().get(i).getWrittenBy()));

                noteAdapterBeans.add(clientNoteAdapterBean);
            }
        }
        return noteAdapterBeans;
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