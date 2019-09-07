package com.example.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.Dashboard.beans.ClientDisabilityList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientDocumentList;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientDisabilityBean;
import com.example.carescheduling.Ui.Profile.View.EditProfile;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ClientDisabilitiesViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public ClientDisabilitiesViewModel(@NonNull Application application) {
        super(application);
        context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<ArrayList<ClientDisabilityList>> getDisabilities(String customerId, String branchId, String clientId) {
        final MutableLiveData<ArrayList<ClientDisabilityList>> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.GetClientDisabilities(customerId,branchId,clientId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<ClientDisabilityBean>>() {
                        @Override
                        public void accept(Response<ClientDisabilityBean> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful()) {
                                if (loginBeanRetroResponse.body()!=null){
                                    data.setValue(loginBeanRetroResponse.body().getDataList());
                                }else{
                                    data.setValue(null);
                                    Toast.makeText(getApplication(),(String) loginBeanRetroResponse.body().getResponseMessage(), Toast.LENGTH_SHORT).show();
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

    public LiveData<ArrayList<ClientDisabilityList>> getDataFromLocal(Context activity, String bookingId){
        final MutableLiveData<ArrayList<ClientDisabilityList>> data = new MutableLiveData<>();

        AppDataBase.getAppDatabase(getApplication()).homeDeo().getAllClientDisabilityList(bookingId).observe(((EditProfile) activity), new Observer<List<ClientDisabilityList>>() {
            @Override
            public void onChanged(List<ClientDisabilityList> clientDisabilityLists) {
                if (clientDisabilityLists != null) {
                    data.setValue(getClientAdapterBean(clientDisabilityLists));
                }else{
                    data.setValue(null);
                }
            }
        });


        return data;
    }


    private ArrayList<ClientDisabilityList> getClientAdapterBean(List<ClientDisabilityList>clientCareNoteBean) {
        ArrayList<ClientDisabilityList> noteAdapterBeans = new ArrayList<>();

        for (int i = 0; i < clientCareNoteBean.size(); i++) {
            ClientDisabilityList clientNoteAdapterBean = new ClientDisabilityList();
            clientNoteAdapterBean.setDate(checkIsNotNull(clientCareNoteBean.get(i).getDate()));
            clientNoteAdapterBean.setDescription(checkIsNotNull(clientCareNoteBean.get(i).getDescription()));
            clientNoteAdapterBean.setBookingId(checkIsNotNull(clientCareNoteBean.get(i).getBookingId()));
            clientNoteAdapterBean.setDisabilitesName(checkIsNotNull(clientCareNoteBean.get(i).getDisabilitesName()));
//                clientNoteAdapterBean.setDescription(checkIsNotNull(clientCareNoteBean.get(i).getDocument().getDocumentFile()));
//                clientNoteAdapterBean.setShortDescription(checkIsNotNull(clientCareNoteBean.get(i).getDocument().getDocumentTypeName()));

            noteAdapterBeans.add(clientNoteAdapterBean);
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
