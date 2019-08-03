package com.example.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.HomeScreen.beans.ClientCareMedicalBean;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientMedicalBeanAdapter;
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

public class ClientInfoMedicalViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public ClientInfoMedicalViewModel(@NonNull Application application) {
        super(application);
        context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<ArrayList<ClientMedicalBeanAdapter>> getClientMedical(String customerId, String branchId, String clientId) {
        final MutableLiveData<ArrayList<ClientMedicalBeanAdapter>> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.GetClientMedical(customerId, branchId, clientId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<ClientCareMedicalBean>>() {
                        @Override
                        public void accept(Response<ClientCareMedicalBean> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful()) {
                                if (loginBeanRetroResponse.body() != null) {
                                    data.setValue(getMedication(loginBeanRetroResponse.body()));
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

    private ArrayList<ClientMedicalBeanAdapter> getMedication(ClientCareMedicalBean body) {
        ArrayList<ClientMedicalBeanAdapter> clientMedicalBeanAdapters = new ArrayList<>();
        if (body.getDataList() != null) {
            for (int i = 0; i < body.getDataList().size(); i++) {
                ClientMedicalBeanAdapter clientMedicalBeanAdapter = new ClientMedicalBeanAdapter();
                clientMedicalBeanAdapter.setDescription(
                        checkIsNotNullWithOutNA(body.getDataList().get(i).getDescription())
                               /* + " pill in the " +
                                checkIsNotNullWithOutNA(body.getDataList().get(i).getClientMedicationFrequencyModel().getPeriod())*/);
                clientMedicalBeanAdapter.setMedicationName(checkIsNotNull(body.getDataList().get(i).getMedicalName()));
                clientMedicalBeanAdapter.setMedicationQuantity(checkIsNotNullWithOutNA(body.getDataList().get(i).getMedicationQuantity())
                        /*+ checkIsNotNullWithOutNA(body.getDataList().get(i).getClientMedicationFrequencyModel().getMedicationStrenghtUnitName())*/);
                clientMedicalBeanAdapter.setDate(checkIsNotNullWithOutNA(body.getDataList().get(i).getDate()));
                clientMedicalBeanAdapters.add(clientMedicalBeanAdapter);
            }
        }
        return clientMedicalBeanAdapters;
    }


    private String checkIsNotNull(String value) {
        return value != null && !value.equalsIgnoreCase("") && !value.equalsIgnoreCase("null") ? value : "N/A";
    }

    private String checkIsNotNullWithOutNA(String value) {
        return value != null && !value.equalsIgnoreCase("null") ? value : "";
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}