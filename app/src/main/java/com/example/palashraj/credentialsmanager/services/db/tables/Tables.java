package com.example.palashraj.credentialsmanager.services.db.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Anonymous on 7/25/2016.
 */
public class Tables {

    public static void createTables(SQLiteDatabase db){
        CredentialsTable.createTable(db);
    }

    public static void dropTables(SQLiteDatabase db){
        CredentialsTable.dropTable(db);
    }
}
