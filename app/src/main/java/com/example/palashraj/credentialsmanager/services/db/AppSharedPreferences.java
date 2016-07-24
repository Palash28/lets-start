package com.example.palashraj.credentialsmanager.services.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.palashraj.credentialsmanager.services.AppContext;

import java.util.Set;

public class AppSharedPreferences {

    private static AppSharedPreferences instance;

    private String TAG = this.getClass().getSimpleName();
    private SharedPreferences mPrefs;
    private Editor mPrefsEditor;

    private String mPin = "pin";

    public AppSharedPreferences(Context context) {
        this.mPrefs = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        this.mPrefsEditor = mPrefs.edit();
    }

    public static AppSharedPreferences getInstance() {

        if (instance == null) {
            instance = new AppSharedPreferences(AppContext.getInstance().getContext());

        }
        return instance;
    }

    public String getPin() {
        return mPrefs.getString(mPin, "");
    }

    public void setmPin(String pin) {
        mPrefsEditor.putString(mPin, pin);
        mPrefsEditor.commit();
    }

    public void clearPin() {

        mPrefsEditor.clear();
        mPrefsEditor.commit();
    }

}

