package com.example.sportapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sportapp.R;
import com.example.sportapp.util.AuthenticatedUser;

public class SettingsActivity extends AppCompatActivity {
    TextView login_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        login_text = findViewById(R.id.login_text);
        login_text.setText("Login : "+ AuthenticatedUser.getLogin());
    }
}
