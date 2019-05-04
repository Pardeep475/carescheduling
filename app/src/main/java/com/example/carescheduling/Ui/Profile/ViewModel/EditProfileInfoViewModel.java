package com.example.carescheduling.Ui.Profile.ViewModel;

import android.app.Application;
import android.content.Context;

import com.example.carescheduling.Ui.Dashboard.beans.ProfileBean;
import com.example.carescheduling.Ui.Profile.View.EditProfileInfo;
import com.example.carescheduling.Ui.Profile.bean.EditProfileInfoBean;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Local.DatabaseInitializer;
import com.example.carescheduling.data.Local.DatabaseTable.DisabilityType;
import com.example.carescheduling.data.Local.DatabaseTable.Ethnicity;
import com.example.carescheduling.data.Local.DatabaseTable.Gender;
import com.example.carescheduling.data.Local.DatabaseTable.MaritialStatus;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Local.DatabaseTable.Prefix;
import com.example.carescheduling.data.Local.DatabaseTable.Religion;
import com.example.carescheduling.data.Local.DatabaseTable.SexualityType;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class EditProfileInfoViewModel extends AndroidViewModel {
    private Context context;


    public EditProfileInfoViewModel(@NonNull Application application) {
        super(application);
        this.context = application;

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

    public LiveData<EditProfileInfoBean> getProfileEditBean(ProfileBean profileBean) {
        MutableLiveData<EditProfileInfoBean> editProfileInfoBeanMutableLiveData = new MutableLiveData<>();
        EditProfileInfoBean editProfileInfoBean = new EditProfileInfoBean();

//        private String firstName, middleName, surName, maidenName, dateOfBirth, gender, prefix,
//            language, maritalStatus, ethnicity, religion, sexuality, nationality;
//    private boolean disability;

        String firstName = "", middleName = "", surName = "", maidenName = "", dateOfBirth = "", gender = "", prefix = "",
                language = "", maritalStatus = "", ethnicity  = "", religion  = "", sexuality  = "", nationality = "";
        boolean disability;
        if (profileBean != null) {
//            first name
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null)
                firstName = checkIsNotNull(profileBean.getData().getPerson().getFirstName());
// middle name
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null)
                middleName = checkIsNotNull(profileBean.getData().getPerson().getMiddleName());
            // sur name
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null)
                surName = checkIsNotNull(profileBean.getData().getPerson().getSurName());
            // maiden name
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null)
                maidenName = checkIsNotNull(profileBean.getData().getPerson().getMaidenName());
            // date of birth
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null)
                dateOfBirth = checkIsNotNull(profileBean.getData().getPerson().getSurName());
            // gender
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null)
                gender = checkIsNotNull(profileBean.getData().getPerson().getGenderTypeName());
            // prefix
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null)
                prefix = checkIsNotNull(profileBean.getData().getPerson().getPrefixTypeName());
            // language
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null) {
                if (profileBean.getData().getPerson().getPersonLanguage().size() == 1) {
                    language = checkIsNotNull(profileBean.getData().getPerson().getPersonLanguage().get(0).getLanguageName());
                } else if (profileBean.getData().getPerson().getPersonLanguage().size() > 1) {
                    for (int i = 0; i < profileBean.getData().getPerson().getPersonLanguage().size(); i++) {
                        if (profileBean.getData().getPerson().getPersonLanguage().get(i).getIsDefaultLanguage())
                            language = checkIsNotNull(profileBean.getData().getPerson().getPersonLanguage().get(i).getLanguageName());
                    }
                } else if (profileBean.getData().getPerson().getPersonLanguage().size() > 0) {
                    language = checkIsNotNull(profileBean.getData().getPerson().getPersonLanguage().get(0).getLanguageName());
                }
            }
//            maritalStatus
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null) {
                if (profileBean.getData().getPerson().getPersonMaritalStatus().size() > 0)
                    maritalStatus = checkIsNotNull(profileBean.getData().getPerson().getPersonMaritalStatus().get(0).getMaritalStatusName());
            }
//            ethnicity
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null) {
                if (profileBean.getData().getPerson().getPersonEthnicity().size() > 0)
                    ethnicity = checkIsNotNull(profileBean.getData().getPerson().getPersonEthnicity().get(0).getEthnicityTypeName());
            }
//            religion
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null) {
                if (profileBean.getData().getPerson().getPersonReligion().size() > 0)
                    religion = checkIsNotNull(profileBean.getData().getPerson().getPersonReligion().get(0).getReligionTypeName());
            }
//            sexuality
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null) {
                if (profileBean.getData().getPerson().getPersonSexuality().size() > 0)
                    sexuality = checkIsNotNull(profileBean.getData().getPerson().getPersonSexuality().get(0).getSexualityTypeName());
            }
//            nationality
            if (profileBean.getData() != null && profileBean.getData().getPerson() != null) {
                if (profileBean.getData().getPerson().getPersonNationality().size() > 0)
                    nationality = checkIsNotNull(profileBean.getData().getPerson().getPersonNationality().get(0).getCountryName());
            }


            editProfileInfoBean.setDateOfBirth(dateOfBirth);
            editProfileInfoBean.setFirstName(firstName);
            editProfileInfoBean.setMiddleName(middleName);
            editProfileInfoBean.setSurName(surName);
            editProfileInfoBean.setMaidenName(maidenName);
            editProfileInfoBean.setGender(gender);
            editProfileInfoBean.setPrefix(prefix);
            editProfileInfoBean.setLanguage(language);
            editProfileInfoBean.setMaritalStatus(maritalStatus);
            editProfileInfoBean.setEthnicity(ethnicity);
            editProfileInfoBean.setReligion(religion);
            editProfileInfoBean.setSexuality(sexuality);
            editProfileInfoBean.setNationality(nationality);
            editProfileInfoBean.setDisability(true);

            editProfileInfoBeanMutableLiveData.setValue(editProfileInfoBean);
        }

        return editProfileInfoBeanMutableLiveData;
    }

    private String checkIsNotNull(String value) {
        return value != null ? value : "";
    }
}
