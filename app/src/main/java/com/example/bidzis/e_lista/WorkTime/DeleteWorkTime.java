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

public class DeleteWorkTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_work_time);

        final EditText etId = (EditText) findViewById(R.id.etIdDeleteWorkTime);
        final Button btDelete = (Button) findViewById(R.id.btnDeleteDeleteWorkTime);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String example = "{\"id\": \"0\"}";

        JSONObject workTimeDelete = new JSONObject();
        try {
            workTimeDelete = new JSONObject(example);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        assert btDelete != null;
        final JSONObject finalWorkTimeDelete = workTimeDelete;
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = getString(R.string.ip) + "/elista/czasPracy/usunCzasPracy/" + etId.getText().toString();
                try {
                    assert etId != null;
                    finalWorkTimeDelete.put("id", etId.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.PUT, url, null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "Usunięto Czas Pracy",
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
                                            Toast.makeText(getApplicationContext(), "Usunięto Dziennik Planów",
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                requestQueue.add(request);
            }
        });
    }
}
