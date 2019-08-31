package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileResultBean;
import com.example.carescheduling.Ui.Dashboard.view.Dashboard;
import com.example.carescheduling.Ui.Profile.View.EditProfile;
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBean;
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBeanRetro;
import com.example.carescheduling.Ui.Profile.bean.GetMyProfileEdit;
import com.example.carescheduling.Ui.Profile.bean.ProfileAllData;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Local.DatabaseInitializer;
import com.example.carescheduling.data.Local.DatabaseTable.DisabilityType;
import com.example.carescheduling.data.Local.DatabaseTable.Ethnicity;
import com.example.carescheduling.data.Local.DatabaseTable.Gender;
import com.example.carescheduling.data.Local.DatabaseTable.MaritialStatus;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Local.DatabaseTable.Prefix;
import com.example.carescheduling.data.Local.DatabaseTable.ProfileInfo;
import com.example.carescheduling.data.Local.DatabaseTable.ProfileMainData;
import com.example.carescheduling.data.Local.DatabaseTable.Religion;
import com.example.carescheduling.data.Local.DatabaseTable.SexualityType;
import com.example.carescheduling.data.Network.ApiClient;
import com.example.carescheduling.data.Network.ApiService;
import com.google.gson.JsonElement;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class EditProfileInfoViewModel extends AndroidViewModel {
    private Context context;
    private CompositeDisposable compositeDisposable;
    private ApiService apiService;

    public EditProfileInfoViewModel(@NonNull Application application) {
        super(application);
        this.context = application;
        apiService = ApiClient.getClient(application)
                .create(ApiService.class);
        compositeDisposable = new CompositeDisposable();
    }

    public LiveData<EditProfileInfoBean> GetMyProfileEdit(String personId, String customerId, String branchId) {
        final MutableLiveData<EditProfileInfoBean> data = new MutableLiveData<>();

        Disposable disposable = apiService.GetMyProfileEdit(personId, customerId, branchId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<GetMyProfileEdit>>() {
                    @Override
                    public void accept(Response<GetMyProfileEdit> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful()) {
                            data.setValue(getEditProfile(loginBeanRetroResponse.body().getData()));
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

    private EditProfileInfoBean getEditProfile(GetMyProfileEdit.Data data) {

        EditProfileInfoBean editProfileInfoBean = new EditProfileInfoBean();
        if (data != null) {
            EditProfileInfoSaveLocal(data);
            if (data.getDateOfBirth() != null)
                editProfileInfoBean.setDateOfBirth(checkIsNotNull(data.getDateOfBirth()));
            editProfileInfoBean.setFirstName(checkIsNotNull(data.getFirstName()));
            editProfileInfoBean.setMiddleName(checkIsNotNull(data.getMiddleName()));
            editProfileInfoBean.setSurName(checkIsNotNull(data.getSurName()));
            editProfileInfoBean.setMaidenName(checkIsNotNull(data.getFirstName()));
            editProfileInfoBean.setGender(checkIsNotNull(data.getGenderTypeName()));
            editProfileInfoBean.setPrefix(checkIsNotNull(data.getPrefixTypeName()));
            editProfileInfoBean.setLanguage(checkIsNotNull(data.getLanguageName()));
            editProfileInfoBean.setMaritalStatus(checkIsNotNull(data.getMaritialStatusName()));
            editProfileInfoBean.setEthnicity(checkIsNotNull(data.getEthnicityTypeName()));
            editProfileInfoBean.setReligion(checkIsNotNull(data.getReligionTypeName()));
            editProfileInfoBean.setSexuality(checkIsNotNull(data.getSexualityTypeName()));
            editProfileInfoBean.setNationality(checkIsNotNull(data.getNationality()));
            editProfileInfoBean.setDisability(data.getIsDisability());
            editProfileInfoBean.setDisabaility(data.getDisabilityTypeName());
        }
        return editProfileInfoBean;
    }

    private void EditProfileInfoSaveLocal(GetMyProfileEdit.Data data ) {
        ProfileInfo editProfileInfoBean = new ProfileInfo();
        editProfileInfoBean.setFirstName(checkIsNotNull(data.getFirstName()));
        editProfileInfoBean.setMiddleName(checkIsNotNull(data.getMiddleName()));
        editProfileInfoBean.setSurName(checkIsNotNull(data.getSurName()));
        editProfileInfoBean.setMaidenName(checkIsNotNull(data.getMaidenName()));
        editProfileInfoBean.setDateOfBirth(checkIsNotNull(data.getDateOfBirth()));
        editProfileInfoBean.setGender(checkIsNotNull(data.getGenderTypeName()));
        editProfileInfoBean.setPrefix(checkIsNotNull(data.getPrefixTypeName()));
        editProfileInfoBean.setLanguage(checkIsNotNull(data.getLanguageName()));
        editProfileInfoBean.setMaritalStatus(checkIsNotNull(data.getMaritialStatusName()));
        editProfileInfoBean.setEthnicity(checkIsNotNull(data.getEthnicityTypeName()));
        editProfileInfoBean.setReligion(checkIsNotNull(data.getReligionTypeName()));
        editProfileInfoBean.setSexuality(checkIsNotNull(data.getSexualityTypeName()));
        editProfileInfoBean.setNationality(checkIsNotNull(data.getNationality()));
        editProfileInfoBean.setDisabaility(checkIsNotNull(data.getDisabilityTypeName()));
        if (data.getIsDisability() != null)
            editProfileInfoBean.setDisability(data.getIsDisability());

        DatabaseInitializer.populateAsyncProfileInfo(AppDataBase.getAppDatabase(getApplication()), editProfileInfoBean);
    }


    public LiveData<EditProfileInfoBean> getDataFromLocal(Context activity){
        final MutableLiveData<EditProfileInfoBean> data = new MutableLiveData<>();
        AppDataBase.getAppDatabase(context).profileDao().getAllProfileInfo().observe(((EditProfile) activity), new Observer<ProfileInfo>() {
            @Override
            public void onChanged(ProfileInfo profileInfo) {
                if (profileInfo != null) {
                    Log.e("getting_profile_data", profileInfo.getDateOfBirth());
                    data.setValue(getPersonInfoFullDataFromLocal(profileInfo));
                }
            }
        });

        return data;
    }


    private EditProfileInfoBean getPersonInfoFullDataFromLocal(ProfileInfo data) {

        EditProfileInfoBean editProfileInfoBean = new EditProfileInfoBean();
        if (data != null) {
            if (data.getDateOfBirth() != null)
                editProfileInfoBean.setDateOfBirth(checkIsNotNull(data.getDateOfBirth()));
            editProfileInfoBean.setFirstName(checkIsNotNull(data.getFirstName()));
            editProfileInfoBean.setMiddleName(checkIsNotNull(data.getMiddleName()));
            editProfileInfoBean.setSurName(checkIsNotNull(data.getSurName()));
            editProfileInfoBean.setMaidenName(checkIsNotNull(data.getFirstName()));
            editProfileInfoBean.setGender(checkIsNotNull(data.getGender()));
            editProfileInfoBean.setPrefix(checkIsNotNull(data.getPrefix()));
            editProfileInfoBean.setLanguage(checkIsNotNull(data.getLanguage()));
            editProfileInfoBean.setMaritalStatus(checkIsNotNull(data.getMaritalStatus()));
            editProfileInfoBean.setEthnicity(checkIsNotNull(data.getEthnicity()));
            editProfileInfoBean.setReligion(checkIsNotNull(data.getReligion()));
            editProfileInfoBean.setSexuality(checkIsNotNull(data.getSexuality()));
            editProfileInfoBean.setNationality(checkIsNotNull(data.getNationality()));
            editProfileInfoBean.setDisability(data.isDisability());
            editProfileInfoBean.setDisabaility(data.getDisabaility());
        }
        return editProfileInfoBean;
    }



    public LiveData<Boolean> UpdateProfile(EditProfileInfoBeanRetro editProfileInfoBeanRetro) {
        final MutableLiveData<Boolean> data = new MutableLiveData<>();

        Disposable disposable = apiService.UpdateMyProfile(editProfileInfoBeanRetro)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<JsonElement>>() {
                    @Override
                    public void accept(Response<JsonElement> loginBeanRetroResponse) throws Exception {
                        Log.e("LoginSuccess", "success");
                        if (loginBeanRetroResponse.isSuccessful()) {
                            JSONObject jsonObject = new JSONObject(loginBeanRetroResponse.body().toString());
                            boolean isSuccess = jsonObject.getBoolean("Success");
                            data.setValue(isSuccess);
                            if (jsonObject.getString("ResponseMessage") != null)
                                Toast.makeText(context, jsonObject.getString("ResponseMessage"), Toast.LENGTH_SHORT).show();

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


    private String changeDateFormat(String dateText) {
        Date date = null;
        try {
            DateFormat inputFormat = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss");
            DateFormat outputFormat = new SimpleDateFormat("DD-MM-YYYY");
            date = inputFormat.parse(dateText);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

    }

    public MutableLiveData<String> datePicker(String date) {
        final MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(date);
        return mutableLiveData;
    }

    public LiveData<List<PersonLanguage>> getPersonLanguage() {
        return DatabaseInitializer.loadLanguages(AppDataBase.getAppDatabase(context));
    }

    public LiveData<List<Ethnicity>> getEthnicity() {
        return DatabaseInitializer.loadEthnicity(AppDataBase.getAppDatabase(context));
    }

    public LiveData<List<Gender>> getGender() {
        return DatabaseInitializer.loadGender(AppDataBase.getAppDatabase(context));
    }

    public LiveData<List<MaritialStatus>> getMaritalStatus() {
        return DatabaseInitializer.loadMaritialStatus(AppDataBase.getAppDatabase(context));
    }

    public LiveData<List<Prefix>> getPrefix() {
        return DatabaseInitializer.loadPrefix(AppDataBase.getAppDatabase(context));
    }

    public LiveData<List<DisabilityType>> getDisabilityType() {
        return DatabaseInitializer.loadDisabilityType(AppDataBase.getAppDatabase(context));
    }

    public LiveData<List<Religion>> getReligion() {
        return DatabaseInitializer.loadReligion(AppDataBase.getAppDatabase(context));
    }

    public LiveData<List<SexualityType>> getSexualityType() {
        return DatabaseInitializer.loadSexualityType(AppDataBase.getAppDatabase(context));
    }

    public LiveData<List<Nationality>> getNationality() {
        return DatabaseInitializer.loadNationality(AppDataBase.getAppDatabase(context));
    }

    public String getDateFromLong(String data) {
        String date = null;


        return date;
    }

    private String checkIsNotNull(String value) {
        return value != null && !value.equalsIgnoreCase("null") ? value : "";
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
