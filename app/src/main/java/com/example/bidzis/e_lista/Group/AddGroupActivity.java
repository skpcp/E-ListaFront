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
import org.w3c.dom.Text;

public class AddGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);

        final TextView tvAddGroupsName = (TextView) findViewById(R.id.tvAddGroupMain);
        final TextView tvEnterGroupsName = (TextView) findViewById(R.id.tvEnterGroupsName);
        final TextView tvEnterLidersEmail = (TextView) findViewById(R.id.tvEnterLidersEmail);
        final EditText etEnterGroupsName = (EditText) findViewById(R.id.etEnterGroupsName);
        final EditText etEnterLidersEmail = (EditText) findViewById(R.id.etEnterLidersEmail);
        final Button btnAddGroup = (Button) findViewById(R.id.btnAddGroup);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String jsonString = "{\n" + "  \"lider\": 0,\n" + "  \"nazwa\": \"string\"\n" + "}";
        JSONObject json = null;
        try {
            json = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        assert btnAddGroup != null;
        final JSONObject finalJson = json;
        btnAddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    assert finalJson != null;
                    assert etEnterLidersEmail != null;
                    finalJson.put("lider",etEnterLidersEmail.getText().toString());
                    assert etEnterGroupsName != null;
                    finalJson.put("nazwa",etEnterGroupsName.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String url = getString(R.string.ip) + "/elista/grupy/zapiszGrupe";
                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.POST, url, finalJson, new Response.Listener<JSONObject>() {


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
