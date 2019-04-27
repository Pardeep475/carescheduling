package com.example.carescheduling.Ui.Dashboard.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;
import com.google.gson.JsonElement;

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

public class ProfileResultViewModel extends AndroidViewModel {
    private ApiService apiService;
    private CompositeDisposable compositeDisposable;
    private Context context;

    public ProfileResultViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<ProfileResultBean> getProfileData(ProfileBean profileBean) {
        MutableLiveData<ProfileResultBean> profileResultBeanMutableLiveData = new MutableLiveData<>();
        ProfileResultBean profileResultBean = new ProfileResultBean();
        String personEmail = null;
        String personTelephone = null;
        String personMobile = null;
        String personUserName = null;
        String personAddress = null;
        if (profileBean.getData().getPerson() != null) {
//      get person email
            for (int i = 0; i < profileBean.getData().getPerson().getPersonEmail().size(); i++) {
                if (profileBean.getData().getPerson().getPersonEmail().get(i).getIsDefaultEmail())
                    personEmail = profileBean.getData().getPerson().getPersonEmail().get(i).getEmailAddress();
            }

//      get person number
            for (int i = 0; i < profileBean.getData().getPerson().getPersonPhone().size(); i++) {
                if (profileBean.getData().getPerson().getPersonPhone().get(i).getPhoneTypeName()
                        .equalsIgnoreCase("Landline")) {
                    personTelephone = profileBean.getData().getPerson().getPersonPhone().get(i).getPhoneNumber();
                } else {
                    personMobile = profileBean.getData().getPerson().getPersonPhone().get(i).getPhoneNumber();
                }

                if (profileBean.getData().getPerson().getPersonPhone().get(i).getIsDefaultPhone()) {
                    if (profileBean.getData().getPerson().getPersonPhone().get(i).getPhoneTypeName()
                            .equalsIgnoreCase("Landline")) {
                        personTelephone = profileBean.getData().getPerson().getPersonPhone().get(i).getPhoneNumber();
                    } else {
                        personMobile = profileBean.getData().getPerson().getPersonPhone().get(i).getPhoneNumber();
                    }
                }
            }
//           get user name
            personUserName = profileBean.getData().getPerson().getFirstName()
                    + " " + profileBean.getData().getPerson().getMaidenName()
                    + " " + profileBean.getData().getPerson().getSurName();
//            get Address
            if (profileBean.getData().getPerson().getPersonAddress() != null) {
                int addressId = -1;
                for (int i = 0; i < profileBean.getData().getPerson().getPersonAddress().size(); i++) {
                    if (profileBean.getData().getPerson().getPersonAddress().get(i).getIsDefaultAddress()) {
                        addressId = profileBean.getData().getPerson().getPersonAddress().get(i).getAddressId();
                    }
                }
                if (profileBean.getData().getPersonAddresses() != null && addressId != -1) {
                    for (int i = 0; i < profileBean.getData().getPersonAddresses().size(); i++) {
                        ProfileBean.PersonAddress_ profileAddressData = profileBean.getData().getPersonAddresses().get(i);
                        if (profileAddressData.getIsDefaultAddress()){
                            personAddress = profileAddressData.getAddress().getOrganisationName() +" "+
                                    profileAddressData.getAddress().getBuildingNumber() +" "+
                                    profileAddressData.getAddress().getBuildingName() +" "+
                                    profileAddressData.getAddress().getSubBuildingName() +" "+
                                    profileAddressData.getAddress().getStreetName() +" "+
                                    profileAddressData.getAddress().getPostCodeName() +" "+
                                    profileAddressData.getAddress().getCountryName();
                        }

                    }
                }
            }
        }
//        Organisation Name
//        Building Number
//        Building Name
//        Sub Building Name
//        Street Address
//        Town
//                County
//        Postal code
//        Country
        profileResultBean.setEmail(personEmail != null ? personEmail : context.getString(R.string.no_data_available));
        profileResultBean.setTelephone(personTelephone != null ? personTelephone : context.getString(R.string.no_data_available));
        profileResultBean.setMobile(personMobile != null ? personMobile : context.getString(R.string.no_data_available));
        profileResultBean.setUserName(personUserName != null &&
                !personUserName.equalsIgnoreCase("null")
                && !personUserName.equalsIgnoreCase("") ? personUserName : context.getString(R.string.no_data_available));
        profileResultBean.setAddress(personAddress != null &&
                !personAddress.equalsIgnoreCase("null")
                && !personAddress.equalsIgnoreCase("") ? personAddress : context.getString(R.string.no_data_available));

        profileResultBeanMutableLiveData.setValue(profileResultBean);
        return profileResultBeanMutableLiveData;
    }

    public LiveData<ProfileBean> getClientData(String personId, String customerId, String branchId) {
        final MutableLiveData<ProfileBean> data = new MutableLiveData<>();

        Disposable disposable = apiService.getProfile(personId, customerId, branchId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ProfileBean>>() {
                    @Override
                    public void accept(Response<ProfileBean> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful()) {
                            data.setValue(loginBeanRetroResponse.body());
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

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
