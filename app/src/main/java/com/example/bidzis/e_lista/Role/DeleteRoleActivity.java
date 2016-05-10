package com.example.bidzis.e_lista.Role;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import org.json.JSONObject;

public class DeleteRoleActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_role);

        final TextView tvDeleteRole = (TextView) findViewById(R.id.tvDeleteRole);
        final TextView tvEnterRolesNameToDelete = (TextView) findViewById(R.id.tvEnterRolesNameToDelete);
        final EditText etEnterRolesNameToDelete = (EditText) findViewById(R.id.etEnterRolesNameToDelete);
        final Button btnDeleteRole = (Button) findViewById(R.id.btnDeleteRole);






    }
}
