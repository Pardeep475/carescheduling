package com.example.carescheduling.Ui.LoginActivity.ViewModal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.Ui.Dashboard.view.Dashboard;
import com.example.carescheduling.Ui.Profile.bean.EditAllAddressData;
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBean;
import com.example.carescheduling.Ui.Profile.bean.FragmentChangePasswordBean;
import com.example.carescheduling.Ui.Profile.bean.ProfileAllData;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Local.DatabaseInitializer;
import com.example.carescheduling.data.Local.DatabaseTable.AddressAllData;
import com.example.carescheduling.data.Local.DatabaseTable.ProfileInfo;
import com.example.carescheduling.data.Local.DatabaseTable.ProfileMainData;
import com.example.carescheduling.data.Local.DatabaseTable.UserInfo;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;
import com.google.gson.JsonElement;

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

public class LoginViewModalSF extends AndroidViewModel {
    private ApiService apiService;
    private CompositeDisposable compositeDisposable;

    public LoginViewModalSF(@NonNull Application application) {
        super(application);
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<JsonElement> getClientData(String userEmail, String userPassword, String branchId) {
        final MutableLiveData<JsonElement> data = new MutableLiveData<>();

        Disposable disposable = apiService.getClientDetail(userEmail, userPassword, branchId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<JsonElement>>() {
                    @Override
                    public void accept(Response<JsonElement> loginBeanRetroResponse) throws Exception {
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

    public LiveData<ProfileAllData> getPersonAllData(String person_id, String customer_id, String branch_id,String imageSize) {
        final MutableLiveData<ProfileAllData> data = new MutableLiveData<>();

        Disposable disposable = apiService.getProfileAllData(person_id, customer_id, branch_id,imageSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ProfileAllData>>() {
                    @Override
                    public void accept(Response<ProfileAllData> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful()) {
//                            setDefaultData(loginBeanRetroResponse.body());
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


    public void setDefaultData(Context context,ProfileAllData profileAllData) {
        mainFrontData(profileAllData);
        EditProfileInfo(profileAllData);
        setMyUserInfo(profileAllData);
//        EditALLAddressData(profileAllData);

        goToDashboard(context);
    }
    private void goToDashboard(Context context) {
        Intent intent = new Intent(context, Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
    private void mainFrontData(ProfileAllData profileAllData) {
        //person profile main data
        ProfileMainData profileResultBean = new ProfileMainData();
        profileResultBean.setUserName(checkIsNotNull(profileAllData.getData().getPersonName()));
        profileResultBean.setMobile(checkIsNotNull(profileAllData.getData().getPersonDefaultPhoneNumber()));
        profileResultBean.setEmail(checkIsNotNull(profileAllData.getData().getPersonDefaultEmailAddress()));
//        profileResultBean.setTelephone(checkIsNotNull(profileAllData.getData().getFirstName()));
        profileResultBean.setAddress(checkIsNotNull(profileAllData.getData().getPersonDefaultAddress()));
        if (!checkIsNotNullWithOutNA(profileAllData.getData().getPersonDefaultImage()).isEmpty())
            profileResultBean.setDefaultImageString(checkIsNotNull(profileAllData.getData().getPersonDefaultImage()));
//        profileResultBean.setImgUrl(checkIsNotNull(profileAllData.getData().getFirstName()));
        DatabaseInitializer.populateAsyncProfileMainData(AppDataBase.getAppDatabase(getApplication()), profileResultBean);
    }

    private void EditProfileInfo(ProfileAllData profileAllData) {
        ProfileInfo editProfileInfoBean = new ProfileInfo();
        editProfileInfoBean.setFirstName(checkIsNotNull(profileAllData.getData().getFirstName()));
        editProfileInfoBean.setMiddleName(checkIsNotNull(profileAllData.getData().getMiddleName()));
        editProfileInfoBean.setSurName(checkIsNotNull(profileAllData.getData().getSurname()));
        editProfileInfoBean.setMaidenName(checkIsNotNull(profileAllData.getData().getMaidenName()));
        editProfileInfoBean.setDateOfBirth(checkIsNotNull(profileAllData.getData().getDateOfBirth()));
        editProfileInfoBean.setGender(checkIsNotNull(profileAllData.getData().getGenderTypeName()));
        editProfileInfoBean.setPrefix(checkIsNotNull(profileAllData.getData().getPrefixTypeName()));
        editProfileInfoBean.setLanguage(checkIsNotNull(profileAllData.getData().getLanguageName()));
        editProfileInfoBean.setMaritalStatus(checkIsNotNull(profileAllData.getData().getMaritialStatus()));
        editProfileInfoBean.setEthnicity(checkIsNotNull(profileAllData.getData().getEthnicity()));
        editProfileInfoBean.setReligion(checkIsNotNull(profileAllData.getData().getReligion()));
        editProfileInfoBean.setSexuality(checkIsNotNull(profileAllData.getData().getSexuality()));
        editProfileInfoBean.setNationality(checkIsNotNull(profileAllData.getData().getNationality()));
        editProfileInfoBean.setDisabaility(checkIsNotNull(profileAllData.getData().getDisability()));
        if (profileAllData.getData().getIsDisability() != null)
            editProfileInfoBean.setDisability(profileAllData.getData().getIsDisability());

        DatabaseInitializer.populateAsyncProfileInfo(AppDataBase.getAppDatabase(getApplication()), editProfileInfoBean);
    }

    private void setMyUserInfo(ProfileAllData profileAllData) {
        UserInfo fragmentChangePasswordBean = new UserInfo();
        fragmentChangePasswordBean.setPasswordQuestion(checkIsNotNull(profileAllData.getData().getPasswordQuestion()));
        fragmentChangePasswordBean.setUserName(checkIsNotNull(profileAllData.getData().getUserName()));
        fragmentChangePasswordBean.setPasswordAns(checkIsNotNull(profileAllData.getData().getPasswordQuestionAnswer()));
        DatabaseInitializer.populateAsyncUserInfo(AppDataBase.getAppDatabase(getApplication()), fragmentChangePasswordBean);
    }

//    private void EditALLAddressData(ProfileAllData profileAllData) {
//        AddressAllData editAllAddressData = new AddressAllData();
//        if (profileAllData.getData().getPersonAddressList() != null)
//            editAllAddressData.setPersonAddressList(profileAllData.getData().getPersonAddressList());
//        if (profileAllData.getData().getPersonEmailList() != null)
//            editAllAddressData.setPersonEmailList(profileAllData.getData().getPersonEmailList());
//        if (profileAllData.getData().getPersonPhoneList() != null)
//            editAllAddressData.setPersonPhoneList(profileAllData.getData().getPersonPhoneList());
//
//        DatabaseInitializer.populateAsyncAddressAllData(AppDataBase.getAppDatabase(getApplication()), editAllAddressData);
//    }

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
