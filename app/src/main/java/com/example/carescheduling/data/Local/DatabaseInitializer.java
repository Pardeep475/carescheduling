package com.example.carescheduling.data.Local;

import android.os.AsyncTask;
import android.util.Log;

import com.example.carescheduling.Ui.Profile.bean.ImageDataBean;
import com.example.carescheduling.Ui.Profile.bean.PersonEmailList;
import com.example.carescheduling.Ui.Profile.bean.PersonPhoneList;
import com.example.carescheduling.data.Local.DatabaseTable.AddressAllData;
import com.example.carescheduling.data.Local.DatabaseTable.AddressType;
import com.example.carescheduling.data.Local.DatabaseTable.CountryCode;
import com.example.carescheduling.data.Local.DatabaseTable.DisabilityType;
import com.example.carescheduling.data.Local.DatabaseTable.EmailType;
import com.example.carescheduling.data.Local.DatabaseTable.Ethnicity;
import com.example.carescheduling.data.Local.DatabaseTable.Gender;
import com.example.carescheduling.data.Local.DatabaseTable.MaritialStatus;
import com.example.carescheduling.data.Local.DatabaseTable.Nationality;
import com.example.carescheduling.data.Local.DatabaseTable.PersonAllAddressEntity;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Local.DatabaseTable.PhoneType;
import com.example.carescheduling.data.Local.DatabaseTable.Prefix;
import com.example.carescheduling.data.Local.DatabaseTable.ProfileInfo;
import com.example.carescheduling.data.Local.DatabaseTable.ProfileMainData;
import com.example.carescheduling.data.Local.DatabaseTable.Religion;
import com.example.carescheduling.data.Local.DatabaseTable.SexualityType;
import com.example.carescheduling.data.Local.DatabaseTable.UserInfo;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

public class DatabaseInitializer {


    private static final String TAG = DatabaseInitializer.class.getName();

    private static MutableLiveData<List<PersonLanguage>> personLanguageLiveData = new MutableLiveData<>();
    private static MutableLiveData<List<Ethnicity>> ethnicityLiveData = new MutableLiveData<>();
    private static MutableLiveData<List<Gender>> genderLiveData = new MutableLiveData<>();
    private static MutableLiveData<List<MaritialStatus>> maritalStatusLiveData = new MutableLiveData<>();
    private static MutableLiveData<List<Prefix>> prefixLiveData = new MutableLiveData<>();
    private static MutableLiveData<List<DisabilityType>> disabilityTypeLiveData = new MutableLiveData<>();
    private static MutableLiveData<List<SexualityType>> sexualityTypeLiveData = new MutableLiveData<>();
    private static MutableLiveData<List<CountryCode>> countryCodeLiveData = new MutableLiveData<>();
    private static MutableLiveData<List<Religion>> religionLiveData = new MutableLiveData<>();
    private static MutableLiveData<List<Nationality>> nationalityLiveData = new MutableLiveData<>();
    private static MutableLiveData<List<PhoneType>> phoneLiveData = new MutableLiveData<>();
    private static MutableLiveData<List<AddressType>> addressTypeLiveData = new MutableLiveData<>();
    private static MutableLiveData<List<EmailType>> emailTypeLiveData = new MutableLiveData<>();

    // language
    public static void populateAsyncLanguage(@NonNull final AppDataBase db, List<PersonLanguage> list) {

        PopulateDbAsyncLanguage task = new PopulateDbAsyncLanguage(db, list);
        task.execute();
    }

    // Ethnicity
    public static void populateAsyncEthnicity(@NonNull final AppDataBase db, List<Ethnicity> list) {

        PopulateDbAsyncEthnicity task = new PopulateDbAsyncEthnicity(db, list);
        task.execute();
    }

    // Gender
    public static void populateAsyncGender(@NonNull final AppDataBase db, List<Gender> list) {

        PopulateDbAsyncGender task = new PopulateDbAsyncGender(db, list);
        task.execute();
    }

    // MaritialStatus
    public static void populateAsyncMaritialStatus(@NonNull final AppDataBase db, List<MaritialStatus> list) {

        PopulateDbAsyncMaritialStatus task = new PopulateDbAsyncMaritialStatus(db, list);
        task.execute();
    }

    // Prefix
    public static void populateAsyncPrefix(@NonNull final AppDataBase db, List<Prefix> list) {

        PopulateDbAsyncPrefix task = new PopulateDbAsyncPrefix(db, list);
        task.execute();
    }

