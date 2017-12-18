package com.example.sportapp.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sportapp.R;
import com.example.sportapp.util.SeanceUser;

import java.util.concurrent.TimeUnit;

public class ReposActivity extends AppCompatActivity {
    Activity currentActivity =this;
    TextView timer;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);
        if (SeanceUser.getCurrentActivity()==SeanceUser.getActivites().size()){
            Intent intent = new Intent(this, FinActivity.class);
            startActivity(intent);
        }
        if(SeanceUser.getActivites().get(SeanceUser.getCurrentActivity()).getExercice().getId()!=0){
            Intent intent = new Intent(this, ExerciceActivity.class);
            startActivity(intent);
        }
        int millis = SeanceUser.getActivites().get(SeanceUser.getCurrentActivity()).getTemporisation()*1000;
        timer=findViewById(R.id.timer);
        timer.setText(String.format("%02d : %02d",
                TimeUnit.MILLISECONDS.toMinutes(millis),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        ));
        CountDownTimer countDownTimer = new CountDownTimer(millis, 1000) {
            @SuppressLint("DefaultLocale")
            public void onTick(long millisUntilFinished) {
                timer.setText(String.format("%02d : %02d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))
                ));
            }

            public void onFinish() {
                SeanceUser.setCurrentActivity(SeanceUser.getCurrentActivity()+1);
                Intent intent = new Intent(currentActivity, ExerciceActivity.class);
                startActivity(intent);
            }
        };
        countDownTimer.start();
    }



    public void continuer (View view){
        SeanceUser.setCurrentActivity(SeanceUser.getCurrentActivity()+1);
        Intent intent = new Intent(this, ExerciceActivity.class);
        startActivity(intent);
    }
}
