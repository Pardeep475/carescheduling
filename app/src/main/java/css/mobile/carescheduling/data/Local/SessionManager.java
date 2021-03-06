package css.mobile.carescheduling.data.Local;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import css.mobile.carescheduling.Utils.Constants;

public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreferenceEditor;

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE);
        sharedPreferenceEditor = sharedPreferences.edit();
    }

    public void cleanAllData() {
        String userName = getUserName();
        String password = getPassword();
        Log.e("SAVE_USER_DATA", "Starting  " + userName + "    " + password);
        sharedPreferenceEditor.clear().commit();
        setUserName(userName);
        setPassword(password);

        Log.e("SAVE_USER_DATA", "after  " + getUserName() + "    " + getPassword());
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

    public void setClientTasks(String clientTasks) {
        sharedPreferenceEditor.putString(Constants.CLIENT_TASK, clientTasks).commit();
    }

    public String getClientTasks() {
        return sharedPreferences.getString(Constants.CLIENT_TASK, null);
    }

    public void setBookingId(String bookingId) {
        sharedPreferenceEditor.putString(Constants.BOOKING_ID, bookingId).commit();
    }

    public String getBookingId() {
        return sharedPreferences.getString(Constants.BOOKING_ID, null);
    }

    public void setClientVisitId(String barcodeId) {
        sharedPreferenceEditor.putString(Constants.CLIENT_VISIT_ID, barcodeId).commit();
    }

    public String getClientVisitId() {
        return sharedPreferences.getString(Constants.CLIENT_VISIT_ID, null);
    }

    public void setOffline(boolean barcodeId) {
        sharedPreferenceEditor.putBoolean(Constants.IS_OFFLINE, barcodeId).commit();
    }

    public boolean getOffline() {
        return sharedPreferences.getBoolean(Constants.IS_OFFLINE, false);
    }


    public void setUserName(String userName) {
        sharedPreferenceEditor.putString(Constants.USER_NAME, userName).commit();
    }

    public String getUserName() {
        return sharedPreferences.getString(Constants.USER_NAME, null);
    }

    public void setPassword(String password) {
        sharedPreferenceEditor.putString(Constants.PASSWORD, password).commit();
    }

    public String getPassword() {
        return sharedPreferences.getString(Constants.PASSWORD, null);
    }

}