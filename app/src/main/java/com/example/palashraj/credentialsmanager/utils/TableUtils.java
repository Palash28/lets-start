package com.example.palashraj.credentialsmanager.utils;

import com.example.palashraj.credentialsmanager.services.db.DatabaseHelper;
import com.example.palashraj.credentialsmanager.services.db.dao.CredentialsDAO;
import com.example.palashraj.credentialsmanager.services.ds.CredentialsBean;

/**
 * Created by Palash Raj on 7/22/2016.
 */
public class TableUtils {

    private CredentialsDAO mCredentialsDAO;


    public TableUtils() {
        mCredentialsDAO = new CredentialsDAO(DatabaseHelper.getDatabase());
    }

    public void deleteCredentials(String id){
        mCredentialsDAO.delete(id);
    }

    public void deleteAll(){
        mCredentialsDAO.delete();
    }

    public void fetchCredential(String id){
        mCredentialsDAO.getCursor(id);
    }
}
