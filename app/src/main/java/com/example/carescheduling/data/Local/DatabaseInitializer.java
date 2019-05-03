package com.example.carescheduling.data.Local;

import android.os.AsyncTask;
import android.util.Log;


import com.example.carescheduling.data.Local.DatabaseTable.Ethnicity;
import com.example.carescheduling.data.Local.DatabaseTable.Gender;
import com.example.carescheduling.data.Local.DatabaseTable.MaritialStatus;
import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;
import com.example.carescheduling.data.Local.DatabaseTable.Prefix;

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
            db.profileDao().deleteAll();
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
            db.profileDao().deleteAll();
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
            db.profileDao().deleteAll();
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
            db.profileDao().deleteAll();
        for (Prefix user : list) {
            addUserPrefix(db, user);
        }
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserPrefix(final AppDataBase db, Prefix user) {
        db.profileDao().insertAllPrefix(user);
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
}
