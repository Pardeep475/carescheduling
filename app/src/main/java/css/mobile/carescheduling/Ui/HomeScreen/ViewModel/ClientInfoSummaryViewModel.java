package css.mobile.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import css.mobile.carescheduling.Ui.Dashboard.beans.ClientSummary;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientCareSummaryBean;
import css.mobile.carescheduling.Ui.Profile.View.EditProfile;
import css.mobile.carescheduling.data.Local.AppDataBase;
import css.mobile.carescheduling.data.Network.ApiClient;
import css.mobile.carescheduling.data.Network.ApiService;

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

public class ClientInfoSummaryViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public ClientInfoSummaryViewModel(@NonNull Application application) {
        super(application);
        context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<ClientBookingScreenModel> getClientSummary(String customerId, String branchId, String clientId) {
        final MutableLiveData<ClientBookingScreenModel> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.GetClientSummary(customerId, branchId, clientId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<ClientCareSummaryBean>>() {
                        @Override
                        public void accept(Response<ClientCareSummaryBean> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful()) {
                                if (loginBeanRetroResponse.body() != null && loginBeanRetroResponse.body().getData() != null) {
                                    data.setValue(getClientInfo(loginBeanRetroResponse.body().getData()));
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

    private ClientBookingScreenModel getClientInfo(ClientSummary data) {
        ClientBookingScreenModel clientBookingScreenModel = new ClientBookingScreenModel();
        clientBookingScreenModel.setName(checkIsNotNull(data.getClientName()));
//         if (!checkIsNotNull(data.getClientImage()).equalsIgnoreCase("N/A"))
//            clientBookingScreenModel.setImage(ImageFromBase64(data.getClientImage()));
        clientBookingScreenModel.setAddress(checkIsNotNull(data.getClientAddress()));
        clientBookingScreenModel.setDiscreption(checkIsNotNull(data.getClientDescription()));

        return clientBookingScreenModel;
    }

    public LiveData<ClientBookingScreenModel> getDataFromLocal(Context activity,String bookingId){
        final MutableLiveData<ClientBookingScreenModel> data = new MutableLiveData<>();
        AppDataBase.getAppDatabase(getApplication()).homeDeo().getAllClientSummary(bookingId)
                .observe(((EditProfile) activity), new Observer<ClientSummary>() {
                    @Override
                    public void onChanged(ClientSummary profileInfo) {
                        if (profileInfo != null) {
                            data.setValue(getClientInfo(profileInfo));
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
