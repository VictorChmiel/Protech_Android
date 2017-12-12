package com.example.sportapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ObjectifsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectifs);
    }
    public void boutonObjectfisActivity(View view){
        Intent intent = new Intent(this, FinInscriptionActivity.class);
        startActivity(intent);
    }
}
