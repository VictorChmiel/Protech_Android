package com.example.sportapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Info1Activity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.sportapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1);
    }
    public void boutonInfo1Activity(View view){
        Intent intent = new Intent(this, Info2Activity.class);
        startActivity(intent);

        //Intent intent1 = new Intent(this, ProfilActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText2);
        //String message = editText.getText().toString();
        //intent1.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent1);
    }
    //méthodes à ajouter pour récupérer les informations
    //personnelles
}

