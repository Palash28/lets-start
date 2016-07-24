package com.example.palashraj.credentialsmanager.services.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public abstract class AbsDAO<T extends Object> {

    protected final String TAG = AbsDAO.class.getSimpleName();
    protected SQLiteDatabase db;

    public AbsDAO(SQLiteDatabase database) {
        super();
        if (database != null) {
            this.db = database;
            if (!db.isOpen()) {
                throw new RuntimeException("SQLiteDatabase is not open. Need to open before any operation.");
            }
        } else {
            throw new RuntimeException("SQLiteDatabase is null. Need to initialize DatabaseHelper constructor before any operation.");
        }
    }

    public abstract List<T> createList(Cursor cursor);

    public abstract T createObject(Cursor cursor);

    public abstract void delete();

    public abstract void delete(String id);

    public abstract Cursor getCursor(String id);

    public abstract Cursor getCursor(String id, String id2);

    public abstract Cursor getCursor();

    public abstract List<T> getList();

    public abstract int getSize();

    public void insert(List<T> list, int serviceTag) {
        for (int i = 0; i < list.size(); i++) {
            insert(list.get(i),serviceTag);
        }
    }

    public abstract long insert(T data,int serviceTag);

    public void insertOrUpdate(List<T> list, int serviceTag) {
        for (int i = 0; i < list.size(); i++) {
            insertOrUpdate(list.get(i),serviceTag);
        }
    }

    public abstract void insertOrUpdate(T data,int serviceTag);

}
