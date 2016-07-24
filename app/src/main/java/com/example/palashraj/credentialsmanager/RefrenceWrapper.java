package com.example.palashraj.credentialsmanager;

import android.content.Context;

import com.example.palashraj.credentialsmanager.utils.TableUtils;

/**
 * Created by Anonymous on 7/25/2016.
 */
public class RefrenceWrapper {

    public static RefrenceWrapper refrenceWrapper;
    private Context context;
    private TableUtils mTableUtils;

    public RefrenceWrapper(Context activity) {
        this.context = activity;
    }

    public static RefrenceWrapper getRefrenceWrapper(Context context) {
        if (refrenceWrapper == null) {
            refrenceWrapper = new RefrenceWrapper(context);
        }
        return refrenceWrapper;
    }

    public TableUtils getmTableUtils() {
        if (mTableUtils == null) {
            mTableUtils = new TableUtils();
        }
        return mTableUtils;
    }
}
