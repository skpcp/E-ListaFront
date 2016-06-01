package com.example.bidzis.e_lista.Absence;

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

public class SaveAbsence extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_absence);


        final EditText etAbsAbsenceDateSave1 = (EditText) findViewById(R.id.etAbsenceDateSave1);
        final EditText etAbsDateID = (EditText) findViewById(R.id.etAbsenceDateID);
        final EditText etAbsDateAmount = (EditText) findViewById(R.id.etAbsenceDateAmount);
        final EditText etAbsDateType = (EditText) findViewById(R.id.etAbsenceDateType);
        final EditText etAbsDateUserID = (EditText) findViewById(R.id.etAbsenceDateUserID);
        final Button btnAbsDateSave = (Button) findViewById(R.id.btnAbsenceDateSave);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        String example =  "{ \"data\": \"string\", " +
                "\"id\": \"0\", " +
                "\"ilosc\": \"string\", " +
                "\"typ\": \"string\", " +
                "\"uzytkownikId\": \"0\", }";

        JSONObject absenceSave = new JSONObject();
        try{
            absenceSave = new JSONObject(example);
        } catch (JSONException e){
            e.printStackTrace();
        }
                assert btnAbsDateSave !=null;
        final JSONObject finalAbsenceSave = absenceSave;
        btnAbsDateSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String url = getString(R.string.ip) + "/elista/nieobecnosci/zapiszNieobecnosci";
                try{
                    assert etAbsAbsenceDateSave1 != null;
                    finalAbsenceSave.put("data", etAbsAbsenceDateSave1.getText().toString());
                    assert etAbsDateID !=null;
                    finalAbsenceSave.put("id", etAbsDateID.getText().toString());
                    assert etAbsDateAmount !=null;
                    finalAbsenceSave.put("ilosc", etAbsDateAmount.getText().toString());
                    assert etAbsDateType !=null;
                    finalAbsenceSave.put("typ", etAbsDateType.getText().toString());
                    assert etAbsDateUserID !=null;
                    finalAbsenceSave.put("uzytkownikId", etAbsDateUserID.getText().toString());

                } catch (JSONException e){
                    e.printStackTrace();
                }

                JsonObjectRequest request = new JsonObjectRequest
                        (
                                Request.Method.POST, url, finalAbsenceSave, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "Saved absence",
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
                                }
                        );
                requestQueue.add(request);

            }
        });

    }
}
