package com.example.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
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
                clientContactsBean.setEmail(checkIsNotNull(careContactsBean.getDataList().get(i).getEmailAddress()));
                clientContactsBean.setMobile(checkIsNotNull(careContactsBean.getDataList().get(i).getMobileNumber()));
                clientContactsBean.setTelephone("N/A");
                clientContactsBean.setType(checkIsNotNull(careContactsBean.getDataList().get(i).getContactTypeName()));
                clientContactsBean.setName(checkIsNotNull(careContactsBean.getDataList().get(i).getContactPersonName()));
                if (!checkIsNotNullWithOutNA(careContactsBean.getDataList().get(i).getImageHexString()).equalsIgnoreCase(""))
                    clientContactsBean.setImage(ImageFromBase64(careContactsBean.getDataList().get(i).getImageHexString()));

                if (careContactsBean.getDataList().get(i).getAddress() != null) {
                    clientContactsBean.setPostCode(checkIsNotNull(careContactsBean.getDataList().get(i).getAddress().getPostCodeName()));
                    String address = checkIsNotNullWithOutNA(careContactsBean.getDataList().get(i).getAddress().getBuildingName()) + " " +
                            checkIsNotNullWithOutNA(careContactsBean.getDataList().get(i).getAddress().getBuildingNumber()) + " " +
                            checkIsNotNullWithOutNA(careContactsBean.getDataList().get(i).getAddress().getDepartmentName()) + " " +
                            checkIsNotNullWithOutNA(careContactsBean.getDataList().get(i).getAddress().getDependentLocality()) + " " +
                            checkIsNotNullWithOutNA(careContactsBean.getDataList().get(i).getAddress().getOrganisationName()) + " " +
                            checkIsNotNullWithOutNA(careContactsBean.getDataList().get(i).getAddress().getStreetName()) + " " +
                            checkIsNotNullWithOutNA(careContactsBean.getDataList().get(i).getAddress().getCountryName()) + " " +
                            checkIsNotNullWithOutNA(careContactsBean.getDataList().get(i).getAddress().getPostCodeName());
                    clientContactsBean.setAddress(address);
                } else {
                    clientContactsBean.setAddress("N/A");
                }
                clientContactsBeanArrayList.add(clientContactsBean);
            }
        }
        return clientContactsBeanArrayList;
    }


    private String checkIsNotNull(String value) {
        return value != null && !value.equalsIgnoreCase("") && !value.equalsIgnoreCase("null") ? value : "N/A";
    }

    private String checkIsNotNullWithOutNA(String value) {
        return value != null && !value.equalsIgnoreCase("null") ? value : "";
    }

    private Bitmap ImageFromBase64(String img) {
        byte[] decodedString = Base64.decode(img, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}