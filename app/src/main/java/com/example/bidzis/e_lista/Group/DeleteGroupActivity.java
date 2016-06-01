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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bidzis.e_lista.R;

import org.json.JSONException;
import org.json.JSONObject;

public class DeleteGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_group);



        final TextView tvDeleteGroupMain = (TextView) findViewById(R.id.tvDeleteGroupMain);
        final TextView tvEnterGroupsID = (TextView) findViewById(R.id.tvEnterGroupsID);
        final EditText etEnterGroupsID = (EditText) findViewById(R.id.etEnterGroupsID);
        final Button btnDeleteGroup = (Button) findViewById(R.id.btnDeleteGroup);
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        String jsonString = "{  \"napis\": \"string\"}";
        JSONObject finalJson = null;
        try {
            finalJson = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        assert btnDeleteGroup != null;
        final JSONObject finalJson1 = finalJson;
        btnDeleteGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                assert etEnterGroupsID != null;
                String url = getString(R.string.ip) + "/elista/grupy/usunGrupePoId/"+etEnterGroupsID.getText().toString();
                try {
                    assert finalJson1 != null;
                    finalJson1.put("napis",etEnterGroupsID.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.PUT, url, finalJson1, new Response.Listener<JSONObject>() {


                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "Register Succesful",
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
