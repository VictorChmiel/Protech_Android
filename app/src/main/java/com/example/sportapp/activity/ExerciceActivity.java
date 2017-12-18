package com.example.sportapp.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sportapp.R;
import com.example.sportapp.util.SeanceUser;

public class ExerciceActivity extends AppCompatActivity {
    TextView titre_exercice;
    ImageView image_exercice;
    TextView poids_text;
    TextView poids;
    TextView nb_repet;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);
        if (SeanceUser.getCurrentActivity()==SeanceUser.getActivites().size()){
            intent = new Intent(this, FinActivity.class);
            startActivity(intent);
        }
        poids=findViewById(R.id.poids);
        poids_text=findViewById(R.id.poids_text);
        nb_repet=findViewById(R.id.nb_repet);
        image_exercice=findViewById(R.id.image_exercice);
        titre_exercice=findViewById(R.id.titre_exercice);
        if(SeanceUser.getActivites().get(SeanceUser.getCurrentActivity()).getExercice().getId()==0){
            intent = new Intent(this, ReposActivity.class);
            startActivity(intent);
        }
        if (SeanceUser.getActivites().get(SeanceUser.getCurrentActivity()).getExercice().isPoids()){
            poids.setText(SeanceUser.getActivites().get(SeanceUser.getCurrentActivity()).getPoids());
            poids.setVisibility(View.VISIBLE);
            poids_text.setVisibility(View.VISIBLE);
        }
        if (!SeanceUser.getActivites().get(SeanceUser.getCurrentActivity()).getExercice().isRepetition()){
            intent = new Intent(this, TempoActivity.class);
            startActivity(intent);
        }
        titre_exercice.setText(SeanceUser.getActivites().get(SeanceUser.getCurrentActivity()).getExercice().getNom());

        String message = SeanceUser.getActivites().get(SeanceUser.getCurrentActivity()).getExercice().getDescription().get(0).getImage();
        message=message.replace(".png","");
        Resources res = getResources();
        int id = getResources().getIdentifier(message, "drawable", getPackageName());
        if(id != 0){
            Drawable drawable = res.getDrawable(id);
            image_exercice.setImageDrawable(drawable);
        }else{
            image_exercice.setImageResource(R.drawable.play_button);
        }
        nb_repet.setText(String.valueOf(SeanceUser.getActivites().get(SeanceUser.getCurrentActivity()).getRepetition()));
    }

    public void continuer (View view){
        SeanceUser.setCurrentActivity(SeanceUser.getCurrentActivity()+1);
        intent = new Intent(this, ReposActivity.class);
        startActivity(intent);
    }
}
