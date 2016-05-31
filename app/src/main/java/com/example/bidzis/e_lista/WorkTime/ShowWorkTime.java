package com.example.bidzis.e_lista.WorkTime;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bidzis.e_lista.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ShowWorkTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_work_time);

        final EditText etUserID = (EditText) findViewById(R.id.etIdUserShowWorkTime);
        final EditText etDay = (EditText) findViewById(R.id.etDayShowWorkTime);
        final Button btShow = (Button) findViewById(R.id.btnShowShowWorkTime);
        final TextView tvDay = (TextView) findViewById(R.id.tvDayShowWorkTime);
        final TextView tvStart = (TextView) findViewById(R.id.tvStartShowWorkTime);
        final TextView tvFinish = (TextView) findViewById(R.id.tvFinishShowWorkTime);
        final TextView tvWorksDone = (TextView) findViewById(R.id.tvWorksDoneShowWorkTime);
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        assert btShow != null;
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                assert etUserID != null;
                assert etDay != null;
                String url = getString(R.string.ip) + "/elista/czasPracy/pobierzCzasPracyPoDacieIUzytkowniku/" + etUserID.getText().toString() + "," + etDay.getText().toString();

                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    tvDay.setText("Dzień: "+response.getString("dzien"));
                                    tvStart.setText("Rozpoczęcie: "+response.getString("rozpoczecie"));
                                    tvFinish.setText("Zakończenie: "+response.getString("zakonczenie"));
                                    tvWorksDone.setText("Zakres Pracy: "+response.getString("zakresPracy"));
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
    }
}

