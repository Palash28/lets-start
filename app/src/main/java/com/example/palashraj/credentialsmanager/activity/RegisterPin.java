package com.example.palashraj.credentialsmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.palashraj.credentialsmanager.BaseActivity;
import com.example.palashraj.credentialsmanager.R;
import com.example.palashraj.credentialsmanager.services.db.AppSharedPreferences;

public class RegisterPin extends BaseActivity implements View.OnClickListener {

    private static AppSharedPreferences mAppSharedPreference;
    private EditText mpin;
    private Button reset;
    private Button set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sauthentication__screen);
        initUI();
        setData();
    }

    private void setPin() {
        mAppSharedPreference.setmPin(mpin.getText().toString());
        Toast.makeText(this,"Pin saved Successfully", Toast.LENGTH_SHORT).show();
    }
    public void initUI() {
        mpin = (EditText) findViewById(R.id.et_mpin);
        reset = (Button) findViewById(R.id.b_reset);
        set = (Button) findViewById(R.id.b_set);
    }

    public void setData() {
        mAppSharedPreference = AppSharedPreferences.getInstance();
        reset.setOnClickListener(this);
        set.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(reset)) {
            mpin.setText("");
        } else if (view.equals(set)) {
            setPin();
            Intent intent = new Intent(this, Authentication.class);
            startActivity(intent);
            finish();
        }
    }
}
