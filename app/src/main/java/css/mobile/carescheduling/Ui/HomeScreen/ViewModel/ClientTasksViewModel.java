package css.mobile.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import css.mobile.carescheduling.Ui.Dashboard.beans.ClientTaskList;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientTaskRetroBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.Tasks;
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

public class ClientTasksViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public ClientTasksViewModel(@NonNull Application application) {
        super(application);
        context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
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
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
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

    public LiveData<ArrayList<Tasks>> getDataFromLocal(Context activity, String bookingId){
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