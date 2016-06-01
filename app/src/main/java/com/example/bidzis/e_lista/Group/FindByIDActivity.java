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

public class FindByIDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_by_id);

        final TextView tvFindGbyID = (TextView) findViewById(R.id.tvFindGbyID);
        final TextView tvEnterGroupID = (TextView) findViewById(R.id.tvEnterGroupsID);
        final EditText etEnterGroupId = (EditText) findViewById(R.id.etEnterGroupID);
        final Button btnFindGbyID = (Button) findViewById(R.id.btnFindGbyID);
        final TextView tvIDGruop = (TextView) findViewById(R.id.tvIDGroupFindByID);
        final TextView tvNameGroup = (TextView) findViewById(R.id.tvNameFindGroupByID);
        final TextView tvLiderGroup = (TextView) findViewById(R.id.tvLiderFindGruopByID);
        assert tvIDGruop != null;
        tvIDGruop.setVisibility(View.GONE);
        assert tvNameGroup != null;
        tvNameGroup.setVisibility(View.GONE);
        assert tvLiderGroup != null;
        tvLiderGroup.setVisibility(View.GONE);
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        assert btnFindGbyID != null;
        btnFindGbyID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert etEnterGroupId != null;
                String url = getString(R.string.ip) + "/elista/grupy/pobierzGrupePoId/" + etEnterGroupId.getText().toString();

                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                tvIDGruop.setVisibility(View.VISIBLE);
                                tvNameGroup.setVisibility(View.VISIBLE);
                                tvLiderGroup.setVisibility(View.VISIBLE);
                                JSONObject json = null;
                                try {
                                    json = (JSONObject) response.get("lider");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    tvIDGruop.setText("ID: "+response.get("id").toString());
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
