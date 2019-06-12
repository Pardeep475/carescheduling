package com.example.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.Dashboard.beans.ClientBookingListModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientCarePlan;
import com.example.carescheduling.Ui.HomeScreen.beans.Tasks;
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

public class BlankViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;

    public BlankViewModel(@NonNull Application application) {
        super(application);
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<ClientBookingScreenModel> getClientBookingList(String employeeId, String branchId, String customerId) {
        final MutableLiveData<ClientBookingScreenModel> data = new MutableLiveData<>();

        Disposable disposable = apiService.GetNextVisitClientBookingList(employeeId, branchId, customerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ClientBookingListModel>>() {
                    @Override
                    public void accept(Response<ClientBookingListModel> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful()) {
                            if (loginBeanRetroResponse.body() != null)
                                data.setValue(getClientData(loginBeanRetroResponse.body()));
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

    private ClientBookingScreenModel getClientData(ClientBookingListModel clientBookingListModel) {
        ClientBookingScreenModel clientBookingScreenModel = new ClientBookingScreenModel();
        if (clientBookingListModel.getData() != null) {
            if (clientBookingListModel.getData().getImageHexString() != null && !clientBookingListModel.getData().getImageHexString().equalsIgnoreCase(""))
                clientBookingScreenModel.setImage(ImageFromBase64(clientBookingListModel.getData().getImageHexString()));

            clientBookingScreenModel.setName(checkIsNotNull(clientBookingListModel.getData().getClientName()));
            clientBookingScreenModel.setTime(checkIsNotNullWithOutNA(clientBookingListModel.getData().getBookingStartTime())
                    + " - " + checkIsNotNullWithOutNA(clientBookingListModel.getData().getBookingEndTime()));

            clientBookingScreenModel.setTelephone(checkIsNotNull(clientBookingListModel.getData().getClientPhoneNumber()));
            clientBookingScreenModel.setDate(checkIsNotNullWithOutNA(clientBookingListModel.getData().getWeekdayname()) + " " +
                    checkIsNotNullWithOutNA(clientBookingListModel.getData().getBookingDate()));

            if (clientBookingListModel.getData().getClientAddress() != null) {
                clientBookingScreenModel.setAddress(checkIsNotNullWithOutNA(clientBookingListModel.getData().getClientAddress().getBuildingName())
                        + " " + checkIsNotNullWithOutNA(clientBookingListModel.getData().getClientAddress().getBuildingNumber()
                        + " " + checkIsNotNullWithOutNA(clientBookingListModel.getData().getClientAddress().getBuildingNumber())
                        + " " + checkIsNotNullWithOutNA(clientBookingListModel.getData().getClientAddress().getDepartmentName())
                        + " " + checkIsNotNullWithOutNA(clientBookingListModel.getData().getClientAddress().getDependentLocality())
                        + " " + checkIsNotNullWithOutNA(clientBookingListModel.getData().getClientAddress().getOrganisationName())
                        + " " + checkIsNotNullWithOutNA(clientBookingListModel.getData().getClientAddress().getStreetName())
                        + " " + checkIsNotNullWithOutNA(clientBookingListModel.getData().getClientAddress().getCountryName())
                        + " " + checkIsNotNullWithOutNA(clientBookingListModel.getData().getClientAddress().getPostCodeName())

                ));
            } else {
                clientBookingScreenModel.setAddress("N/A");
            }

            ArrayList<Tasks> tasksArrayList = new ArrayList<>();
            if (clientBookingListModel.getData().getTaskList() != null && clientBookingListModel.getData().getTaskList().size() > 0) {
                for (int i = 0; i < clientBookingListModel.getData().getTaskList().size(); i++) {
                    Tasks tasks = new Tasks();
                    tasks.setTitle(clientBookingListModel.getData().getTaskList().get(i).getTaskName());
                    tasksArrayList.add(tasks);
                }
            }
            clientBookingScreenModel.setTasksArrayList(tasksArrayList);
        }

        return clientBookingScreenModel;
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

    public LiveData<ClientCarePlan> GetClientAndClientCarePlan(String customerId, String branchId, String clientId) {
        final MutableLiveData<ClientCarePlan> data = new MutableLiveData<>();

        Disposable disposable = apiService.GetClientAndClientCarePlan(customerId, branchId, clientId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ClientCarePlan>>() {
                    @Override
                    public void accept(Response<ClientCarePlan> loginBeanRetroResponse) throws Exception {
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


    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
