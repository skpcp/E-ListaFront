package com.example.bidzis.e_lista.DailyPlans;

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
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

public class SaveDailyPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_daily_plan);

        final EditText etId = (EditText) findViewById(R.id.etIdSaveDailyPlan);
        final EditText etPlanFrom = (EditText) findViewById(R.id.etPlanFromSaveDailyPlan);
        final EditText etPlanTo = (EditText) findViewById(R.id.etPlanToSaveDailyPlan);
        final EditText etEmail = (EditText) findViewById(R.id.etEmailSaveDailyPlan);
        final Button btSave = (Button) findViewById(R.id.btnSaveSaveDailyPlan);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String example = "{\"id\": \"0\", " +
                "\"planDo\": \"2016-05-12T18:58:00.837Z\", " +
                "\"planOd\": \"2016-05-12T18:58:00.837Z\", " +
                "\"email\": \"string\", }";

        JSONObject dailyPlanSave = new JSONObject();
        try {
            dailyPlanSave = new JSONObject(example);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        assert btSave != null;
        final JSONObject finalDailyPlanSave = dailyPlanSave;
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.ip) + "/elista/dziennikplanow/zapiszDziennikPlanow";
                try {
                    assert etId != null;
                    finalDailyPlanSave.put("id", etId.getText().toString());
                    assert etPlanFrom != null;
                    finalDailyPlanSave.put("rozpoczecie", etPlanFrom.getText().toString());
                    assert etPlanTo != null;
                    finalDailyPlanSave.put("zakonczenie", etPlanTo.getText().toString());
                    assert etEmail != null;
                    finalDailyPlanSave.put("email", etEmail.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.POST, url, finalDailyPlanSave, new Response.Listener<JSONObject>() {
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
                                            Toast.makeText(getApplicationContext(), "Błąd",
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                requestQueue.add(request);
            }
        });
    }
}
