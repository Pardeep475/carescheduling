package css.mobile.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import css.mobile.carescheduling.Ui.Dashboard.beans.ClientBookingListModel;
import css.mobile.carescheduling.Ui.Dashboard.beans.ClientTaskList;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientCarePlan;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientTaskRetroBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.Tasks;
import css.mobile.carescheduling.Ui.Profile.View.EditProfile;
import css.mobile.carescheduling.data.Local.AppDataBase;
import css.mobile.carescheduling.data.Local.SessionManager;
import css.mobile.carescheduling.data.Network.ApiClient;
import css.mobile.carescheduling.data.Network.ApiService;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.ArrayList;
import java.util.List;

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
                            if (loginBeanRetroResponse.body() != null && loginBeanRetroResponse.body().getData() != null)
                                data.setValue(getClientData(loginBeanRetroResponse.body().getData()));
                            else {
                                Toast.makeText(getApplication(), loginBeanRetroResponse.message(), Toast.LENGTH_SHORT).show();
                                data.setValue(null);
                            }
                        } else {
                            data.setValue(null);
                            Toast.makeText(getApplication(), (String) loginBeanRetroResponse.body().getResponseMessage(), Toast.LENGTH_SHORT).show();
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


    public LiveData<ClientBookingScreenModel> getDataFromLocal(Context activity, String bookingId) {
        final MutableLiveData<ClientBookingScreenModel> data = new MutableLiveData<>();
        AppDataBase.getAppDatabase(getApplication()).homeDeo().getAllClientBookingScreenModel(bookingId)
                .observe(((EditProfile) activity), new Observer<ClientBookingScreenModel>() {
                    @Override
                    public void onChanged(ClientBookingScreenModel profileInfo) {
                        if (profileInfo != null) {
                            data.setValue(profileInfo);
                        } else {
                            data.setValue(null);
                        }
                    }
                });

        return data;
    }

    private ClientBookingScreenModel getClientData(ClientBookingListModel.Data data) {
        SessionManager sessionManager = new SessionManager(getApplication());
        if (!checkIsNotNull(data.getClientPersonId()).equalsIgnoreCase("N/A"))
            sessionManager.setClientId(data.getClientPersonId());
        ClientBookingScreenModel clientBookingScreenModel = new ClientBookingScreenModel();
        clientBookingScreenModel.setName(checkIsNotNull(data.getClientName()));
        clientBookingScreenModel.setDate(checkIsNotNull(data.getBookingStartTime()) + " " + checkIsNotNull(data.getBookingDate()));
        clientBookingScreenModel.setTime(checkIsNotNull(data.getBookingStartTime()) + " - " + checkIsNotNull(data.getBookingEndTime()));
//        if (!checkIsNotNull(data.getImageHexString()).equalsIgnoreCase("N/A"))
//            clientBookingScreenModel.setImage(ImageFromBase64(data.getImageHexString()));
        clientBookingScreenModel.setAddress(checkIsNotNull(data.getPersonAddress()));
        clientBookingScreenModel.setTelephone(checkIsNotNull(data.getClientPhoneNumber()));
        clientBookingScreenModel.setBookingId(checkIsNotNull(data.getClientBookingId()));

        return clientBookingScreenModel;
    }


    private String checkIsNotNull(String value) {
        return value != null && !value.equalsIgnoreCase("") && !value.equalsIgnoreCase("null") ? value : "";
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


    public LiveData<ArrayList<Tasks>> getClientTasks(String customerId, String branchId, String clientId) {
        final MutableLiveData<ArrayList<Tasks>> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.GetClientTask(customerId, branchId, clientId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<ClientTaskRetroBean>>() {
                        @Override
                        public void accept(Response<ClientTaskRetroBean> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful()) {
                                if (loginBeanRetroResponse.body() != null && loginBeanRetroResponse.body().getDataList() != null) {
                                    data.setValue(getClientTasksArrayList(loginBeanRetroResponse.body().getDataList()));
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
            Toast.makeText(getApplication(), e.toString(), Toast.LENGTH_SHORT).show();
        }
        return data;
    }

    private ArrayList<Tasks> getClientTasksArrayList(ArrayList<ClientTaskList> clientTasks) {
        ArrayList<Tasks> tasksArrayList = new ArrayList<>();
        for (int i = 0; i < clientTasks.size(); i++) {
            Tasks tasks = new Tasks();
            tasks.setInstruction(checkIsNotNull(clientTasks.get(i).getInstructions()));
            tasks.setTaskId(checkIsNotNull(clientTasks.get(i).getTaskId()));
            tasks.setTaskName(checkIsNotNull(clientTasks.get(i).getTaskName()));
            tasks.setVisitShiftName(checkIsNotNull(clientTasks.get(i).getVisitShiftName()));
            tasks.setVisitTiming(checkIsNotNull(clientTasks.get(i).getVisitTiming()));
            tasksArrayList.add(tasks);
        }

        return tasksArrayList;
    }

    public LiveData<ArrayList<Tasks>> getDataFromLocalClientTask(Context activity, String bookingId){
        final MutableLiveData<ArrayList<Tasks>> data = new MutableLiveData<>();

        AppDataBase.getAppDatabase(getApplication()).homeDeo().getAllClientTaskList(bookingId).observe(((EditProfile) activity), new Observer<List<ClientTaskList>>() {
            @Override
            public void onChanged(List<ClientTaskList> clientTaskLists) {
                if (clientTaskLists != null) {
                    ArrayList<ClientTaskList> arrayList = new ArrayList<>(clientTaskLists);
                    data.setValue(getClientTasksArrayList(arrayList));
                }else{
                    data.setValue(null);
                }
            }
        });

        return data;
    }







    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
