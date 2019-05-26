package com.example.carescheduling.data.Local;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.carescheduling.Utils.Constants;

public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreferenceEditor;

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE);
        sharedPreferenceEditor = sharedPreferences.edit();
    }

    public void cleanAllData() {
        sharedPreferenceEditor.clear().commit();
    }

    public boolean IsUserLogin() {
        return sharedPreferences.getBoolean(Constants.IS_USER_LOGIN, false);
    }

    public void setUserLogin(boolean personLogin) {
        sharedPreferenceEditor.putBoolean(Constants.IS_USER_LOGIN, personLogin).commit();
    }

    public String getPersonId() {
        return sharedPreferences.getString(Constants.PERSON_ID, null);
    }

    public void setPersonId(String personId) {
        sharedPreferenceEditor.putString(Constants.PERSON_ID, personId).commit();
    }

    public String getCustomerId() {
        return sharedPreferences.getString(Constants.CUSTOMER_ID, null);
    }

    public void setCustomerId(String customerId) {
        sharedPreferenceEditor.putString(Constants.CUSTOMER_ID, customerId).commit();
    }

    public void setBranchId(String branchId) {
        sharedPreferenceEditor.putString(Constants.BRANCH_ID, branchId).commit();
    }

    public String getBranchId() {
        return sharedPreferences.getString(Constants.BRANCH_ID, null);
    }

    public void setCurrentPassword(String currentPassword) {
        sharedPreferenceEditor.putString(Constants.CURRENT_PASSWORD, currentPassword).commit();
    }

    public String getCurrentPassword() {
        return sharedPreferences.getString(Constants.CURRENT_PASSWORD, null);
    }

    public void setClientId(String clientId) {
        sharedPreferenceEditor.putString(Constants.CLIENT_ID, clientId).commit();
    }

    public String getClientId() {
        return sharedPreferences.getString(Constants.CLIENT_ID, null);
    }
}