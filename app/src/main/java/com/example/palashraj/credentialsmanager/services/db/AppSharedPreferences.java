package com.example.palashraj.credentialsmanager.services.db;

import android.app.Application;
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

    public AppSharedPreferences(Application context) {
        this.mPrefs = context.getSharedPreferences(TAG, Application.MODE_PRIVATE);
        this.mPrefsEditor = mPrefs.edit();
    }

    public static AppSharedPreferences getInstance() {

        if (instance == null) {
            instance = new AppSharedPreferences(AppContext.getInstance().getContext());

        }
        return instance;
    }

    public boolean ismPinValid(String mPin) {
        return (mPrefs.getString(this.mPin, "").equals(mPin));
    }

    public void setmPin(String pin) {
        mPrefsEditor.putString(mPin, pin);
        mPrefsEditor.commit();
    }

    public void clearmPin() {

        mPrefsEditor.clear();
        mPrefsEditor.commit();
    }

    public boolean ismPinSet(){ return mPrefs.contains(mPin);}
}

