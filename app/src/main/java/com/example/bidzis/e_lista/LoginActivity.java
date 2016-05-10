package com.example.bidzis.e_lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.android.volley.toolbox.Volley;
import com.example.bidzis.e_lista.User.UserAreaActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etLogin = (EditText) findViewById(R.id.etLogin);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final TextView tvRegisterHere = (TextView) findViewById(R.id.tvRegisterHere);
        final Button btSignIn  = (Button) findViewById(R.id.btSignin);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String example = "\"Username\": \"email\",\"Password\": \"haslo\"";
        JSONObject userLogin = new JSONObject();

        try {
            userLogin = new JSONObject(example);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        assert btSignIn != null;
        final JSONObject finalUserLogin = userLogin;
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert etLogin != null;
                String login = etLogin.getText().toString();
                assert etPassword != null;
                String password = etPassword.getText().toString();
                String url = getString(R.string.ip)+"/elista/uzytkownicy/pobierzPoId/1";
                try {

                    finalUserLogin.put("Username",login);
                    finalUserLogin.put("Password",password);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.GET, url, finalUserLogin, new Response.Listener<JSONObject>() {


                            @Override
                            public void onResponse(JSONObject response) {
                                Intent intent  = new Intent(LoginActivity.this, UserAreaActivity.class);
                                LoginActivity.this.startActivity(intent);

                            }
                        },
                                new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
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
        });
        assert tvRegisterHere != null;
        tvRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
    }
}
