package com.example.bidzis.e_lista.Absence;

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

public class FindByDate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_by_date);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        final EditText etAbsDateAbsenceFind = (EditText) findViewById(R.id.etDateAbsenceFind);
        final EditText etAbsUserIDFindByDate = (EditText) findViewById(R.id.etAbsenceUserIDFindByDate);

        final TextView tvAbsFindByDateData = (TextView) findViewById(R.id.tvAbsenceFindByDateData);
        final TextView tvAbsFindByDateID = (TextView) findViewById(R.id.tvAbsenceFindByDateID);
        final TextView tvAbsFindByDateTyp = (TextView) findViewById(R.id.tvAbsenceFindByDateTyp);
        final TextView tvAbsFindByDateIlosc = (TextView) findViewById(R.id.tvAbsenceFindByDateIlosc);


        final Button btnAbsFindDateAbsence = (Button) findViewById(R.id.btnAbsenceFindDateAbsence);

        assert etAbsDateAbsenceFind  != null;
        assert etAbsUserIDFindByDate != null;
        assert btnAbsFindDateAbsence != null;
        btnAbsFindDateAbsence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.ip)+"/elista/nieobecnosci/pobierzPoDacie/"+etAbsDateAbsenceFind.getText().toString()+","+etAbsUserIDFindByDate.getText().toString();
                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                tvAbsFindByDateData.setVisibility(View.VISIBLE);
                                tvAbsFindByDateID.setVisibility(View.VISIBLE);
                                tvAbsFindByDateTyp.setVisibility(View.VISIBLE);
                                tvAbsFindByDateIlosc.setVisibility(View.VISIBLE);
                                JSONObject json = null;

                                try {
                                    tvAbsFindByDateData.setText("Data: "+response.getString("data"));
                                    tvAbsFindByDateID.setText("ID: "+response.getString("id"));
                                    tvAbsFindByDateTyp.setText("Typ: "+response.getString("typ"));
                                    tvAbsFindByDateIlosc.setText("Ilosc: "+response.getString("ilosc"));


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
