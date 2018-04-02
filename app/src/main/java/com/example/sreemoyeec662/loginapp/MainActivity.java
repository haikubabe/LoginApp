package com.example.sreemoyeec662.loginapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mEmailId;
    private EditText mAboutYourself;
    private Button mSignIn;

    private static final String USERNAME = "username";
    private static final String EMAIL_ID = "emailId";
    private static final String ABOUT_YOURSELF = "aboutYourself";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mUsername = findViewById(R.id.et_username);
        mEmailId = findViewById(R.id.et_email);
        mAboutYourself = findViewById(R.id.et_about_yourself);
        mSignIn = findViewById(R.id.sign_in);
        if (savedInstanceState != null) {
            mUsername.setText(savedInstanceState.getString(USERNAME));
            mEmailId.setText(savedInstanceState.getString(EMAIL_ID));
            mAboutYourself.setText(savedInstanceState.getString(ABOUT_YOURSELF));
        }
        final SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUsername.length() == 0)
                    mUsername.setError("Please enter username");
                else if (mEmailId.length() == 0)
                    mEmailId.setError("Please enter emailid");
                else if (mAboutYourself.length() == 0)
                    mAboutYourself.setError("Please write about yourself");
                else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(getString(R.string.username_pref_key), mUsername.getText().toString());
                    editor.putString(getString(R.string.emailId_pref_key), mEmailId.getText().toString());
                    editor.putString(getString(R.string.about_yourself_pref_key), mAboutYourself.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    startActivity(intent);
                    mUsername.setText("");
                    mEmailId.setText("");
                    mAboutYourself.setText("");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_contact:
                Intent intent = new Intent(this, DetailActivity.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(USERNAME, mUsername.getText().toString());
        outState.putString(EMAIL_ID, mEmailId.getText().toString());
        outState.putString(ABOUT_YOURSELF, mAboutYourself.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
