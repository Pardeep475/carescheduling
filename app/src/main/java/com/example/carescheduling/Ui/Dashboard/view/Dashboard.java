package com.example.carescheduling.Ui.Dashboard.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.example.carescheduling.R;
import com.example.carescheduling.Ui.Base.BaseActivity;
import com.example.carescheduling.Ui.Dashboard.ViewModel.DashboardViewModel;
import com.example.carescheduling.Ui.Dashboard.beans.EditMyProfile;
import com.example.carescheduling.Ui.Profile.View.EditProfile;
import com.example.carescheduling.Utils.ConnectivityReceiver;
import com.example.carescheduling.Utils.Constants;
import com.example.carescheduling.data.Local.AppDataBase;
import com.example.carescheduling.data.Local.DatabaseInitializer;
import com.example.carescheduling.data.Local.DatabaseTable.AddressType;
import com.example.carescheduling.data.Local.DatabaseTable.CountryCode;
import com.example.carescheduling.data.Local.DatabaseTable.DisabilityType;
import com.example.carescheduling.data.Local.DatabaseTable.EmailType;
import com.example.carescheduling.data.Local.DatabaseTable.Ethnicity;
import com.example.carescheduling.data.Local.DatabaseTable.Gender;
import com.example.carescheduling.data.Local.DatabaseTable.MaritialStatus;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Local.DatabaseTable.PhoneType;
import com.example.carescheduling.data.Local.DatabaseTable.Prefix;
import com.example.carescheduling.data.Local.DatabaseTable.Religion;
import com.example.carescheduling.data.Local.DatabaseTable.SexualityType;
import com.example.carescheduling.data.Local.SessionManager;
import com.example.carescheduling.databinding.ActivityDashboardBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dashboard extends BaseActivity {

    private ActivityDashboardBinding activityDashboardBinding;
    private DashboardViewModel dashboardViewModel;
    private SessionManager sessionManager;
    private boolean isDefaultData, isHomeData;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setFragment(SettingF.newInstance());
                    return true;
                case R.id.navigation_dashboard:
                    setFragment(HomeF.newInstance());
                    return true;
                case R.id.navigation_notifications:
                    setFragment(ProfileResult.newInstance());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        sessionManager = getSessionManager();
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        activityDashboardBinding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        activityDashboardBinding.navigation.setSelectedItemId(R.id.navigation_dashboard);
        setFragment(HomeF.newInstance());
        showDialog();
        getDefaultData();
        setUpAllHomeData();
    }

    //                android:text="Monday 14 of July 2016 02:34"

    private void setUpAllHomeData() {
        if (ConnectivityReceiver.isNetworkAvailable(this)) {
            try {
                dashboardViewModel.GetAllHomeDataApi(getSessionManager().getPersonId(), getSessionManager().getCustomerId(), getSessionManager().getBranchId()).observe(this, new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean aBoolean) {
                        isHomeData = true;
                        if (isDefaultData && isHomeData)
                            hideDialog();
                    }
                });
            }catch (Exception e) {

                isHomeData = true;
                if (isDefaultData && isHomeData)
                    hideDialog();
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        } else {
            hideDialog();
            Toast.makeText(this, "please check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    private void getDefaultData() {
        if (ConnectivityReceiver.isNetworkAvailable(this)) {
            try {
                LiveData<EditMyProfile> editMyProfileLiveData = dashboardViewModel.getEditMyProfileData(sessionManager.getCustomerId());
                editMyProfileLiveData.observe(this, new Observer<EditMyProfile>() {
                    @Override
                    public void onChanged(EditMyProfile editMyProfile) {
                        isDefaultData = true;
                        if (isDefaultData && isHomeData)
                            hideDialog();
                        if (editMyProfile != null) {
                            parseData(editMyProfile);
                        }
                    }
                });
            } catch (Exception e) {
                isDefaultData = true;
                if (isDefaultData && isHomeData)
                    hideDialog();
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        } else {
            hideDialog();
            Toast.makeText(this, "please check your internet connection", Toast.LENGTH_SHORT).show();
        }
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_dashboard_main_container, fragment).commitAllowingStateLoss();
    }

    private void parseData(EditMyProfile myProfile) {
        if (myProfile != null && myProfile.getData() != null && myProfile.getData() != null) {
//            gender data
            if (myProfile.getData().getCustomerGender() != null && myProfile.getData().getCustomerGender().size() > 0) {
                GenderData(myProfile.getData().getCustomerGender());
            }
//            prefix
            if (myProfile.getData().getCustomerPrefix() != null && myProfile.getData().getCustomerPrefix().size() > 0) {
                PrefixData(myProfile.getData().getCustomerPrefix());
            }
//            language
            if (myProfile.getData().getCustomerLanguage() != null && myProfile.getData().getCustomerLanguage().size() > 0) {
                LanguageData(myProfile.getData().getCustomerLanguage());
            }
            //            Marital Status
            if (myProfile.getData().getCustomerMaritalStatusType() != null && myProfile.getData().getCustomerMaritalStatusType().size() > 0) {
                MaritalStatusData(myProfile.getData().getCustomerMaritalStatusType());
            }
            //            CustomerEthnicityType
            if (myProfile.getData().getCustomerEthnicityType() != null && myProfile.getData().getCustomerEthnicityType().size() > 0) {
                EthnicityData(myProfile.getData().getCustomerEthnicityType());
            }
            // disability type
            if (myProfile.getData().getCustomerDisabilityType() != null && myProfile.getData().getCustomerDisabilityType().size() > 0) {
                CustomerDisabilityType(myProfile.getData().getCustomerDisabilityType());
            }
            // Sexuality type
            if (myProfile.getData().getCustomerSexualityType() != null && myProfile.getData().getCustomerSexualityType().size() > 0) {
                CustomerSexualityType(myProfile.getData().getCustomerSexualityType());
            }
            // countryCode type
            if (myProfile.getData().getCustomerTelephoneCountryPrefix() != null && myProfile.getData().getCustomerTelephoneCountryPrefix().size() > 0) {
                CustomerCountryCode(myProfile.getData().getCustomerTelephoneCountryPrefix());
            }

//            Religion
            if (myProfile.getData().getCustomerReligionType() != null && myProfile.getData().getCustomerReligionType().size() > 0) {
                ReligionData(myProfile.getData().getCustomerReligionType());
            }
            //            Nationality
            if (myProfile.getData().getCustomerCountry() != null && myProfile.getData().getCustomerCountry().size() > 0) {
                NationalityData(myProfile.getData().getCustomerCountry());
            }

            //            AddressType
            if (myProfile.getData().getCustomerAddressType() != null && myProfile.getData().getCustomerAddressType().size() > 0) {
                AddressTypeData(myProfile.getData().getCustomerAddressType());
            }

            //            Phone Data
            if (myProfile.getData().getCustomerPhoneType() != null && myProfile.getData().getCustomerPhoneType().size() > 0) {
                PhoneTypeData(myProfile.getData().getCustomerPhoneType());
            }
            //            Email Type
            if (myProfile.getData().getCustomerEmailType() != null && myProfile.getData().getCustomerEmailType().size() > 0) {
                EmailTypeData(myProfile.getData().getCustomerEmailType());
            }
        }
    }

    private void PhoneTypeData(List<EditMyProfile.CustomerPhoneType> customerPhoneType) {
        List<PhoneType> phoneTypes = new ArrayList<>();
        for (int i = 0; i < customerPhoneType.size(); i++) {
            PhoneType phoneType = new PhoneType();
            phoneType.setPhoneName(customerPhoneType.get(i).getPhoneTypeName());
            phoneTypes.add(phoneType);
        }
        DatabaseInitializer.populateAsyncPhoneType(AppDataBase.getAppDatabase(this), phoneTypes);
    }

    private void EmailTypeData(List<EditMyProfile.CustomerEmailType> customerEmailType) {
        List<EmailType> emailTypes = new ArrayList<>();
        for (int i = 0; i < customerEmailType.size(); i++) {
            EmailType emailType = new EmailType();
            emailType.setEmailName(customerEmailType.get(i).getEmailTypeName());
            emailTypes.add(emailType);
        }
        DatabaseInitializer.populateAsyncEmailType(AppDataBase.getAppDatabase(this), emailTypes);
    }

    private void AddressTypeData(List<EditMyProfile.CustomerAddressType> customerAddressType) {
        List<AddressType> addressTypes = new ArrayList<>();
        for (int i = 0; i < customerAddressType.size(); i++) {
            AddressType addressType = new AddressType();
            addressType.setAddressName(customerAddressType.get(i).getAddressTypeName());
            addressTypes.add(addressType);
        }
        DatabaseInitializer.populateAsyncAddressType(AppDataBase.getAppDatabase(this), addressTypes);
    }

    private void CustomerCountryCode(List<EditMyProfile.CustomerTelephoneCountryPrefix> customerTelephoneCountryPrefix) {
        List<CountryCode> countryCodes = new ArrayList<>();
        for (int i = 0; i < customerTelephoneCountryPrefix.size(); i++) {
            CountryCode countryCode = new CountryCode();
            countryCode.setCountryName(customerTelephoneCountryPrefix.get(i).getCountryTelephonePrefix());
            countryCodes.add(countryCode);
        }
        DatabaseInitializer.populateAsyncCountryCode(AppDataBase.getAppDatabase(this), countryCodes);
    }

    private void CustomerSexualityType(List<EditMyProfile.CustomerSexualityType> customerSexualityType) {
        List<SexualityType> sexualityTypes = new ArrayList<>();
        for (int i = 0; i < customerSexualityType.size(); i++) {
            SexualityType sexualityType = new SexualityType();
            sexualityType.setSexualityName(customerSexualityType.get(i).getSexualityTypeName());
            sexualityTypes.add(sexualityType);
        }
        DatabaseInitializer.populateAsyncSexualityType(AppDataBase.getAppDatabase(this), sexualityTypes);
    }

    private void CustomerDisabilityType(List<EditMyProfile.CustomerDisabilityType> customerDisabilityType) {
        List<DisabilityType> disabilityTypes = new ArrayList<>();
        for (int i = 0; i < customerDisabilityType.size(); i++) {
            DisabilityType disabilityType = new DisabilityType();
            disabilityType.setDisabilityName(customerDisabilityType.get(i).getDisabilityTypeName());
            disabilityTypes.add(disabilityType);
        }
        DatabaseInitializer.populateAsyncDisabilityType(AppDataBase.getAppDatabase(this), disabilityTypes);
    }

    private void ReligionData(List<EditMyProfile.CustomerReligionType> customerReligionType) {
        List<Religion> religions = new ArrayList<>();
        for (int i = 0; i < customerReligionType.size(); i++) {
            Religion religion = new Religion();
            religion.setReligionName(customerReligionType.get(i).getReligionTypeName());
            religions.add(religion);
        }
        DatabaseInitializer.populateAsyncReligion(AppDataBase.getAppDatabase(this), religions);
    }

    private void NationalityData(List<EditMyProfile.CustomerCountry> customerReligionType) {
        List<Nationality> nationalities = new ArrayList<>();
        for (int i = 0; i < customerReligionType.size(); i++) {
            Nationality nationality = new Nationality();
            nationality.setNationalityName(customerReligionType.get(i).getCountryName());
            nationalities.add(nationality);
        }
        DatabaseInitializer.populateAsyncNationality(AppDataBase.getAppDatabase(this), nationalities);
    }

    private void EthnicityData(List<EditMyProfile.CustomerEthnicityType> customerEthnicityType) {
        List<Ethnicity> ethnicityList = new ArrayList<>();
        for (int i = 0; i < customerEthnicityType.size(); i++) {
            Ethnicity ethnicity = new Ethnicity();
            ethnicity.setEthnicityName(customerEthnicityType.get(i).getEthnicityTypeName());
            ethnicityList.add(ethnicity);
        }
        DatabaseInitializer.populateAsyncEthnicity(AppDataBase.getAppDatabase(this), ethnicityList);
    }

    private void MaritalStatusData(List<EditMyProfile.CustomerMaritalStatusType> customerMaritalStatusType) {
        List<MaritialStatus> maritialStatusList = new ArrayList<>();
        for (int i = 0; i < customerMaritalStatusType.size(); i++) {
            MaritialStatus maritialStatus = new MaritialStatus();
            maritialStatus.setMaritialStatusName(customerMaritalStatusType.get(i).getMaritalStatusTypeName());
            maritialStatusList.add(maritialStatus);
        }
        DatabaseInitializer.populateAsyncMaritialStatus(AppDataBase.getAppDatabase(this), maritialStatusList);
    }

    private void LanguageData(List<EditMyProfile.CustomerLanguage> customerLanguage) {
        List<PersonLanguage> personLanguageList = new ArrayList<>();
        for (int i = 0; i < customerLanguage.size(); i++) {
            PersonLanguage personLanguage = new PersonLanguage();
            personLanguage.setLanguageName(customerLanguage.get(i).getLanguageName());
            personLanguageList.add(personLanguage);
        }

        DatabaseInitializer.populateAsyncLanguage(AppDataBase.getAppDatabase(this), personLanguageList);
    }

    private void PrefixData(List<EditMyProfile.CustomerPrefix> customerPrefix) {
        List<Prefix> personPrefix = new ArrayList<>();
        for (int i = 0; i < customerPrefix.size(); i++) {
            Prefix prefix = new Prefix();
            prefix.setPrefixName(customerPrefix.get(i).getPrefixTypeName());
            personPrefix.add(prefix);
        }
        DatabaseInitializer.populateAsyncPrefix(AppDataBase.getAppDatabase(this), personPrefix);
    }

    private void GenderData(List<EditMyProfile.CustomerGender> customerGender) {
        List<Gender> genderList = new ArrayList<>();
        for (int i = 0; i < customerGender.size(); i++) {
            Gender gender = new Gender();
            gender.setGenderName(customerGender.get(i).getGenderTypeName());
            genderList.add(gender);
        }
        DatabaseInitializer.populateAsyncGender(AppDataBase.getAppDatabase(this), genderList);
    }

}
