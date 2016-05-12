package com.example.bidzis.e_lista.WorkTime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bidzis.e_lista.R;

import org.json.JSONException;
import org.json.JSONObject;

public class ShowWorkTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_work_time);

//        final EditText etIdUser = (EditText) findViewById(R.id.etIdUser);
//        final Button btShow = (Button) findViewById(R.id.btnShowInShowWorkTime);
//
//        assert etIdUser != null;
//        etIdUser.setText("0");
//        final RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        etIdUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                etIdUser.setText("");
//            }
//        });
//        assert btShow != null;
//        btShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = getString(R.string.ip)+"/elista/uzytkownicy/pobierzPoId/"+etIdUser.getText().toString();
//
//                JsonObjectRequest request = new JsonObjectRequest
//                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//                            @Override
//                            public void onResponse(JSONObject response) {
//
//                                }
    }
}
