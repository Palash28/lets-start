package com.example.palashraj.credentialsmanager;

import android.app.Application;

import com.example.palashraj.credentialsmanager.services.AppContext;
import com.example.palashraj.credentialsmanager.services.db.DatabaseHelper;

/**
 * Created by Anonymous on 7/31/2016.
 */
public class CredentialManagerApp extends Application {

    private static DatabaseHelper mDatabaseHelper;

    @Override
    public void onCreate() {
            super.onCreate();
        AppContext context = AppContext.getInstance();
        context.setContext(this);
        mDatabaseHelper = DatabaseHelper.getInstance(CredentialManagerApp.this);
    }
}
