package com.example.carescheduling.data.Local;

import android.os.AsyncTask;
import android.util.Log;

import com.example.carescheduling.Ui.Dashboard.beans.ClientContactList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientDisabilityList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientDocumentList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientMedicalForMobileList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientNoteList;
import com.example.carescheduling.Ui.Dashboard.beans.ClientSummary;
import com.example.carescheduling.Ui.Dashboard.beans.ClientTaskList;
import com.example.carescheduling.Ui.HomeScreen.beans.ClientBookingScreenModel;

import java.util.List;

import androidx.annotation.NonNull;

public class DatabaseInitializerHome {
    private static final String TAG = DatabaseInitializerHome.class.getName();

    //   ClientBookingScreenModel
    public static void populateAsyncClientBookingScreenModel(@NonNull final AppDataBase db, List<ClientBookingScreenModel> list) {
        PopulateDbAsyncClientBookingScreenModel task = new PopulateDbAsyncClientBookingScreenModel(db, list);
        task.execute();
    }

    private static class PopulateDbAsyncClientBookingScreenModel extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<ClientBookingScreenModel> list;

        PopulateDbAsyncClientBookingScreenModel(AppDataBase db, List<ClientBookingScreenModel> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithClientBookingScreenModelData(mDb, list);
            return null;
        }

    }

    private static void populateWithClientBookingScreenModelData(AppDataBase db, List<ClientBookingScreenModel> list) {
        int count = db.homeDeo().countClientBookingScreenModel();
        if (count > 0)
            db.homeDeo().deleteClientBookingScreenModel();
        for (ClientBookingScreenModel user : list) {
            addUserClientBookingScreenModel(db, user);
        }
        Log.d(TAG, "ClientBookingScreenModel Count: " + db.homeDeo().countClientBookingScreenModel());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserClientBookingScreenModel(final AppDataBase db, ClientBookingScreenModel user) {
        db.homeDeo().insertClientBookingScreenModel(user);
    }


    //   ClientContactList
    public static void populateAsyncClientContactList(@NonNull final AppDataBase db, List<ClientContactList> list) {
        PopulateDbAsyncClientContactList task = new PopulateDbAsyncClientContactList(db, list);
        task.execute();
    }

    private static class PopulateDbAsyncClientContactList extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<ClientContactList> list;

        PopulateDbAsyncClientContactList(AppDataBase db, List<ClientContactList> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithClientContactListData(mDb, list);
            return null;
        }

    }

    private static void populateWithClientContactListData(AppDataBase db, List<ClientContactList> list) {
        int count = db.homeDeo().countClientContactList();
        if (count > 0)
            db.homeDeo().deleteClientContactList();
        for (ClientContactList user : list) {
            addUserClientContactList(db, user);
        }
        Log.d(TAG, "ClientContactList Count: " + db.homeDeo().countClientContactList());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserClientContactList(final AppDataBase db, ClientContactList user) {
        db.homeDeo().insertClientContactList(user);
    }


    //   ClientDisabilityList
    public static void populateAsyncClientDisabilityList(@NonNull final AppDataBase db, List<ClientDisabilityList> list) {
        PopulateDbAsyncClientDisabilityList task = new PopulateDbAsyncClientDisabilityList(db, list);
        task.execute();
    }

    private static class PopulateDbAsyncClientDisabilityList extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<ClientDisabilityList> list;

        PopulateDbAsyncClientDisabilityList(AppDataBase db, List<ClientDisabilityList> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithClientDisabilityListData(mDb, list);
            return null;
        }

    }

    private static void populateWithClientDisabilityListData(AppDataBase db, List<ClientDisabilityList> list) {
        int count = db.homeDeo().countClientDisabilityList();
        if (count > 0)
            db.homeDeo().deleteClientDisabilityList();
        for (ClientDisabilityList user : list) {
            addUserClientDisabilityList(db, user);
        }
        Log.d(TAG, "ClientDisabilityList Count: " + db.homeDeo().countClientDisabilityList());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserClientDisabilityList(final AppDataBase db, ClientDisabilityList user) {
        db.homeDeo().insertClientDisabilityList(user);
    }


    //   ClientDocumentList
    public static void populateAsyncClientDocumentList(@NonNull final AppDataBase db, List<ClientDocumentList> list) {
        PopulateDbAsyncClientDocumentList task = new PopulateDbAsyncClientDocumentList(db, list);
        task.execute();
    }

    private static class PopulateDbAsyncClientDocumentList extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<ClientDocumentList> list;

        PopulateDbAsyncClientDocumentList(AppDataBase db, List<ClientDocumentList> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithClientDocumentListData(mDb, list);
            return null;
        }

    }

    private static void populateWithClientDocumentListData(AppDataBase db, List<ClientDocumentList> list) {
        int count = db.homeDeo().countClientDocumentList();
        if (count > 0)
            db.homeDeo().deleteClientDocumentList();
        for (ClientDocumentList user : list) {
            addUserClientDocumentList(db, user);
        }
        Log.d(TAG, "ClientDocumentList Count: " + db.homeDeo().countClientDocumentList());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserClientDocumentList(final AppDataBase db, ClientDocumentList user) {
        db.homeDeo().insertClientDocumentList(user);
    }


    //   ClientMedicalForMobileList
    public static void populateAsyncClientMedicalForMobileList(@NonNull final AppDataBase db, List<ClientMedicalForMobileList> list) {
        PopulateDbAsyncClientMedicalForMobileList task = new PopulateDbAsyncClientMedicalForMobileList(db, list);
        task.execute();
    }

    private static class PopulateDbAsyncClientMedicalForMobileList extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<ClientMedicalForMobileList> list;

        PopulateDbAsyncClientMedicalForMobileList(AppDataBase db, List<ClientMedicalForMobileList> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithClientMedicalForMobileListData(mDb, list);
            return null;
        }

    }

    private static void populateWithClientMedicalForMobileListData(AppDataBase db, List<ClientMedicalForMobileList> list) {
        int count = db.homeDeo().countClientMedicalForMobileList();
        if (count > 0)
            db.homeDeo().deleteClientMedicalForMobileList();
        for (ClientMedicalForMobileList user : list) {
            addUserClientMedicalForMobileList(db, user);
        }
        Log.d(TAG, "ClientMedicalForMobileList Count: " + db.homeDeo().countClientMedicalForMobileList());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserClientMedicalForMobileList(final AppDataBase db, ClientMedicalForMobileList user) {
        db.homeDeo().insertClientMedicalForMobileList(user);
    }


    //   ClientNoteList
    public static void populateAsyncClientNoteList(@NonNull final AppDataBase db, List<ClientNoteList> list) {
        PopulateDbAsyncClientNoteList task = new PopulateDbAsyncClientNoteList(db, list);
        task.execute();
    }

    private static class PopulateDbAsyncClientNoteList extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<ClientNoteList> list;

        PopulateDbAsyncClientNoteList(AppDataBase db, List<ClientNoteList> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithClientNoteListData(mDb, list);
            return null;
        }

    }

    private static void populateWithClientNoteListData(AppDataBase db, List<ClientNoteList> list) {
        int count = db.homeDeo().countClientNoteList();
        if (count > 0)
            db.homeDeo().deleteClientNoteList();
        for (ClientNoteList user : list) {
            addUserClientNoteList(db, user);
        }
        Log.d(TAG, "ClientNoteList Count: " + db.homeDeo().countClientNoteList());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserClientNoteList(final AppDataBase db, ClientNoteList user) {
        db.homeDeo().insertClientNoteList(user);
    }

    //   ClientSummary
    public static void populateAsyncClientSummary(@NonNull final AppDataBase db, List<ClientSummary> list) {
        PopulateDbAsyncClientSummary task = new PopulateDbAsyncClientSummary(db, list);
        task.execute();
    }

    private static class PopulateDbAsyncClientSummary extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<ClientSummary> list;

        PopulateDbAsyncClientSummary(AppDataBase db, List<ClientSummary> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithClientSummaryData(mDb, list);
            return null;
        }

    }

    private static void populateWithClientSummaryData(AppDataBase db, List<ClientSummary> list) {
        int count = db.homeDeo().countClientSummary();
        if (count > 0)
            db.homeDeo().deleteClientSummary();
        for (ClientSummary user : list) {
            addUserClientSummary(db, user);
        }
        Log.d(TAG, "ClientSummary Count: " + db.homeDeo().countClientSummary());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserClientSummary(final AppDataBase db, ClientSummary user) {
        db.homeDeo().insertClientSummary(user);
    }


    //   ClientTaskList
    public static void populateAsyncClientTaskList(@NonNull final AppDataBase db, List<ClientTaskList> list) {
        PopulateDbAsyncClientTaskList task = new PopulateDbAsyncClientTaskList(db, list);
        task.execute();
    }

    private static class PopulateDbAsyncClientTaskList extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;
        private List<ClientTaskList> list;

        PopulateDbAsyncClientTaskList(AppDataBase db, List<ClientTaskList> list) {
            mDb = db;
            this.list = list;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithClientTaskListData(mDb, list);
            return null;
        }

    }

    private static void populateWithClientTaskListData(AppDataBase db, List<ClientTaskList> list) {
        int count = db.homeDeo().countClientTaskList();
        if (count > 0)
            db.homeDeo().deleteClientTaskList();
        for (ClientTaskList user : list) {
            addUserClientTaskList(db, user);
        }
        Log.d(TAG, "ClientTaskList Count: " + db.homeDeo().countClientTaskList());
//        Toast.makeText(this, "Rows Count: " + userList.size(), Toast.LENGTH_SHORT).show();
    }

    private static void addUserClientTaskList(final AppDataBase db, ClientTaskList user) {
        db.homeDeo().insertClientTaskList(user);
    }
}