package com.example.carescheduling.data.Local;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


import com.example.carescheduling.data.Local.DatabaseTable.PersonLanguage;

import java.util.List;

import androidx.annotation.NonNull;

public class DatabaseInitializer {


    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDataBase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDataBase db) {
        populateWithTestData(db);
    }

    private static PersonLanguage addUser(final AppDataBase db, PersonLanguage user) {
        db.profileDao().insertAllLanguage(user);
        return user;
    }

    private static void populateWithTestData(AppDataBase db) {
        List<PersonLanguage> userList = db.profileDao().getAllLanguages();
        if (userList.size() > 0)
            db.profileDao().deleteAll();
        PersonLanguage user = new PersonLanguage();
        user.setLanguageName("English");
        addUser(db, user);


        Log.d(DatabaseInitializer.TAG, "Rows Count: " + userList.size());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;

        PopulateDbAsync(AppDataBase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
