package css.mobile.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import css.mobile.carescheduling.Ui.HomeScreen.beans.VisitArchiveAdapterBean;
import css.mobile.carescheduling.Ui.HomeScreen.beans.VisitArchiveRetroBean;
import css.mobile.carescheduling.data.Network.ApiClient;
import css.mobile.carescheduling.data.Network.ApiService;

import java.util.ArrayList;

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

public class VisitArchiveViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public VisitArchiveViewModel(@NonNull Application application) {
        super(application);
        context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<ArrayList<VisitArchiveAdapterBean>> getVisitArchiveClient(String clientId, String date, String branchId, String customerId) {
        final MutableLiveData<ArrayList<VisitArchiveAdapterBean>> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.GetEmployeeVisitArchive(clientId, date, branchId, customerId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<VisitArchiveRetroBean>>() {
                        @Override
                        public void accept(Response<VisitArchiveRetroBean> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful()) {
                                if (loginBeanRetroResponse.body() != null) {
                                    data.setValue(getVisitArchive(loginBeanRetroResponse.body()));
//                                    data.setValue(loginBeanRetroResponse.body().getDataList());
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

    private ArrayList<VisitArchiveAdapterBean> getVisitArchive(VisitArchiveRetroBean body) {
        ArrayList<VisitArchiveAdapterBean> visitArchiveAdapterBeanArrayList = new ArrayList<>();
        if (body.getDataList() != null) {
            for (int i = 0; i < body.getDataList().size(); i++) {
                VisitArchiveAdapterBean visitArchiveAdapterBean = new VisitArchiveAdapterBean();
                visitArchiveAdapterBean.setVisitTime(checkIsNotNullWithOutNA(body.getDataList().get(i).getBookingStartTime()) + " - " +
                        checkIsNotNullWithOutNA(body.getDataList().get(i).getBookingEndTime()));
                visitArchiveAdapterBean.setVisitDate(checkIsNotNullWithOutNA(body.getDataList().get(i).getBookingDate()));
                visitArchiveAdapterBean.setAddress(checkIsNotNullWithOutNA(body.getDataList().get(i).getPersonAddress()));
                visitArchiveAdapterBean.setName(checkIsNotNullWithOutNA(body.getDataList().get(i).getClientName()));
                visitArchiveAdapterBean.setTelephone(checkIsNotNullWithOutNA(body.getDataList().get(i).getClientPhoneNumber()));
                visitArchiveAdapterBean.setEmail(checkIsNotNullWithOutNA((String) body.getDataList().get(i).getEmailAddress()));
                if (!checkIsNotNull((String) body.getDataList().get(i).getImageHexString()).equalsIgnoreCase("N/A"))
                    visitArchiveAdapterBean.setImage(ImageFromBase64((String) body.getDataList().get(i).getImageHexString()));
                visitArchiveAdapterBeanArrayList.add(visitArchiveAdapterBean);
            }
        }
        return visitArchiveAdapterBeanArrayList;
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


