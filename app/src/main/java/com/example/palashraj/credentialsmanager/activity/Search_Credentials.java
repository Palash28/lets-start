package com.example.palashraj.credentialsmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.palashraj.credentialsmanager.BaseActivity;
import com.example.palashraj.credentialsmanager.R;

public class Search_Credentials extends BaseActivity {

    private EditText searchcredentials;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__credentials);
        initUI();
    }

    public void initUI(){

        searchcredentials = (EditText) findViewById(R.id.et_searchcredentials);
        search = (Button) findViewById(R.id.b_search);
    }
}