    // disability type
    public static void populateAsyncDisabilityType(@NonNull final AppDataBase db, List<DisabilityType> list) {

        PopulateDbAsyncDisabilityType task = new PopulateDbAsyncDisabilityType(db, list);
        task.execute();
    }

    //    SexualityType
    public static void populateAsyncSexualityType(@NonNull final AppDataBase db, List<SexualityType> list) {
        PopulateDbAsyncSexualityType task = new PopulateDbAsyncSexualityType(db, list);
        task.execute();
    }

    //    CountryCode
    public static void populateAsyncCountryCode(@NonNull final AppDataBase db, List<CountryCode> list) {
        PopulateDbAsyncCountryCode task = new PopulateDbAsyncCountryCode(db, list);
        task.execute();
    }

    //    Religion
    public static void populateAsyncReligion(@NonNull final AppDataBase db, List<Religion> list) {
        PopulateDbAsyncReligion task = new PopulateDbAsyncReligion(db, list);
        task.execute();
    }

    //    Nationality
    public static void populateAsyncNationality(@NonNull final AppDataBase db, List<Nationality> list) {
        PopulateDbAsyncNationality task = new PopulateDbAsyncNationality(db, list);
        task.execute();
    }

    //    phone Type
    public static void populateAsyncPhoneType(@NonNull final AppDataBase db, List<PhoneType> list) {
        PopulateDbAsyncPhoneType task = new PopulateDbAsyncPhoneType(db, list);
        task.execute();
    }

    //   AddressType
    public static void populateAsyncAddressType(@NonNull final AppDataBase db, List<AddressType> list) {
        PopulateDbAsyncAddressType task = new PopulateDbAsyncAddressType(db, list);
        task.execute();
    }

    //   EmailType
    public static void populateAsyncEmailType(@NonNull final AppDataBase db, List<EmailType> list) {
        PopulateDbAsyncEmailType task = new PopulateDbAsyncEmailType(db, list);
        task.execute();
    }

//    //   ProfileResultBean
    public static void populateAsyncProfileMainData(@NonNull final AppDataBase db, ProfileMainData list) {
        PopulateDbAsyncProfileMainData task = new PopulateDbAsyncProfileMainData(db, list);
        task.execute();
    }

    //   ProfileMainData
    public static void populateAsyncProfileInfo(@NonNull final AppDataBase db, ProfileInfo list) {
        PopulateDbAsyncProfileInfo task = new PopulateDbAsyncProfileInfo(db, list);
        task.execute();
    }

    //   UserInfo
    public static void populateAsyncUserInfo(@NonNull final AppDataBase db, UserInfo list) {
        PopulateDbAsyncUserInfo task = new PopulateDbAsyncUserInfo(db, list);
        task.execute();
    }

    //   ImageDataBean
    public static void populateAsyncImageDataBean(@NonNull final AppDataBase db, List<ImageDataBean> list) {
        PopulateDbAsyncImageDataBean task = new PopulateDbAsyncImageDataBean(db, list);
        task.execute();
    }

    //ImageDataBean
    private static class PopulateDbAsyncImageDataBean extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<ImageDataBean> list;

