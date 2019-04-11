package com.example.carescheduling.data.Local;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.carescheduling.Utils.Constants;

public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreferenceEditor;

    public SessionManager(Context context){
        sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE,Context.MODE_PRIVATE);
        sharedPreferenceEditor = sharedPreferences.edit();
    }

}
