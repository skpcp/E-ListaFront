package com.example.bidzis.e_lista.User;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterUserActivity extends AppCompatActivity {

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

        String userExample = "{\"aktywnosc\": \"AKTYWNY\",\"email\": \"string\",\"grupa\": {\"nazwa\": \"Pracownicy Firmy\"},\"haslo\": \"string\",\"imie\": \"string\",\"nazwisko\": \"string\",\"rola\": {\"nazwa\": \"string\"},\"telefon\": \"string\"}";
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
            }
        });


        assert btSearchUser != null;
        btSearchUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.ip)+"/elista/uzytkownicy/pobierzPoId/"+etIDUser.getText().toString();

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
                                    userObject[0].put("email",response.getString("email"));

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
            }
        });

        assert btRegisterUser != null;
        btRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject role = new JSONObject();
                try {
                    role = new JSONObject("{\"nazwa\": \"string\"}");
                    role.put("nazwa",spinner.getSelectedItem().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    userObject[0].put("rola",role);
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
                    userObject[0].put("aktywnosc","AKTYWNY");

                } catch (JSONException e) {
                    e.printStackTrace();
                }


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
        });
    }

}

