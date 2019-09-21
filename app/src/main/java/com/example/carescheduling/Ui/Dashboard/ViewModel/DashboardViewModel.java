package com.example.carescheduling.Ui.Dashboard.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.Common.ClientBarcodeList;
import com.example.carescheduling.Ui.Dashboard.beans.AllHomeData;
import com.example.carescheduling.Ui.Dashboard.beans.ClientBookingListModel;
import com.example.carescheduling.Ui.Dashboard.beans.ClientContactList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientDisabilityList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientDocumentList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientMedicalForMobileList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientNoteList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientSummary;
import com.example.carescheduling.Ui.Dashboard.beans.ClientTaskList;
import com.example.carescheduling.Ui.Dashboard.beans.EditMyProfile;
import com.example.carescheduling.Ui.Dashboard.beans.PersonDetail;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import com.example.carescheduling.Ui.HomeScreen.beans.ScheduleClients;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Local.DatabaseInitializerHome;
import com.example.carescheduling.data.Local.SessionManager;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;

import java.util.ArrayList;
import java.util.List;

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

public class DashboardViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public DashboardViewModel(@NonNull Application application) {
        super(application);
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
        context = application;
    }

    public LiveData<EditMyProfile> getEditMyProfileData(String customerId) {
        final MutableLiveData<EditMyProfile> data = new MutableLiveData<>();

        Disposable disposable = apiService.editMyProfile(customerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<EditMyProfile>>() {
                    @Override
                    public void accept(Response<EditMyProfile> editMyProfileResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (editMyProfileResponse.isSuccessful() && editMyProfileResponse.body() != null) {
                            Toast.makeText(context, (String) editMyProfileResponse.body().getResponseMessage(), Toast.LENGTH_SHORT).show();
                            if (editMyProfileResponse.body().getData() != null) {
                                data.setValue(editMyProfileResponse.body());
                            } else {
                                data.setValue(null);
                            }
                        } else {
                            data.setValue(null);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("LoginSuccess", "error" + throwable.toString());
                        data.setValue(null);
                    }
                });
        compositeDisposable.add(disposable);
        return data;
    }

    public LiveData<Boolean> GetAllHomeDataApi(String personId, String customerId, String branchId) {
        final MutableLiveData<Boolean> data = new MutableLiveData<>();
        Disposable disposable = apiService.GetAllHomeData(personId, customerId, branchId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<AllHomeData>>() {
                    @Override
                    public void accept(Response<AllHomeData> editMyProfileResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (editMyProfileResponse.isSuccessful() && editMyProfileResponse.body() != null) {
//                            Toast.makeText(context, (String) editMyProfileResponse.body().getResponseMessage(), Toast.LENGTH_SHORT).show();
                            if (editMyProfileResponse.body().getDataList() != null) {
                                setDataToDatabase(editMyProfileResponse.body());
                                data.setValue(true);
                            } else {
                                data.setValue(false);
                            }

                        } else {
                            data.setValue(false);
                            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("LoginSuccess", "error" + throwable.toString());
                        data.setValue(false);
                        Toast.makeText(context, throwable.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        compositeDisposable.add(disposable);
        return data;
    }

    private void setDataToDatabase(AllHomeData allHomeData) {
        getClientBookingScreenModelData(allHomeData);
        getClientNoteList(allHomeData);
        getClientSummary(allHomeData);
        getClientContactList(allHomeData);
        getClientDocumentList(allHomeData);
        getClientMedicalList(allHomeData);
        getClientDisabilitiesList(allHomeData);
        getClientTaskList(allHomeData);
        getClientCarePlanList(allHomeData);
        getClientInfo(allHomeData);
        getBarcodeLists(allHomeData);
    }

    private void getClientInfo(AllHomeData allHomeData) {
        List<PersonDetail> clientNoteLists = new ArrayList<>();
        for (int i = 0; i < allHomeData.getDataList().size(); i++) {
            if (allHomeData.getDataList().get(i).getPersonDetail() != null) {
                PersonDetail clientNoteList = allHomeData.getDataList().get(i).getPersonDetail();
                clientNoteList.setBookingId(allHomeData.getDataList().get(i).getClientBookingId());
                clientNoteLists.add(clientNoteList);
            }

        }
        DatabaseInitializerHome.populateAsyncPersonDetail(AppDataBase.getAppDatabase(getApplication()), clientNoteLists);
    }

    private void getClientTaskList(AllHomeData allHomeData) {
        List<ClientTaskList> clientNoteLists = new ArrayList<>();
        for (int i = 0; i < allHomeData.getDataList().size(); i++) {
            if (allHomeData.getDataList().get(i).getClientTaskList() != null)
                for (int j = 0; j < allHomeData.getDataList().get(i).getClientTaskList().size(); j++) {
                    ClientTaskList clientNoteList = allHomeData.getDataList().get(i).getClientTaskList().get(j);
                    clientNoteList.setBookingId(allHomeData.getDataList().get(i).getClientBookingId());
                    clientNoteLists.add(clientNoteList);
                }
        }
        DatabaseInitializerHome.populateAsyncClientTaskList(AppDataBase.getAppDatabase(getApplication()), clientNoteLists);
    }

    private void getClientCarePlanList(AllHomeData allHomeData) {
        List<ScheduleClients> clientNoteLists = new ArrayList<>();
        for (int i = 0; i < allHomeData.getDataList().size(); i++) {
            if (allHomeData.getDataList().get(i).getScheduleClients() != null)
                for (int j = 0; j < allHomeData.getDataList().get(i).getScheduleClients().size(); j++) {
                    ScheduleClients clientNoteList = allHomeData.getDataList().get(i).getScheduleClients().get(j);
                    clientNoteList.setBookingId(allHomeData.getDataList().get(i).getClientBookingId());
                    clientNoteLists.add(clientNoteList);
                }
        }
        DatabaseInitializerHome.populateAsyncScheduleClients(AppDataBase.getAppDatabase(getApplication()), clientNoteLists);
    }

    private void getClientSummary(AllHomeData allHomeData) {
        List<ClientSummary> clientNoteLists = new ArrayList<>();
        for (int i = 0; i < allHomeData.getDataList().size(); i++) {
            if (allHomeData.getDataList().get(i).getClientSummary() != null) {
                ClientSummary clientNoteList = allHomeData.getDataList().get(i).getClientSummary();
                clientNoteList.setBookingId(allHomeData.getDataList().get(i).getClientBookingId());
                clientNoteLists.add(clientNoteList);
            }

        }
        DatabaseInitializerHome.populateAsyncClientSummary(AppDataBase.getAppDatabase(getApplication()), clientNoteLists);
    }

    private void getClientNoteList(AllHomeData allHomeData) {
        List<ClientNoteList> clientNoteLists = new ArrayList<>();
        for (int i = 0; i < allHomeData.getDataList().size(); i++) {
            if (allHomeData.getDataList().get(i).getClientNoteList() != null)
                for (int j = 0; j < allHomeData.getDataList().get(i).getClientNoteList().size(); j++) {
                    ClientNoteList clientNoteList = allHomeData.getDataList().get(i).getClientNoteList().get(j);
                    clientNoteList.setBookingId(allHomeData.getDataList().get(i).getClientBookingId());
                    clientNoteLists.add(clientNoteList);
                }
        }
        DatabaseInitializerHome.populateAsyncClientNoteList(AppDataBase.getAppDatabase(getApplication()), clientNoteLists);
    }

    private void getClientContactList(AllHomeData allHomeData) {
        List<ClientContactList> clientNoteLists = new ArrayList<>();
        for (int i = 0; i < allHomeData.getDataList().size(); i++) {
            if (allHomeData.getDataList().get(i).getClientContactList() != null)
                for (int j = 0; j < allHomeData.getDataList().get(i).getClientContactList().size(); j++) {
                    ClientContactList clientNoteList = allHomeData.getDataList().get(i).getClientContactList().get(j);
                    clientNoteList.setBookingId(allHomeData.getDataList().get(i).getClientBookingId());
                    clientNoteLists.add(clientNoteList);
                }
        }
        DatabaseInitializerHome.populateAsyncClientContactList(AppDataBase.getAppDatabase(getApplication()), clientNoteLists);
    }

    private void getClientDocumentList(AllHomeData allHomeData) {
        List<ClientDocumentList> clientNoteLists = new ArrayList<>();
        for (int i = 0; i < allHomeData.getDataList().size(); i++) {
            if (allHomeData.getDataList().get(i).getClientDocumentList() != null)
                for (int j = 0; j < allHomeData.getDataList().get(i).getClientDocumentList().size(); j++) {
                    ClientDocumentList clientNoteList = allHomeData.getDataList().get(i).getClientDocumentList().get(j);
                    clientNoteList.setBookingId(allHomeData.getDataList().get(i).getClientBookingId());
                    clientNoteLists.add(clientNoteList);
                }
        }
        DatabaseInitializerHome.populateAsyncClientDocumentList(AppDataBase.getAppDatabase(getApplication()), clientNoteLists);
    }

    private void getClientMedicalList(AllHomeData allHomeData) {
        List<ClientMedicalForMobileList> clientNoteLists = new ArrayList<>();
        for (int i = 0; i < allHomeData.getDataList().size(); i++) {
            if (allHomeData.getDataList().get(i).getClientMedicalForMobileList() != null)
                for (int j = 0; j < allHomeData.getDataList().get(i).getClientMedicalForMobileList().size(); j++) {
                    ClientMedicalForMobileList clientNoteList = allHomeData.getDataList().get(i).getClientMedicalForMobileList().get(j);
                    clientNoteList.setBookingId(allHomeData.getDataList().get(i).getClientBookingId());
                    clientNoteLists.add(clientNoteList);
                }
        }
        DatabaseInitializerHome.populateAsyncClientMedicalForMobileList(AppDataBase.getAppDatabase(getApplication()), clientNoteLists);
    }

    private void getClientDisabilitiesList(AllHomeData allHomeData) {
        List<ClientDisabilityList> clientNoteLists = new ArrayList<>();
        for (int i = 0; i < allHomeData.getDataList().size(); i++) {
            if (allHomeData.getDataList().get(i).getClientDisabilityList() != null)
                for (int j = 0; j < allHomeData.getDataList().get(i).getClientDisabilityList().size(); j++) {
                    ClientDisabilityList clientNoteList = allHomeData.getDataList().get(i).getClientDisabilityList().get(j);
                    clientNoteList.setBookingId(allHomeData.getDataList().get(i).getClientBookingId());
                    clientNoteLists.add(clientNoteList);
                }
        }
        DatabaseInitializerHome.populateAsyncClientDisabilityList(AppDataBase.getAppDatabase(getApplication()), clientNoteLists);
    }

    private void getBarcodeLists(AllHomeData allHomeData) {
        List<ClientBarcodeList> clientNoteLists = new ArrayList<>();
        for (int i = 0; i < allHomeData.getDataList().size(); i++) {
            if (allHomeData.getDataList().get(i).getClientBarcodeList() != null)
                for (int j = 0; j < allHomeData.getDataList().get(i).getClientBarcodeList().size(); j++) {
                    ClientBarcodeList clientNoteList = allHomeData.getDataList().get(i).getClientBarcodeList().get(j);
                    clientNoteList.setBookingId(allHomeData.getDataList().get(i).getClientBookingId());
                    clientNoteLists.add(clientNoteList);
                }
        }
        DatabaseInitializerHome.populateAsyncClientBarcodeList(AppDataBase.getAppDatabase(getApplication()), clientNoteLists);
    }

    private void getClientBookingScreenModelData(AllHomeData data) {
        List<ClientBookingScreenModel> clientBookingScreenModels = new ArrayList<>();
        for (int i = 0; i < data.getDataList().size(); i++) {
            SessionManager sessionManager = new SessionManager(getApplication());
            ClientBookingScreenModel clientBookingScreenModel = new ClientBookingScreenModel();
            if (i == 0) {
                if (!checkIsNotNull(data.getDataList().get(i).getClientPersonId()).equalsIgnoreCase("N/A"))
                    sessionManager.setClientId(data.getDataList().get(i).getClientPersonId());
                if (!checkIsNotNull(data.getDataList().get(i).getClientBookingId()).equalsIgnoreCase("N/A"))
                    sessionManager.setBookingId(data.getDataList().get(i).getClientBookingId());

            }
            clientBookingScreenModel.setBookingId(checkIsNotNull(data.getDataList().get(i).getClientBookingId()));
            clientBookingScreenModel.setName(checkIsNotNull(data.getDataList().get(i).getClientName()));
            clientBookingScreenModel.setDate(checkIsNotNull(data.getDataList().get(i).getBookingStartTime()) + " " + checkIsNotNull(data.getDataList().get(i).getBookingDate()));
            clientBookingScreenModel.setTime(checkIsNotNull(data.getDataList().get(i).getBookingStartTime()) + " - " + checkIsNotNull(data.getDataList().get(i).getBookingEndTime()));
//        if (!checkIsNotNull(data.getDataList().get(i).getImageHexString()).equalsIgnoreCase("N/A"))
//            clientBookingScreenModel.setImage(ImageFromBase64(data.getDataList().get(i).getImageHexString()));
            clientBookingScreenModel.setAddress(checkIsNotNull(data.getDataList().get(i).getPersonAddress()));
            clientBookingScreenModel.setTelephone(checkIsNotNull(data.getDataList().get(i).getClientPhoneNumber()));
            clientBookingScreenModels.add(clientBookingScreenModel);
        }

        DatabaseInitializerHome.populateAsyncClientBookingScreenModel(AppDataBase.getAppDatabase(getApplication()), clientBookingScreenModels);
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
