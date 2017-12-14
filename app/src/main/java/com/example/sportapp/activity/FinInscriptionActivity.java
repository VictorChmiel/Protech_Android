package com.example.sportapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sportapp.R;

public class FinInscriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_inscription);
    }
    public void boutonFinInscription(View view){
        Intent intent = new Intent(this, ProfilActivity.class);
        startActivity(intent);
    }
}
