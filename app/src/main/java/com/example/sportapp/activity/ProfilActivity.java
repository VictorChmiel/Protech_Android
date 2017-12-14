package com.example.sportapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sportapp.R;
import com.example.sportapp.util.AuthenticatedUser;

public class ProfilActivity extends AppCompatActivity {
    TextView bonjour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        bonjour = findViewById(R.id.bonjour_text);
        if (AuthenticatedUser.isAuthentified()){
            bonjour.setText("Bonjour "+AuthenticatedUser.getLogin());
        }
    }

}
