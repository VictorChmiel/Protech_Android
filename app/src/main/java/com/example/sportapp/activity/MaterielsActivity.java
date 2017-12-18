package com.example.sportapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sportapp.R;

public class MaterielsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiels);
    }
    public void boutonInfo2Activity(View view){
        Intent intent = new Intent(this, ObjectifsActivity.class);
        startActivity(intent);

    }
}
