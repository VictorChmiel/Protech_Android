package com.example.sportapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sportapp.DTO.CredentialsDTO;
import com.example.sportapp.DTO.SeanceDTO;
import com.example.sportapp.R;
import com.example.sportapp.util.AuthenticatedUser;
import com.example.sportapp.util.SeanceUser;
import com.example.sportapp.util.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.List;

public class ProfilActivity extends AppCompatActivity {
    TextView bonjour;
    ProgressBar progressBar;
    TextView error_text;
    ConstraintLayout profil_layout;
    Activity currentActivity=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        bonjour = findViewById(R.id.bonjour_text);
        if (AuthenticatedUser.isAuthentified()){
            bonjour.setText("Bonjour "+AuthenticatedUser.getLogin());
        }
        progressBar = findViewById(R.id.progressBar);
        error_text =findViewById(R.id.error);
        profil_layout=findViewById(R.id.profil_layout);
    }

    public void goToSettings (View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void startSeance (View view){
        profil_layout.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = Util.CONTEXT_SERVER_URL+"api/seances/"+AuthenticatedUser.getId()+"/test";


       final Gson gson = new GsonBuilder().create();

        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            SeanceDTO seanceDTO = gson.fromJson(response.toString(), SeanceDTO.class);
                            SeanceUser.setSeanceUser(seanceDTO);
                            Intent intent = new Intent(currentActivity, ExerciceActivity.class);
                            profil_layout.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);
                            startActivity(intent);
                        } catch (Exception e) {
                            progressBar.setVisibility(View.INVISIBLE);
                            error_text.setVisibility(View.VISIBLE);
                            error_text.setText(e.toString()+e.getMessage()+e.getCause());
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.INVISIBLE);
                        error_text.setVisibility(View.VISIBLE);
                        error_text.setText(error.toString()+error.getMessage()+error.getCause());
                    }
                });
        queue.add(contextRequest);
    }
}