        PopulateDbAsyncImageDataBean(AppDataBase db, List<ImageDataBean> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithImageDataBeanData(mDb, list);
            return null;
        }

    }

    private static void populateWithImageDataBeanData(AppDataBase db, List<ImageDataBean> list) {
        int count = db.profileDao().countImageDataBean();
        if (count > 0)
            db.profileDao().deleteAll();
        for (ImageDataBean user : list) {
            addUserImageDataBean(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "ImageDataBean Count: " + db.profileDao().countImageDataBean());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserImageDataBean(final AppDataBase db, ImageDataBean user) {
        db.profileDao().insertImageDataBean(user);
    }

    //   PersonAllAddressEntity
    public static void populateAsyncPersonAllAddressEntity(@NonNull final AppDataBase db, List<PersonAllAddressEntity> list) {
        PopulateDbAsyncPersonAllAddressEntity task = new PopulateDbAsyncPersonAllAddressEntity(db, list);
        task.execute();
    }

    private static class PopulateDbAsyncPersonAllAddressEntity extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<PersonAllAddressEntity> list;

        PopulateDbAsyncPersonAllAddressEntity(AppDataBase db, List<PersonAllAddressEntity> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithPersonAllAddressEntityData(mDb, list);
            return null;
        }

    }

    private static void populateWithPersonAllAddressEntityData(AppDataBase db, List<PersonAllAddressEntity> list) {
        int count = db.profileDao().countPersonAllAddressEntity();
        if (count > 0)
            db.profileDao().deletePersonAllAddressEntity();
        for (PersonAllAddressEntity user : list) {
            addUserPersonAllAddressEntity(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "PersonAllAddressEntity Count: " + db.profileDao().countPersonAllAddressEntity());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserPersonAllAddressEntity(final AppDataBase db, PersonAllAddressEntity user) {
        db.profileDao().insertPersonAllAddressEntity(user);
    }

    //   PersonEmailList
    public static void populateAsyncPersonEmailList(@NonNull final AppDataBase db, List<PersonEmailList> list) {
        PopulateDbAsyncPersonEmailList task = new PopulateDbAsyncPersonEmailList(db, list);
        task.execute();
    }

    private static class PopulateDbAsyncPersonEmailList extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<PersonEmailList> list;

        PopulateDbAsyncPersonEmailList(AppDataBase db, List<PersonEmailList> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithPersonEmailListData(mDb, list);
            return null;
        }

    }

    private static void populateWithPersonEmailListData(AppDataBase db, List<PersonEmailList> list) {
        int count = db.profileDao().countPersonEmailList();
        if (count > 0)
            db.profileDao().deletePersonEmailList();
        for (PersonEmailList user : list) {
            addUserPersonEmailList(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "PersonEmailList Count: " + db.profileDao().countPersonEmailList());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserPersonEmailList(final AppDataBase db, PersonEmailList user) {
        db.profileDao().insertPersonEmailList(user);
    }

    //   PersonPhoneList
    public static void populateAsyncPersonPhoneList(@NonNull final AppDataBase db, List<PersonPhoneList> list) {
        PopulateDbAsyncPersonPhoneList task = new PopulateDbAsyncPersonPhoneList(db, list);
        task.execute();
    }

    private static class PopulateDbAsyncPersonPhoneList extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<PersonPhoneList> list;

        PopulateDbAsyncPersonPhoneList(AppDataBase db, List<PersonPhoneList> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithPersonPhoneListData(mDb, list);
            return null;
        }

    }

    private static void populateWithPersonPhoneListData(AppDataBase db, List<PersonPhoneList> list) {
        int count = db.profileDao().countPersonPhoneList();
        if (count > 0)
            db.profileDao().deletePersonPhoneList();
        for (PersonPhoneList user : list) {
            addUserPersonPhoneList(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "PersonPhoneList Count: " + db.profileDao().countPersonPhoneList());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserPersonPhoneList(final AppDataBase db, PersonPhoneList user) {
        db.profileDao().insertPersonPhoneList(user);
    }







//       AddressAllData
//    public static void populateAsyncAddressAllData(@NonNull final AppDataBase db, AddressAllData list) {
//        PopulateDbAsyncAddressAllData task = new PopulateDbAsyncAddressAllData(db, list);
//        task.execute();
//    }

//     UserInfo
    private static class PopulateDbAsyncUserInfo extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private UserInfo list;

        PopulateDbAsyncUserInfo(AppDataBase db, UserInfo list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithUserInfoData(mDb, list);
            return null;
        }

    }

    private static void populateWithUserInfoData(AppDataBase db, UserInfo list) {
        int userList = db.profileDao().countUserInfo();
        if (userList >= 0)
            db.profileDao().deleteUserInfo();

        addUserInfo(db, list);
        Log.d(DatabaseInitializer.TAG, "Language Count: " + db.profileDao().getAllLanguages());
    }

    private static void addUserInfo(final AppDataBase db, UserInfo user) {
        db.profileDao().insertUserInfo(user);
    }

    // AddressAllData
//    private static class PopulateDbAsyncAddressAllData extends AsyncTask<Void, Void, Void> {
//
//        private final AppDataBase mDb;
//        private AddressAllData list;
//
//        PopulateDbAsyncAddressAllData(AppDataBase db, AddressAllData list) {
//            mDb = db;
//            this.list = list;
//        }
//
//        @Override
//        protected Void doInBackground(final Void... params) {
//            populateWithAddressAllDataData(mDb, list);
//            return null;
//        }
//
//    }

//    private static void populateWithAddressAllDataData(AppDataBase db, AddressAllData list) {
//        int userList = db.profileDao().countAddressAllData();
//        if (userList >= 0)
//            db.profileDao().deleteAddressAllData();
//
//        addAddressAllData(db, list);
//        Log.d(DatabaseInitializer.TAG, "Language Count: " + db.profileDao().getAllLanguages());
//    }
//
//    private static void addAddressAllData(final AppDataBase db, AddressAllData user) {
//        db.profileDao().insertAddressAllData(user);
//    }


//     ProfileInfo
    private static class PopulateDbAsyncProfileInfo extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private ProfileInfo list;

        PopulateDbAsyncProfileInfo(AppDataBase db, ProfileInfo list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithProfileInfoData(mDb, list);
            return null;
        }

    }

    private static void populateWithProfileInfoData(AppDataBase db, ProfileInfo list) {
        int userList = db.profileDao().countProfileInfo();
        if (userList >= 0)
            db.profileDao().deleteProfileInfo();

        addProfileInfo(db, list);
        Log.d(DatabaseInitializer.TAG, "Language Count: " + db.profileDao().getAllLanguages());
    }

    private static void addProfileInfo(final AppDataBase db, ProfileInfo user) {
        db.profileDao().insertProfileInfo(user);
    }

//     ProfileMainData
    private static class PopulateDbAsyncProfileMainData extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private ProfileMainData list;

        PopulateDbAsyncProfileMainData(AppDataBase db, ProfileMainData list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithProfileMainDataData(mDb, list);
            return null;
        }

    }

    private static void populateWithProfileMainDataData(AppDataBase db, ProfileMainData list) {
        int userList = db.profileDao().countProfileMainData();
        if (userList >= 0)
            db.profileDao().deleteProfileMainData();

        addProfileMainData(db, list);
        Log.d(DatabaseInitializer.TAG, "Language Count: " + db.profileDao().getAllLanguages());
    }

    private static void addProfileMainData(final AppDataBase db, ProfileMainData user) {
        db.profileDao().insertProfileMainData(user);
    }

    //language
    private static class PopulateDbAsyncLanguage extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<PersonLanguage> list;

        PopulateDbAsyncLanguage(AppDataBase db, List<PersonLanguage> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithLanguageData(mDb, list);
            return null;
        }

    }

    private static void populateWithLanguageData(AppDataBase db, List<PersonLanguage> list) {
        List<PersonLanguage> userList = db.profileDao().getAllLanguages();
        if (userList.size() > 0)
            db.profileDao().deleteAll();
        for (PersonLanguage user : list) {
            addUserLanguage(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Language Count: " + db.profileDao().getAllLanguages());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserLanguage(final AppDataBase db, PersonLanguage user) {
        db.profileDao().insertAllLanguage(user);
    }

    //    Ethnicity
    private static class PopulateDbAsyncEthnicity extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<Ethnicity> list;

        PopulateDbAsyncEthnicity(AppDataBase db, List<Ethnicity> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithEthnicityData(mDb, list);
            return null;
        }

    }

    private static void populateWithEthnicityData(AppDataBase db, List<Ethnicity> list) {
        List<Ethnicity> userList = db.profileDao().getAllEthnicity();
        if (userList.size() > 0)
            db.profileDao().deleteAllEthnicity();
        for (Ethnicity user : list) {
            addUserEthnicity(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserEthnicity(final AppDataBase db, Ethnicity user) {
        db.profileDao().insertAllEthnicity(user);
    }

    //    Gender
    private static class PopulateDbAsyncGender extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<Gender> list;

        PopulateDbAsyncGender(AppDataBase db, List<Gender> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithGenderData(mDb, list);
            return null;
        }

    }

    private static void populateWithGenderData(AppDataBase db, List<Gender> list) {
        List<Gender> userList = db.profileDao().getAllGender();
        if (userList.size() > 0)
            db.profileDao().deleteAllGender();
        for (Gender user : list) {
            addUserGender(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserGender(final AppDataBase db, Gender user) {
        db.profileDao().insertAllGender(user);
    }

    //    MaritialStatus
    private static class PopulateDbAsyncMaritialStatus extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<MaritialStatus> list;

        PopulateDbAsyncMaritialStatus(AppDataBase db, List<MaritialStatus> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithMaritialStatusData(mDb, list);
            return null;
        }

    }

    private static void populateWithMaritialStatusData(AppDataBase db, List<MaritialStatus> list) {
        List<MaritialStatus> userList = db.profileDao().getAllMaritialStatus();
        if (userList.size() > 0)
            db.profileDao().deleteAllMaritialStatus();
        for (MaritialStatus user : list) {
            addUserMaritialStatus(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserMaritialStatus(final AppDataBase db, MaritialStatus user) {
        db.profileDao().insertAllMaritialStatus(user);
    }

    //    Prefix
    private static class PopulateDbAsyncPrefix extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<Prefix> list;

        PopulateDbAsyncPrefix(AppDataBase db, List<Prefix> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithPrefixData(mDb, list);
            return null;
        }

    }

    private static void populateWithPrefixData(AppDataBase db, List<Prefix> list) {
        List<Prefix> userList = db.profileDao().getAllPrefix();
        if (userList.size() > 0)
            db.profileDao().deleteAllPrefix();
        for (Prefix user : list) {
            addUserPrefix(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserPrefix(final AppDataBase db, Prefix user) {
        db.profileDao().insertAllPrefix(user);
    }

    //    PopulateDbAsyncDisabilityType
    private static class PopulateDbAsyncDisabilityType extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<DisabilityType> list;

        PopulateDbAsyncDisabilityType(AppDataBase db, List<DisabilityType> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithDisabilityTypeData(mDb, list);
            return null;
        }

    }

    private static void populateWithDisabilityTypeData(AppDataBase db, List<DisabilityType> list) {
        List<DisabilityType> userList = db.profileDao().getAllDisabilityType();
        if (userList.size() > 0)
            db.profileDao().deleteAllDisabilityType();
        for (DisabilityType user : list) {
            addUserDisabilityType(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserDisabilityType(final AppDataBase db, DisabilityType user) {
        db.profileDao().insertAllDisabilityType(user);
    }

    //    SexualityType
    private static class PopulateDbAsyncSexualityType extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<SexualityType> list;

        PopulateDbAsyncSexualityType(AppDataBase db, List<SexualityType> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithSexualityTypeData(mDb, list);
            return null;
        }

    }

    private static void populateWithSexualityTypeData(AppDataBase db, List<SexualityType> list) {
        List<SexualityType> userList = db.profileDao().getAllSexualityType();
        if (userList.size() > 0)
            db.profileDao().deleteAllSexualityType();
        for (SexualityType user : list) {
            addUserSexualityType(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserSexualityType(final AppDataBase db, SexualityType user) {
        db.profileDao().insertAllSexualityType(user);
    }

    //    CountryCode
    private static class PopulateDbAsyncCountryCode extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<CountryCode> list;

        PopulateDbAsyncCountryCode(AppDataBase db, List<CountryCode> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithCountryCodeData(mDb, list);
            return null;
        }

    }

    private static void populateWithCountryCodeData(AppDataBase db, List<CountryCode> list) {
        List<CountryCode> userList = db.profileDao().getAllCountryCode();
        if (userList.size() > 0)
            db.profileDao().deleteAllCountryCode();
        for (CountryCode user : list) {
            addUserCountryCode(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserCountryCode(final AppDataBase db, CountryCode user) {
        db.profileDao().insertAllCountryCode(user);
    }

    //    Religion
    private static class PopulateDbAsyncReligion extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<Religion> list;

        PopulateDbAsyncReligion(AppDataBase db, List<Religion> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithReligionData(mDb, list);
            return null;
        }

    }

    private static void populateWithReligionData(AppDataBase db, List<Religion> list) {
        List<Religion> userList = db.profileDao().getAllReligion();
        if (userList.size() > 0)
            db.profileDao().deleteAllReligion();
        for (Religion user : list) {
            addUserReligion(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserReligion(final AppDataBase db, Religion user) {
        db.profileDao().insertAllReligion(user);
    }

    //    Nationality
    private static class PopulateDbAsyncNationality extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<Nationality> list;

        PopulateDbAsyncNationality(AppDataBase db, List<Nationality> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithNationalityData(mDb, list);
            return null;
        }

    }

    private static void populateWithNationalityData(AppDataBase db, List<Nationality> list) {
        List<Nationality> userList = db.profileDao().getAllNationality();
        if (userList.size() > 0)
            db.profileDao().deleteAllNationality();
        for (Nationality user : list) {
            addUserNationality(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserNationality(final AppDataBase db, Nationality user) {
        db.profileDao().insertAllNationality(user);
    }


    //    PhoneType
    private static class PopulateDbAsyncPhoneType extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<PhoneType> list;

        PopulateDbAsyncPhoneType(AppDataBase db, List<PhoneType> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithPhoneTypeData(mDb, list);
            return null;
        }

    }

    private static void populateWithPhoneTypeData(AppDataBase db, List<PhoneType> list) {
        List<PhoneType> userList = db.profileDao().getAllPhoneType();
        if (userList.size() > 0)
            db.profileDao().deleteAllPhoneType();
        for (PhoneType user : list) {
            addUserPhoneType(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserPhoneType(final AppDataBase db, PhoneType user) {
        db.profileDao().insertAllPhoneType(user);
    }


    //    AddressType
    private static class PopulateDbAsyncAddressType extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<AddressType> list;

        PopulateDbAsyncAddressType(AppDataBase db, List<AddressType> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithAddressTypeData(mDb, list);
            return null;
        }

    }

    private static void populateWithAddressTypeData(AppDataBase db, List<AddressType> list) {
        List<AddressType> userList = db.profileDao().getAllAddressType();
        if (userList.size() > 0)
            db.profileDao().deleteAllAddressType();
        for (AddressType user : list) {
            addUserAddressType(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserAddressType(final AppDataBase db, AddressType user) {
        db.profileDao().insertAllAddressType(user);
    }

    //    EmailType
    private static class PopulateDbAsyncEmailType extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<EmailType> list;

        PopulateDbAsyncEmailType(AppDataBase db, List<EmailType> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithEmailTypeData(mDb, list);
            return null;
        }

    }

    private static void populateWithEmailTypeData(AppDataBase db, List<EmailType> list) {
        List<EmailType> userList = db.profileDao().getAllEmailType();
        if (userList.size() > 0)
            db.profileDao().deleteAllEmailType();
        for (EmailType user : list) {
            addUserEmailType(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserEmailType(final AppDataBase db, EmailType user) {
        db.profileDao().insertAllEmailType(user);
    }


    // get Languages
    public static MutableLiveData<List<PersonLanguage>> loadLanguages(final AppDataBase db) {
        new AsyncTask<Void, Void, List<PersonLanguage>>() {
            @Override
            protected List<PersonLanguage> doInBackground(Void... params) {
                return db.profileDao().getAllLanguages();
            }

            @Override
            protected void onPostExecute(List<PersonLanguage> notes) {
                personLanguageLiveData.setValue(notes);
            }
        }.execute();
        return personLanguageLiveData;
    }

    //    get Ethnicity
    public static MutableLiveData<List<Ethnicity>> loadEthnicity(final AppDataBase db) {
        new AsyncTask<Void, Void, List<Ethnicity>>() {
            @Override
            protected List<Ethnicity> doInBackground(Void... params) {
                return db.profileDao().getAllEthnicity();
            }

            @Override
            protected void onPostExecute(List<Ethnicity> notes) {
                ethnicityLiveData.setValue(notes);
            }
        }.execute();
        return ethnicityLiveData;
    }

    //    get Marital Status
    public static MutableLiveData<List<MaritialStatus>> loadMaritialStatus(final AppDataBase db) {
        new AsyncTask<Void, Void, List<MaritialStatus>>() {
            @Override
            protected List<MaritialStatus> doInBackground(Void... params) {
                return db.profileDao().getAllMaritialStatus();
            }

            @Override
            protected void onPostExecute(List<MaritialStatus> notes) {
                maritalStatusLiveData.setValue(notes);
            }
        }.execute();
        return maritalStatusLiveData;
    }

    //get Gender
    public static MutableLiveData<List<Gender>> loadGender(final AppDataBase db) {
        new AsyncTask<Void, Void, List<Gender>>() {
            @Override
            protected List<Gender> doInBackground(Void... params) {
                return db.profileDao().getAllGender();
            }

            @Override
            protected void onPostExecute(List<Gender> notes) {
                genderLiveData.setValue(notes);
            }
        }.execute();
        return genderLiveData;
    }

    // get Prefix
    public static MutableLiveData<List<Prefix>> loadPrefix(final AppDataBase db) {
        new AsyncTask<Void, Void, List<Prefix>>() {
            @Override
            protected List<Prefix> doInBackground(Void... params) {
                return db.profileDao().getAllPrefix();
            }

            @Override
            protected void onPostExecute(List<Prefix> notes) {
                prefixLiveData.setValue(notes);
            }
        }.execute();

        return prefixLiveData;
    }

    // get DisabilityType
    public static MutableLiveData<List<DisabilityType>> loadDisabilityType(final AppDataBase db) {
        new AsyncTask<Void, Void, List<DisabilityType>>() {
            @Override
            protected List<DisabilityType> doInBackground(Void... params) {
                return db.profileDao().getAllDisabilityType();
            }

            @Override
            protected void onPostExecute(List<DisabilityType> notes) {
                disabilityTypeLiveData.setValue(notes);
            }
        }.execute();

        return disabilityTypeLiveData;
    }

    //     get SexualityType
    public static MutableLiveData<List<SexualityType>> loadSexualityType(final AppDataBase db) {
        new AsyncTask<Void, Void, List<SexualityType>>() {
            @Override
            protected List<SexualityType> doInBackground(Void... params) {
                return db.profileDao().getAllSexualityType();
            }

            @Override
            protected void onPostExecute(List<SexualityType> notes) {
                sexualityTypeLiveData.setValue(notes);
            }
        }.execute();

        return sexualityTypeLiveData;
    }

    //     CountryCode
    public static MutableLiveData<List<CountryCode>> loadCountryCode(final AppDataBase db) {
        new AsyncTask<Void, Void, List<CountryCode>>() {
            @Override
            protected List<CountryCode> doInBackground(Void... params) {
                return db.profileDao().getAllCountryCode();
            }

            @Override
            protected void onPostExecute(List<CountryCode> notes) {
                countryCodeLiveData.setValue(notes);
            }
        }.execute();

        return countryCodeLiveData;
    }

    //     Religion
    public static MutableLiveData<List<Religion>> loadReligion(final AppDataBase db) {
        new AsyncTask<Void, Void, List<Religion>>() {
            @Override
            protected List<Religion> doInBackground(Void... params) {
                return db.profileDao().getAllReligion();
            }

            @Override
            protected void onPostExecute(List<Religion> notes) {
                religionLiveData.setValue(notes);
            }
        }.execute();

        return religionLiveData;
    }

    //     Nationality
    public static MutableLiveData<List<Nationality>> loadNationality(final AppDataBase db) {
        new AsyncTask<Void, Void, List<Nationality>>() {
            @Override
            protected List<Nationality> doInBackground(Void... params) {
                return db.profileDao().getAllNationality();
            }

            @Override
            protected void onPostExecute(List<Nationality> notes) {
                nationalityLiveData.setValue(notes);
            }
        }.execute();

        return nationalityLiveData;
    }


    //     Phone Type
    public static MutableLiveData<List<PhoneType>> loadPhoneType(final AppDataBase db) {
        new AsyncTask<Void, Void, List<PhoneType>>() {
            @Override
            protected List<PhoneType> doInBackground(Void... params) {
                return db.profileDao().getAllPhoneType();
            }

            @Override
            protected void onPostExecute(List<PhoneType> notes) {
                phoneLiveData.setValue(notes);
            }
        }.execute();

        return phoneLiveData;
    }

    //     AddressType
    public static MutableLiveData<List<AddressType>> loadAddressType(final AppDataBase db) {
        new AsyncTask<Void, Void, List<AddressType>>() {
            @Override
            protected List<AddressType> doInBackground(Void... params) {
                return db.profileDao().getAllAddressType();
            }

            @Override
            protected void onPostExecute(List<AddressType> notes) {
                addressTypeLiveData.setValue(notes);
            }
        }.execute();

        return addressTypeLiveData;
    }

    //     EmailType
    public static MutableLiveData<List<EmailType>> loadEmailType(final AppDataBase db) {
        new AsyncTask<Void, Void, List<EmailType>>() {
            @Override
            protected List<EmailType> doInBackground(Void... params) {
                return db.profileDao().getAllEmailType();
            }

            @Override
            protected void onPostExecute(List<EmailType> notes) {
                emailTypeLiveData.setValue(notes);
            }
        }.execute();

        return emailTypeLiveData;
    }

// delete nodes


}
