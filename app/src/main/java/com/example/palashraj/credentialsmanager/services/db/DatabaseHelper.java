package com.example.palashraj.credentialsmanager.services.db;


import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.palashraj.credentialsmanager.services.AppContext;
import com.example.palashraj.credentialsmanager.services.db.tables.CredentialsTable;
import com.example.palashraj.credentialsmanager.services.db.tables.Tables;


public class DatabaseHelper extends SQLiteOpenHelper {

	private static DatabaseHelper INSTANCE;
	
	public static DatabaseHelper getInstance(Application context){
		if(INSTANCE == null){
			INSTANCE = new DatabaseHelper(context);	
		}
		return INSTANCE;
	}

	public static SQLiteDatabase getDatabase(){
		getInstance(AppContext.getInstance().getContext());
		return INSTANCE.getWritableDatabase();
	}

	
	private DatabaseHelper(Application context) {
		super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		synchronized (getClass()) {
			createTables(db);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		dropTables(db);	
		createTables(db);
	}
	
	public void resetAllTables(SQLiteDatabase db){
		dropTables(db);
		createTables(db);
	}
	
	private void createTables(SQLiteDatabase db){
		Tables.createTables(db);
	}
	
	private void dropTables(SQLiteDatabase db){
		Tables.dropTables(db);
	}
}
