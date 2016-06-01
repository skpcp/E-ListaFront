package com.example.bidzis.e_lista.WorkTime;

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

public class SaveWorkTimeUsingPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_work_time_using_plan);

        final EditText etDay = (EditText) findViewById(R.id.etDayWorkTimeUP);
        final EditText etId = (EditText) findViewById(R.id.etIdWorkTimeUP);
        final EditText etUserId = (EditText) findViewById(R.id.etUserIdWorkTimeUP);
        final EditText etWorksDone = (EditText) findViewById(R.id.etWorksDoneWorkTimeUP);
        final Button btSave = (Button) findViewById(R.id.btnSaveSaveWorkTimeUP);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String example = "{ \"dzien\": \"string\", " +
                "\"id\": \"0\", " +
                "\"uzytkownikId\": \"0\", " +
                "\"zakresPracy\": \"string\", }";
        //final String stringPlanOdPattern = "[0-2]{1}[0-9]{1}\\:+[0-5]{1}[0-9]{1}";
        final String stringDataPattern = "[0-2]{1}[0-9]{1}[0-9]{1}[0-9]{1}\\-+[0-1]{1}[0-9]{1}\\-+[0-3]{1}[0-9]{1}";

        JSONObject workTimeSave = new JSONObject();
        try {
            workTimeSave = new JSONObject(example);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        assert btSave != null;
        final JSONObject finalWorkTimeSave = workTimeSave;
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.ip) + "/elista/czasPracy/zapiszCzasPracyWedlugPlanu";
                boolean flaga = false;

                int licznik = 0;


                if (etDay.getText().toString().matches(stringDataPattern)) {
                    String elo = "";
                    String elo2 = "";
                    elo += etDay.getText().toString().charAt(5);
                    elo += etDay.getText().toString().charAt(6);
                    elo2 += etDay.getText().toString().charAt(8);
                    elo2 += etDay.getText().toString().charAt(9);

                    if (Integer.parseInt(elo) > 12) {
                        flaga = false;
                    } else {
                        licznik++;
                    }
                    if (Integer.parseInt(elo2) > 31) {
                        flaga = false;
                    } else {
                        licznik++;
                    }
                }
                if (licznik == 2) {
                    try {
                        assert etDay != null;
                        finalWorkTimeSave.put("dzien", etDay.getText().toString());
                        assert etId != null;
                        finalWorkTimeSave.put("id", etId.getText().toString());
                        assert etUserId != null;
                        finalWorkTimeSave.put("uzytkownikId", etUserId.getText().toString());
                        assert etWorksDone != null;
                        finalWorkTimeSave.put("zakresPracy", etWorksDone.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    JsonObjectRequest request = new JsonObjectRequest
                            (Request.Method.POST, url, finalWorkTimeSave, new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Toast.makeText(getApplicationContext(), "Zapisano Czas Pracy",
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
                }else{
                    Toast.makeText(getApplicationContext(), "Nieprawidłowy format daty lub godziny",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}




