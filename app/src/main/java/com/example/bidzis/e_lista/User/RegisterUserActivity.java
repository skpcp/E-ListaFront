package com.example.bidzis.e_lista.User;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
import com.example.bidzis.e_lista.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterUserActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        final EditText etName = (EditText) findViewById(R.id.etNameRegisterUser);
        final EditText etSurName = (EditText) findViewById(R.id.etSurnameRegisterUser);
        final EditText etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumberRegisterUser);
        final EditText etIDUser = (EditText) findViewById(R.id.etIDRegisterUser);
        final Button btRegisterUser = (Button) findViewById(R.id.btRegisterUser);
        final Button btSearchUser = (Button) findViewById(R.id.btSearchRegisterUser);
        final Button btNewUser = (Button) findViewById(R.id.btNewRegisterUser);
        final TextView tvEmail = (TextView) findViewById(R.id.tvEmailRegisterUser);
        final TextView tvPassword = (TextView) findViewById(R.id.tvPasswordRegisterUser);
        final EditText etEmail = (EditText) findViewById(R.id.etEmailUserRegister);
        final EditText etPassword = (EditText) findViewById(R.id.etPasswordRegisterUser);

        final boolean[] flaga = {true};
        assert tvEmail != null;
//        tvEmail.setVisibility(View.GONE);
        assert tvPassword != null;
//        tvPassword.setVisibility(View.GONE);
        assert etEmail != null;
//        etEmail.setVisibility(View.GONE);
        assert etPassword != null;
//        etPassword.setVisibility(View.GONE);

        assert etIDUser != null;
        etIDUser.setText("0");
        final RequestQueue requestQueue = Volley.newRequestQueue(this);


        etIDUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etIDUser.setText("");
            }
        });

        final Spinner spinner = (Spinner) findViewById(R.id.spinnerRoleRegisterUSer);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.role_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final String userExample = "{\n" + "  \"aktywnosc\": \"AKTYWNY\",\n" + "  \"email\": \"string\",\n" + "  \"grupa\": \"Pracownicy Firmy\",\n" + "  \"haslo\": \"string\",\n" + "  \"imie\": \"string\",\n" + "  \"nazwisko\": \"string\",\n" + "  \"rola\": \"string\",\n" + "  \"telefon\": \"string\"\n" + "}";
        final JSONObject[] userObject = {new JSONObject()};
        try {
            userObject[0] = new JSONObject(userExample);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        assert btNewUser != null;
        btNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etIDUser.setText("0");
                assert etName != null;
                etName.setText("");
                assert etPhoneNumber != null;
                etPhoneNumber.setText("");
                assert etSurName != null;
                etSurName.setText("");
                try {
                    userObject[0] = new JSONObject(userExample);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                tvEmail.setVisibility(View.VISIBLE);
                tvPassword.setVisibility(View.VISIBLE);
                etEmail.setVisibility(View.VISIBLE);
                etPassword.setVisibility(View.VISIBLE);
                flaga[0] = true;
            }
        });


        assert btSearchUser != null;
        btSearchUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.ip) + "/elista/uzytkownicy/pobierzPoId/" + etIDUser.getText().toString();
                tvEmail.setVisibility(View.GONE);
                tvPassword.setVisibility(View.GONE);
                etEmail.setVisibility(View.GONE);
                etPassword.setVisibility(View.GONE);
                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    assert etName != null;
                                    etName.setText(response.getString("imie"));
                                    assert etSurName != null;
                                    etSurName.setText(response.getString("nazwisko"));
                                    assert etPhoneNumber != null;
                                    etPhoneNumber.setText(response.getString("telefon"));
                                    userObject[0].put("email", response.getString("email"));

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {

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
                flaga[0] = false;
            }
        });

        assert btRegisterUser != null;
        btRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                try {
                    userObject[0].put("rola", spinner.getSelectedItem().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    assert etName != null;
                    userObject[0].put("imie", etName.getText().toString());
                    assert etSurName != null;
                    userObject[0].put("nazwisko", etSurName.getText().toString());
                    assert etPhoneNumber != null;
                    userObject[0].put("telefon", etPhoneNumber.getText().toString());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (flaga[0]){
                    try {
                        userObject[0].put("email", etEmail.getText().toString());
                        userObject[0].put("haslo", etPassword.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String number = etPhoneNumber.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
                String numberPattern = "[0-9]+";
                boolean zmiennaPomocnicza = false;
                if (email.matches(emailPattern))
                {
                    if (password.matches(passwordPattern)){
                        zmiennaPomocnicza = true;
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Invalid password ", Toast.LENGTH_SHORT).show();
                    }
                    if (number.matches(numberPattern)){
                        zmiennaPomocnicza = true;
                    }
                    else{
                        zmiennaPomocnicza = false;
                        Toast.makeText(getApplicationContext(),"Invalid phone number format ", Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                }

                if (zmiennaPomocnicza) {

                    String urlSave = getString(R.string.ip) + "/elista/uzytkownicy/zapiszUzytkownika";
                    JsonObjectRequest request = new JsonObjectRequest
                            (Request.Method.POST, urlSave, userObject[0], new Response.Listener<JSONObject>() {


                                @Override
                                public void onResponse(JSONObject response) {
                                    Toast.makeText(getApplicationContext(), "Register Succesful",
                                            Toast.LENGTH_LONG).show();

                                }
                            }, new Response.ErrorListener() {

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
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


}

