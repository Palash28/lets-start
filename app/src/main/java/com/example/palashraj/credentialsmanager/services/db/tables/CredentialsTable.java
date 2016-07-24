package com.example.palashraj.credentialsmanager.services.db.tables;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Palash Raj on 7/22/2016.
 */
public class CredentialsTable {

    public static final String NAME = "CredentialsTable";

    public static void createTable(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + CredentialsTable.NAME + '('
                + CredentialColumns._ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                + CredentialColumns.id + " TEXT NOT NULL UNIQUE, "
                + CredentialColumns.siteName + " TEXT, "
                + CredentialColumns.userID + " TEXT, "
                + CredentialColumns.password + " TEXT );");
    }

    public static void dropTable(SQLiteDatabase db) {

        db.execSQL("DROP TABLE IF EXISTS " + CredentialsTable.NAME);
    }

    public interface CredentialColumns extends BaseColumns {

        String id = "id";
        String siteName = "Site Name";
        String userID = "User ID";
        String password = "Password";
    }
}
