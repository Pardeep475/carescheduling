package css.mobile.carescheduling.Ui.HomeScreen.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import css.mobile.carescheduling.Ui.Dashboard.beans.PersonDetail;
import css.mobile.carescheduling.Ui.HomeScreen.beans.ClientCarePersonalDetailsBean;
import css.mobile.carescheduling.Ui.Profile.View.EditProfile;
import css.mobile.carescheduling.Ui.Profile.bean.EditProfileInfoBean;
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

public class ClientInfoPersonalDetailsViewModel extends AndroidViewModel {
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;
    private Context context;

    public ClientInfoPersonalDetailsViewModel(@NonNull Application application) {
        super(application);
        context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }


    public LiveData<EditProfileInfoBean> getProfileDetails(String customerId, String branchId, String clientId) {
        final MutableLiveData<EditProfileInfoBean> data = new MutableLiveData<>();
        try {

            Disposable disposable = apiService.GetClientPersonDetail(customerId, branchId, clientId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Response<ClientCarePersonalDetailsBean>>() {
                        @Override
                        public void accept(Response<ClientCarePersonalDetailsBean> loginBeanRetroResponse) throws Exception {
                            Log.e("LoginSuccess", "success");
                            if (loginBeanRetroResponse.isSuccessful()) {
                                if (loginBeanRetroResponse.body() != null) {
                                    data.setValue(getProfileData(loginBeanRetroResponse.body()));

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


    private EditProfileInfoBean getProfileData(ClientCarePersonalDetailsBean clientCarePersonalDetailsBean) {
        EditProfileInfoBean editProfileInfoBean = new EditProfileInfoBean();
        if (clientCarePersonalDetailsBean.getData() != null) {
            editProfileInfoBean.setFirstName(checkIsNotNull(clientCarePersonalDetailsBean.getData().getFirstName()));
            editProfileInfoBean.setMiddleName(checkIsNotNull((String) clientCarePersonalDetailsBean.getData().getMiddleName()));
            editProfileInfoBean.setMaidenName(checkIsNotNull((String) clientCarePersonalDetailsBean.getData().getMaidenName()));
            editProfileInfoBean.setSurName(checkIsNotNull(clientCarePersonalDetailsBean.getData().getSurname()));
            editProfileInfoBean.setDateOfBirth(checkIsNotNull(clientCarePersonalDetailsBean.getData().getDateOfBirth()));
            editProfileInfoBean.setGender(checkIsNotNull(clientCarePersonalDetailsBean.getData().getGenderTypeName()));
            editProfileInfoBean.setPrefix(checkIsNotNull(clientCarePersonalDetailsBean.getData().getPrefixTypeName()));
            editProfileInfoBean.setLanguage(checkIsNotNull(clientCarePersonalDetailsBean.getData().getLanguageName()));
            editProfileInfoBean.setNationality(checkIsNotNull(clientCarePersonalDetailsBean.getData().getNationality()));


// marital status
            editProfileInfoBean.setMaritalStatus(checkIsNotNull(clientCarePersonalDetailsBean.getData().getMaritialStatus()));
            // ethnicity
            editProfileInfoBean.setEthnicity(checkIsNotNull(clientCarePersonalDetailsBean.getData().getEthnicity()));
            // disability
            editProfileInfoBean.setDisability(false);
            editProfileInfoBean.setDisabaility(checkIsNotNull(clientCarePersonalDetailsBean.getData().getDisability()));
// religion
            editProfileInfoBean.setReligion(checkIsNotNull(clientCarePersonalDetailsBean.getData().getReligion()));
            editProfileInfoBean.setSexuality(checkIsNotNull(clientCarePersonalDetailsBean.getData().getSexuality()));


        }


        return editProfileInfoBean;
    }

    public LiveData<EditProfileInfoBean> getDataFromLocal(Context activity, String bookingId){
        final MutableLiveData<EditProfileInfoBean> data = new MutableLiveData<>();
        AppDataBase.getAppDatabase(getApplication()).homeDeo().getAllPersonDetail(bookingId).observe(((EditProfile) activity), new Observer<PersonDetail>() {
            @Override
            public void onChanged(PersonDetail personDetail) {
                if (personDetail != null) {
                    data.setValue(getProfileData(personDetail));
                }else{
                    data.setValue(null);
                }
            }
        });

        return data;
    }

    private EditProfileInfoBean getProfileData(PersonDetail clientCarePersonalDetailsBean) {
        EditProfileInfoBean editProfileInfoBean = new EditProfileInfoBean();
            editProfileInfoBean.setFirstName(checkIsNotNull(clientCarePersonalDetailsBean.getFirstName()));
            editProfileInfoBean.setMiddleName(checkIsNotNull((String) clientCarePersonalDetailsBean.getMiddleName()));
            editProfileInfoBean.setMaidenName(checkIsNotNull((String) clientCarePersonalDetailsBean.getMaidenName()));
            editProfileInfoBean.setSurName(checkIsNotNull(clientCarePersonalDetailsBean.getSurname()));
            editProfileInfoBean.setDateOfBirth(checkIsNotNull(clientCarePersonalDetailsBean.getDateOfBirth()));
            editProfileInfoBean.setGender(checkIsNotNull(clientCarePersonalDetailsBean.getGenderTypeName()));
            editProfileInfoBean.setPrefix(checkIsNotNull(clientCarePersonalDetailsBean.getPrefixTypeName()));
            editProfileInfoBean.setLanguage(checkIsNotNull(clientCarePersonalDetailsBean.getLanguageName()));
            editProfileInfoBean.setNationality(checkIsNotNull(clientCarePersonalDetailsBean.getNationality()));


// marital status
            editProfileInfoBean.setMaritalStatus(checkIsNotNull(clientCarePersonalDetailsBean.getMaritialStatus()));
            // ethnicity
            editProfileInfoBean.setEthnicity(checkIsNotNull(clientCarePersonalDetailsBean.getEthnicity()));
            // disability
            editProfileInfoBean.setDisability(false);
            editProfileInfoBean.setDisabaility(checkIsNotNull(clientCarePersonalDetailsBean.getDisability()));
// religion
            editProfileInfoBean.setReligion(checkIsNotNull(clientCarePersonalDetailsBean.getReligion()));
            editProfileInfoBean.setSexuality(checkIsNotNull(clientCarePersonalDetailsBean.getSexuality()));

        return editProfileInfoBean;
    }


    private String checkIsNotNull(String value) {
        return value != null && !value.equalsIgnoreCase("") ? value : "N/A";
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}