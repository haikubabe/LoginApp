package com.example.sreemoyeec662.loginapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView mUsername;
    private TextView mEmailId;
    private TextView mAboutYourself;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mUsername = findViewById(R.id.tv_username);
        mEmailId = findViewById(R.id.tv_email);
        mAboutYourself = findViewById(R.id.tv_about_yourself);

        SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(getString(R.string.username_pref_key),getString(R.string.tv_default_username));
        String emailId = sharedPreferences.getString(getString(R.string.emailId_pref_key),getString(R.string.tv_default_email));
        String aboutYourself = sharedPreferences.getString(getString(R.string.about_yourself_pref_key),getString(R.string.tv_default_about_yourself));

        mUsername.setText(username);
        mEmailId.setText(emailId);
        mAboutYourself.setText(aboutYourself);
    }
}
