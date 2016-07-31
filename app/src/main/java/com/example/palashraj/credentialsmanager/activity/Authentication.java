package com.example.palashraj.credentialsmanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.palashraj.credentialsmanager.BaseActivity;
import com.example.palashraj.credentialsmanager.R;
import com.example.palashraj.credentialsmanager.services.db.AppSharedPreferences;

public class Authentication extends BaseActivity implements View.OnClickListener{

    private static AppSharedPreferences mAppSharedPreferencesinstance;

    private EditText loginPin;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication__screen);
        initUI();
        setData();
        if (!mAppSharedPreferencesinstance.ismPinSet()){
            Intent intent = new Intent(this, RegisterPin.class);
            startActivity(intent);
        }
    }
    private void initUI(){
        loginPin = (EditText) findViewById(R.id.loginpin);
        submit = (Button) findViewById(R.id.Submit);
    }

    public void setData(){
        mAppSharedPreferencesinstance = AppSharedPreferences.getInstance();
        submit.setOnClickListener(this);
    }

    private void checkValidity() {
        if(mAppSharedPreferencesinstance.ismPinValid(loginPin.getText().toString())){
            Intent intent = new Intent(this, Search_Credentials.class);
            startActivity(intent);
        }else{
            loginPin.setText("");
            Toast.makeText(this,"Please enter a valid pin", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onClick(View view) {
        if(view.equals(submit)){
            checkValidity();
        }
    }
}