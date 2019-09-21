package com.example.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.HomeScreen.beans.EmployeeClientVisitForArrivalRetro;
import com.example.carescheduling.Ui.HomeScreen.beans.EmployeeClientVisitForDepartureRetro;
import com.example.carescheduling.Ui.HomeScreen.beans.MatchingClientBarcodeForLoginRetro;
import com.example.carescheduling.Ui.HomeScreen.beans.ScanBean;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;
import com.google.gson.JsonElement;

import org.json.JSONArray;
import org.json.JSONObject;

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

public class ArrivalAndDepartureViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public ArrivalAndDepartureViewModel(@NonNull Application application) {
        super(application);
        context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<String> getMatchingClientBarcodeArrival(ArrayList<EmployeeClientVisitForArrivalRetro> employeeClientVisitForArrivals) {
        final MutableLiveData<String> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.EmployeeClientVisitForArrival(employeeClientVisitForArrivals)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<JsonElement>>() {
                        @Override
                        public void accept(Response<JsonElement> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful() && loginBeanRetroResponse.body() != null) {
                                JSONObject jsonObject = new JSONObject(loginBeanRetroResponse.body().toString());
                                boolean isSuccess = jsonObject.getBoolean("Success");
                                if (isSuccess) {
                                    if(jsonObject.has("DataList")){
                                        try{
                                            JSONArray jsonArray = jsonObject.getJSONArray("DataList");
                                            if (jsonArray.length() > 0) {
                                                JSONObject dataObj = jsonArray.getJSONObject(0);
                                                if (dataObj.has("ClientVisitId")) {
                                                    if (dataObj.getString("ClientVisitId") != null)
                                                        data.setValue(dataObj.getString("ClientVisitId"));
                                                    else
                                                        data.setValue(null);
                                                } else
                                                    data.setValue(null);

                                            } else
                                                data.setValue(null);
                                        }catch(Exception e){
                                            if (jsonObject.getString("ResponseMessage") != null)
                                                Toast.makeText(context, jsonObject.getString("ResponseMessage"), Toast.LENGTH_SHORT).show();
                                            data.setValue(null);
                                        }

                                    }else{
                                        data.setValue(null);
                                    }
                                } else
                                    data.setValue(null);
                                if (jsonObject.getString("ResponseMessage") != null)
                                    Toast.makeText(context, jsonObject.getString("ResponseMessage"), Toast.LENGTH_SHORT).show();

                            } else
                                data.setValue(null);
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


    public LiveData<Boolean> getEmployeeClientVisitForDeparture(EmployeeClientVisitForDepartureRetro employeeClientVisitForArrivals) {
        final MutableLiveData<Boolean> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.EmployeeClientVisitForDeparture(employeeClientVisitForArrivals)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<JsonElement>>() {
                        @Override
                        public void accept(Response<JsonElement> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful()) {
                                JSONObject jsonObject = new JSONObject(loginBeanRetroResponse.body().toString());
                                boolean isSuccess = jsonObject.getBoolean("Success");
                                data.setValue(isSuccess);
                                if (jsonObject.getString("ResponseMessage") != null)
                                    Toast.makeText(context, jsonObject.getString("ResponseMessage"), Toast.LENGTH_SHORT).show();

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


    public MutableLiveData<String> datePicker(String date) {
        final MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(date);
        return mutableLiveData;
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


