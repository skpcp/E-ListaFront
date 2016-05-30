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
public class EditRolesNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_roles_name);

        final TextView tvEditRolesName = (TextView) findViewById(R.id.tvEditRolesName);
        final TextView tvEnterOldRolesName = (TextView) findViewById(R.id.tvEnterOldRolesName);
        final EditText etEnterOldRolesName = (EditText) findViewById(R.id.etEnterOldRolesName);
        final TextView tvEnterNewRolesName = (TextView) findViewById(R.id.tvEnterNewRolesName);
        final EditText etEnterNewRolesName = (EditText) findViewById(R.id.etEnterNewRolesName);
        final Button btnRoleSaveChanges = (Button) findViewById(R.id.btnRoleSaveChanges);




    }
}
