package com.example.bidzis.e_lista.Role;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bidzis.e_lista.R;
public class
FindRoleByNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_role_by_name);


        final TextView tvFindRoleByName = (TextView)findViewById(R.id.tvFindRoleByName);
        final TextView tvEnterRolesName = (TextView) findViewById(R.id.tvEnterRolesName);
        final EditText etEnterRolesName = (EditText) findViewById(R.id.etEnterRolesName);
        final Button btnFindRoleByName = (Button) findViewById(R.id.btnFindRoleByName);



    }
}
