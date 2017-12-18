package com.example.sportapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sportapp.R;
import com.example.sportapp.util.SeanceUser;

public class FinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
    }

    public void continuer(View view) {
        SeanceUser.setCurrentActivity(SeanceUser.getCurrentActivity() + 1);
        Intent intent = new Intent(this, ProfilActivity.class);
        startActivity(intent);
    }
}
