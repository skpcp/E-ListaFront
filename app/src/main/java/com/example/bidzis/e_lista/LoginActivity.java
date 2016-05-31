package com.example.bidzis.e_lista;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.NetworkOnMainThreadException;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bidzis.e_lista.User.UserAreaActivity;
import com.example.bidzis.e_lista.User.UserSiteActivity;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.apache.http.*;


//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.CookieStore;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.protocol.HttpClientContext;
//import org.apache.http.cookie.Cookie;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etLogin = (EditText) findViewById(R.id.etLogin);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final TextView tvRegisterHere = (TextView) findViewById(R.id.tvRegisterHere);
        final Button btSignIn = (Button) findViewById(R.id.btSignin);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        final String[] id = {""};
        String example = "\"email\": \"email\",\"haslo\": \"haslo\"";
        JSONObject userLogin = new JSONObject();
        assert etLogin != null;

        try {
            userLogin = new JSONObject(example);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        assert btSignIn != null;
        final JSONObject finalUserLogin = userLogin;
        btSignIn.setOnClickListener(new View.OnClickListener() {
            public ProgressDialog pd;

            @Override
            public void onClick(View v) {
                final ProgressDialog dialog = ProgressDialog.show(LoginActivity.this, "Loading", "Please wait...", true);
                try {
                        finalUserLogin.put("email", etLogin.getText().toString());
                        assert etPassword != null;
                        finalUserLogin.put("haslo", etPassword.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                }
                String url  = getString(R.string.ip) + "/elista/uzytkownicy/zaloguj";
                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.POST, url, finalUserLogin, new Response.Listener<JSONObject>() {


                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    id[0] = response.getString("id");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Intent intent  = new Intent(LoginActivity.this, UserSiteActivity.class);
                                intent.putExtra("id",id[0]);
                                intent.putExtra("email",etLogin.getText().toString());
                                LoginActivity.this.startActivity(intent);
                                dialog.dismiss();

                            }
                        },
                                new Response.ErrorListener() {

                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        dialog.dismiss();
                                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                            Toast.makeText(getApplicationContext(), "Timeout",
                                                    Toast.LENGTH_LONG).show();
                                        } else if (error instanceof AuthFailureError) {
                                            Toast.makeText(getApplicationContext(), "1",
                                                    Toast.LENGTH_LONG).show();
                                        } else if (error instanceof ServerError) {
                                            Toast.makeText(getApplicationContext(), "Bląd serwera",
                                                    Toast.LENGTH_LONG).show();
                                        } else if (error instanceof NetworkError) {
                                            Toast.makeText(getApplicationContext(), "Problem z połączeniem internetowym",
                                                    Toast.LENGTH_LONG).show();

                                        } else if (error instanceof ParseError) {
                                            Toast.makeText(getApplicationContext(), "Nie znaleziono użytkownika w bazie",
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });


                requestQueue.add(request);





            }
//
//
//                requestQueue.add(request);

        });
        assert tvRegisterHere != null;
        tvRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });

    }

}

