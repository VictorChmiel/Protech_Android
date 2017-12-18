package com.example.sportapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sportapp.R;
import com.example.sportapp.util.SeanceUser;

public class TempoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempo);
        if (SeanceUser.getActivites().get(SeanceUser.getCurrentActivity()).getExercice().isRepetition()){
            Intent intent = new Intent(this, ExerciceActivity.class);
            startActivity(intent);
        }
    }
}
