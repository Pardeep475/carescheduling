package css.mobile.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientInfoCarePlanRetro;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ScheduleClients;
import css.mobile.carescheduling.Ui.Profile.View.EditProfile;
import css.mobile.carescheduling.data.Local.AppDataBase;
import css.mobile.carescheduling.data.Network.ApiClient;
import css.mobile.carescheduling.data.Network.ApiService;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class CarePlanViewModal extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public CarePlanViewModal(@NonNull Application application) {
        super(application);
        context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<ArrayList<ScheduleClients>> getCarePlan(String customerId, String branchId, String clientId) {
        final MutableLiveData<ArrayList<ScheduleClients>> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.GetClientCarePlanSchedule(customerId, branchId, clientId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<ClientInfoCarePlanRetro>>() {
                        @Override
                        public void accept(Response<ClientInfoCarePlanRetro> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful()) {
                                if (loginBeanRetroResponse.body() != null && loginBeanRetroResponse.body().getDataList() != null && loginBeanRetroResponse.body().getDataList().size() > 0) {
                                    /*ArrayList<ScheduleClients> clientLists = new ArrayList<>();
                                    for (int i = 0; i < loginBeanRetroResponse.body().getDataList().size(); i++) {
                                        clientLists.addAll(loginBeanRetroResponse.body().getDataList());
                                    }*/
                                    data.setValue(loginBeanRetroResponse.body().getDataList());
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

    public LiveData<ArrayList<ScheduleClients>> getDataFromLocal(Context activity, String bookingId){
        final MutableLiveData<ArrayList<ScheduleClients>> data = new MutableLiveData<>();
        AppDataBase.getAppDatabase(getApplication()).homeDeo().getAllScheduleClients(bookingId).observe(((EditProfile) activity)
                , new Observer<List<ScheduleClients>>() {
            @Override
            public void onChanged(List<ScheduleClients> scheduleClients) {
                if (scheduleClients!= null){
                    ArrayList<ScheduleClients> arrayList = new ArrayList<>(scheduleClients);
                    data.setValue(arrayList);
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
