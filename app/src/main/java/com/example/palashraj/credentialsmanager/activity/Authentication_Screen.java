package com.example.palashraj.credentialsmanager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.palashraj.credentialsmanager.R;

public class Authentication_Screen extends AppCompatActivity {

    private EditText loginPin;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication__screen);
        initUI();
    }

    public void initUI(){

        loginPin = (EditText) findViewById(R.id.loginpin);
        submit = (Button) findViewById(R.id.Submit);
    }
}
