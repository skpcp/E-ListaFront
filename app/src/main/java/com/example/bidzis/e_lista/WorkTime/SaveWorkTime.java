package com.example.bidzis.e_lista.WorkTime;

import android.app.DownloadManager;
import android.net.Uri;
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
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

public class SaveWorkTime extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_work_time);

        final EditText etDay = (EditText) findViewById(R.id.etDayWorkTime);
        final EditText etId = (EditText) findViewById(R.id.etIdWorkTime);
        final EditText etStart = (EditText) findViewById(R.id.etStartWorkTime);
        final EditText etEmail = (EditText) findViewById(R.id.etEmailWorkTime);
        final EditText etFinish = (EditText) findViewById(R.id.etFinishWorkTime);
        final EditText etWorksDone = (EditText) findViewById(R.id.etWorksDoneWorkTime);
        final Button btSave = (Button) findViewById(R.id.btnSaveSaveWorkTime);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String example = "{ \"dzien\": \"string\", " +
                "\"id\": \"0\", " +
                "\"rozpoczecie\": \"string\", " +
                "\"email\": \"string\", " +
                "\"zakonczenie\": \"string\", " +
                "\"zakresPracy\": \"string\", }";

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
                String url = getString(R.string.ip) + "/elista/czasPracy/zapiszCzasPracy";
                try {
                    assert etDay != null;
                    finalWorkTimeSave.put("dzien", etDay.getText().toString());
                    assert etId != null;
                    finalWorkTimeSave.put("id", etId.getText().toString());
                    assert etStart != null;
                    finalWorkTimeSave.put("rozpoczecie", etStart.getText().toString());
                    assert etEmail != null;
                    finalWorkTimeSave.put("email", etEmail.getText().toString());
                    assert etFinish != null;
                    finalWorkTimeSave.put("zakonczenie", etFinish.getText().toString());
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
