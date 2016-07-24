package com.example.palashraj.credentialsmanager.services.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.SyncStateContract;

import com.example.palashraj.credentialsmanager.services.db.tables.CredentialsTable;
import com.example.palashraj.credentialsmanager.services.ds.CredentialsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Palash Raj on 7/22/2016.
 */
public class CredentialsDAO extends AbsDAO<CredentialsBean> {

    public CredentialsDAO(SQLiteDatabase database) {
        super(database);
    }

    @Override
    public void delete(String id) {
        String whereClause = CredentialsTable.CredentialColumns.id + " = " + id;
        db.delete(CredentialsTable.NAME, whereClause, null);
    }

    @Override
    public void delete() {
        db.delete(CredentialsTable.NAME, null, null);
    }

    @Override
    public Cursor getCursor() {
        Cursor cursor = db.query(CredentialsTable.NAME, null, null, null, null, null, CredentialsTable.CredentialColumns._ID + " desc");
        cursor.moveToFirst();
        return cursor;
    }

    @Override
    public Cursor getCursor(String id) {
        String whereClause = CredentialsTable.CredentialColumns.id + " = " + id;
        Cursor cursor = db.query(CredentialsTable.NAME, null, whereClause, null, null, null, null);
        cursor.moveToFirst();
        return cursor;
    }

    @Override
    public Cursor getCursor(String id, String id2) {
        return null;
    }

    @Override
    public int getSize() {
        return getCursor().getCount();
    }

    @Override
    public List<CredentialsBean> getList() {
        Cursor cursor = getCursor();
        return createList(cursor);
    }

    @Override
    public List<CredentialsBean> createList(Cursor cursor) {
        List<CredentialsBean> list = new ArrayList<CredentialsBean>();
        for (int i = 0; i < cursor.getCount(); i++) {
            list.add(createObject(cursor));
            cursor.moveToNext();
        }
        return list;
    }

    @Override
    public CredentialsBean createObject(Cursor cursor) {
        CredentialsBean data = new CredentialsBean();
        if (cursor != null && cursor.getCount() > 0) {
            data.setId(cursor.getString(cursor.getColumnIndex(CredentialsTable.CredentialColumns.id)));
            data.setSiteName(cursor.getString(cursor.getColumnIndex(CredentialsTable.CredentialColumns.siteName)));
            data.setUserID(cursor.getString(cursor.getColumnIndex(CredentialsTable.CredentialColumns.userID)));
            data.setPassword(cursor.getString(cursor.getColumnIndex(CredentialsTable.CredentialColumns.password)));
        }
        return data;
    }


    @Override
    public long insert(CredentialsBean data, int serviceTag) {
        try {

            ContentValues cv = new ContentValues();
            cv.put(CredentialsTable.CredentialColumns.id, data.getId());
            cv.put(CredentialsTable.CredentialColumns.siteName, data.getSiteName());
            cv.put(CredentialsTable.CredentialColumns.userID, data.getUserID());
            cv.put(CredentialsTable.CredentialColumns.password, data.getPassword());

            long result = db.insert(CredentialsTable.NAME, null, cv);
            return result;
        } catch (Exception er) {
            return -1;
        }
    }

    @Override
    public void insertOrUpdate(CredentialsBean data, int serviceTag) {
        if (getCursor(data.getId()).getCount() > 0) {

            ContentValues cv = new ContentValues();
            cv.put(CredentialsTable.CredentialColumns.id, data.getId());
            cv.put(CredentialsTable.CredentialColumns.siteName, data.getSiteName());
            cv.put(CredentialsTable.CredentialColumns.userID, data.getUserID());
            cv.put(CredentialsTable.CredentialColumns.password, data.getPassword());
            String whereClause = CredentialsTable.CredentialColumns.id + " = " + data.getUserID();
            long result = db.update(CredentialsTable.NAME, cv, whereClause, null);
        } else {
            insert(data, serviceTag);
        }
    }
}
