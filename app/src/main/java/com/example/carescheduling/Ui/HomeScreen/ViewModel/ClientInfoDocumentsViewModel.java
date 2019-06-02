package com.example.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.HomeScreen.beans.ClientCareDocumentBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientNoteAdapterBean;
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

public class ClientInfoDocumentsViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public ClientInfoDocumentsViewModel(@NonNull Application application) {
        super(application);
        context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<ArrayList<ClientNoteAdapterBean>> getClientDocument(String customerId, String branchId, String clientId) {
        final MutableLiveData<ArrayList<ClientNoteAdapterBean>> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.GetClientDocuments(customerId, branchId, clientId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<ClientCareDocumentBean>>() {
                        @Override
                        public void accept(Response<ClientCareDocumentBean> loginBeanRetroResponse) throws Exception {
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

    private ArrayList<ClientNoteAdapterBean> getClientAdapterBean(ClientCareDocumentBean clientCareNoteBean) {
        ArrayList<ClientNoteAdapterBean> noteAdapterBeans = new ArrayList<>();
        if (clientCareNoteBean != null && clientCareNoteBean.getData() != null) {
            for (int i = 0; i < clientCareNoteBean.getData().size(); i++) {
                ClientNoteAdapterBean clientNoteAdapterBean = new ClientNoteAdapterBean();
                clientNoteAdapterBean.setDate(checkIsNotNull(clientCareNoteBean.getData().get(i).getDocument().getDocumentAdded()));
                clientNoteAdapterBean.setDescription(checkIsNotNull(clientCareNoteBean.getData().get(i).getDocument().getDocumentFile()));
                clientNoteAdapterBean.setShortDescription(checkIsNotNull(clientCareNoteBean.getData().get(i).getDocument().getDocumentTypeName()));
                clientNoteAdapterBean.setTitle(checkIsNotNull(clientCareNoteBean.getData().get(i).getDocument().getDocumentCategoryName()));

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