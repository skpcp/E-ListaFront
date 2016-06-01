package com.example.bidzis.e_lista.Group;

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

public class FindGbyNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_gby_name);


        final TextView tvFindGbyName = (TextView) findViewById(R.id.tvFindGbyName);
        final TextView tvEnterGroupsName = (TextView) findViewById(R.id.tvEnterGroupsName);
        final EditText etEnterGroupsName = (EditText) findViewById(R.id.etEnterGroupsName);
        final Button btnFindGbyName = (Button) findViewById(R.id.btnFindGbyName);
        final TextView tvIDGroup = (TextView) findViewById(R.id.tvIDFindGroupByName);
        final TextView tvNameGroup = (TextView) findViewById(R.id.tvNameFindGroupByName);
        final TextView tvLiderGroup = (TextView) findViewById(R.id.tvLiderFindGroupByName);

        assert tvIDGroup != null;
        tvIDGroup.setVisibility(View.GONE);
        assert tvNameGroup != null;
        tvNameGroup.setVisibility(View.GONE);
        assert tvLiderGroup != null;
        tvLiderGroup.setVisibility(View.GONE);
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        assert btnFindGbyName != null;
        btnFindGbyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                assert etEnterGroupsName != null;
                String url = getString(R.string.ip) + "/elista/grupy/pobierzGrupePoNazwie/" + etEnterGroupsName.getText().toString();

                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                tvIDGroup.setVisibility(View.VISIBLE);
                                tvNameGroup.setVisibility(View.VISIBLE);
                                tvLiderGroup.setVisibility(View.VISIBLE);
                                JSONObject json = null;
                                try {
                                    json = (JSONObject) response.get("lider");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    tvIDGroup.setText("ID: "+response.get("id").toString());
                                    tvNameGroup.setText("Nazwa grupy: "+response.getString("nazwa"));
                                    String string = "Lider: "+json.get("imie").toString()+" "+json.get("nazwisko").toString();
                                    tvLiderGroup.setText(string);

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
