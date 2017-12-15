package com.example.sportapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sportapp.DTO.CredentialsDTO;
import com.example.sportapp.R;
import com.example.sportapp.util.AuthenticatedUser;
import com.example.sportapp.util.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    EditText login;
    EditText mdp;
    ConstraintLayout log_layout;
    TextView error_text;
    Activity currentActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        login = findViewById(R.id.login);
        mdp = findViewById(R.id.mdp);
        log_layout = findViewById(R.id.log_layout);
        error_text =findViewById(R.id.error);
    }
    public void boutonInscription(View view) {
        Intent intent = new Intent(this, newUserActivity.class);
        startActivity(intent);
    }
//    Intent intent = new Intent(this, ProfilActivity.class);
//    startActivity(intent);

    public void boutonConnexion(View view) throws JSONException {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = Util.CONTEXT_SERVER_URL+"api/authentication";

        log_layout.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        //get room sensed context
        CredentialsDTO credentials = new CredentialsDTO(login.getText().toString(),mdp.getText().toString());
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(credentials);

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

                            Intent intent = new Intent(currentActivity, ProfilActivity.class);
                            log_layout.setVisibility(View.VISIBLE);
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
}