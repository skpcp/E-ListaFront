package com.example.bidzis.e_lista.Absence;

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
import com.example.bidzis.e_lista.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Delete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        //final TextView tvDelAbsence = (TextView) findViewById(R.id.tVDeleteabsence);
        final EditText etAbsDeleteAbsence = (EditText) findViewById(R.id.etAbsenceDeleteAbsence);
        final Button btnDelAbsence = (Button) findViewById(R.id.btnDeleteAbsence);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        String jsonString = "{  \"id\": \"0\"}";
        JSONObject finalJson = null;
        try {
            finalJson = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        assert btnDelAbsence != null;
        final JSONObject finalJson1 = finalJson;
        btnDelAbsence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                assert etAbsDeleteAbsence != null;
                String url = getString(R.string.ip) + "/elista/nieobecnosci/usunPoId/"+etAbsDeleteAbsence.getText().toString();
                try {
                    assert finalJson1 != null;
                    finalJson1.put("id",etAbsDeleteAbsence.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.PUT, url, finalJson1, new Response.Listener<JSONObject>() {


                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "Deleted absence",
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
