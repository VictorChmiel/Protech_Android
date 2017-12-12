package com.example.sportapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Info2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);
    }
    public void boutonInfo2Activity(View view){
        Intent intent = new Intent(this, ObjectifsActivity.class);
        startActivity(intent);
    }
}
