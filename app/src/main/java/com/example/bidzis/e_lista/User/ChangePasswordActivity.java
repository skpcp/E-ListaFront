package com.example.bidzis.e_lista.User;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.bidzis.e_lista.R;

import org.json.JSONException;
import org.json.JSONObject;

public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        String jsonString = "{\"email\": \"string\", \"haslo\": \"string\", \"noweHaslo\": \"string\"}";
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final EditText etOldPassword = (EditText) findViewById(R.id.etOldPasswordChangePassword);
        final EditText etNewPassword = (EditText) findViewById(R.id.etNewPasswordChangePassword);
        final EditText etConfirmPassword = (EditText) findViewById(R.id.etConfirmNewPasswordChangePassword);
        final Button btChange = (Button) findViewById(R.id.btChangePassword);
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        assert btChange != null;
        final JSONObject finalJsonObject = jsonObject;
        final JSONObject finalJsonObject1 = jsonObject;
        Bundle extras = getIntent().getExtras();
        final String email = extras.getString("email");
        btChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.ip) + "/elista/uzytkownicy/zmienHaslo/";
                assert etConfirmPassword != null;
                assert etOldPassword != null;
                assert etNewPassword != null;
                String newPassword = etNewPassword.getText().toString().trim();

                String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";

                boolean zmiennaPomocnicza = false;

                if (newPassword.matches(passwordPattern)) {
                    if (etNewPassword.getText().toString().equals(etConfirmPassword.getText().toString()))
                    {
                        zmiennaPomocnicza = true;
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "New password and confirm password are not the same", Toast.LENGTH_SHORT).show();
                    }
                    //zmiennaPomocnicza = true;
                } else {
                    zmiennaPomocnicza = false;
                    Toast.makeText(getApplicationContext(), "Invalid new password format", Toast.LENGTH_SHORT).show();
                }
                if (zmiennaPomocnicza){
                    assert finalJsonObject != null;
                    try {
                        finalJsonObject.put("email",email);
                        finalJsonObject.put("haslo",etOldPassword.getText().toString());
                        finalJsonObject.put("noweHaslo",etNewPassword.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JsonObjectRequest request = new JsonObjectRequest
                            (Request.Method.POST, url, finalJsonObject, new Response.Listener<JSONObject>() {


                                @Override
                                public void onResponse(JSONObject response) {
                                    Toast.makeText(getApplicationContext(), "Register Succesful",
                                            Toast.LENGTH_LONG).show();
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
                                                Toast.makeText(getApplicationContext(), "Password has changed",
                                                        Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                    requestQueue.add(request);
                }
            }
        });
    }
}
