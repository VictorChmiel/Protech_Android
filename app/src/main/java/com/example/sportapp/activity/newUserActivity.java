package com.example.sportapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sportapp.util.AuthenticatedUser;
import com.example.sportapp.DTO.CaracteristiqueCommandDTO;
import com.example.sportapp.DTO.UserCommandCaracteristiqueDTO;
import com.example.sportapp.R;
import com.example.sportapp.util.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

public class newUserActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.sportapp.MESSAGE";
    ScrollView scrollView;
    ProgressBar progressBar;
    EditText login;
    EditText mdp;
    EditText poids;
    EditText taille;
    EditText date_naissance;
    Spinner sexe;
    TextView error_text;
    Activity currentActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        scrollView = findViewById(R.id.scrollView);
        progressBar = findViewById(R.id.progressBar);
        login = findViewById(R.id.login);
        mdp = findViewById(R.id.mdp);
        taille = findViewById(R.id.taille);
        poids = findViewById(R.id.poids);
        date_naissance = findViewById(R.id.date_naissance);
        sexe = findViewById(R.id.sexe);
        error_text =findViewById(R.id.error);
    }

    public void boutonInfo1Activity(View view) throws JSONException {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = Util.CONTEXT_SERVER_URL+"api/users";

        scrollView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        //get room sensed context
        CaracteristiqueCommandDTO caracteristique =
                new CaracteristiqueCommandDTO(
                        Integer.parseInt(taille.getText().toString()),
                        Integer.parseInt(taille.getText().toString())
                );
        UserCommandCaracteristiqueDTO user =
                new UserCommandCaracteristiqueDTO(
                        login.getText().toString(),
                        false,
                        sexe(sexe.getSelectedItem().toString()),
                        mdp.getText().toString(),
                        date_naissance.getText().toString(),
                        caracteristique
                );
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(user);

        JSONObject jsonBody=new JSONObject(json);

        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonBody, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            AuthenticatedUser.setId(new Long((int)response.get("id")));
                            AuthenticatedUser.setAdmin((boolean)response.get("admin"));
                            AuthenticatedUser.setLogin(response.get("login").toString());
                            AuthenticatedUser.setToken(response.get("token").toString());
                            AuthenticatedUser.setAuthentified(true);

                            Intent intent = new Intent(currentActivity, MaterielsActivity.class);
                            scrollView.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.INVISIBLE);
                            startActivity(intent);
                        } catch (Exception e) {
                            progressBar.setVisibility(View.INVISIBLE);
                            error_text.setVisibility(View.VISIBLE);
                            error_text.setText(e.toString());
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.INVISIBLE);
                        error_text.setVisibility(View.VISIBLE);
                        error_text.setText(error.toString());
                    }
                });
        queue.add(contextRequest);


    }
    private String sexe (String sexe){
        if (sexe.equalsIgnoreCase("Homme")){
            return "HOMME";
        }else if (sexe.equalsIgnoreCase("Femme")){
            return "FEMME";
        }else {
            return "AUTRE";
        }
    }
}

