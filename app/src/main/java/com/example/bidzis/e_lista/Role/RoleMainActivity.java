package com.example.bidzis.e_lista.Role;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.bidzis.e_lista.R;


public class RoleMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_main);

        final TextView tvRoleMenagment = (TextView) findViewById(R.id.tvRoleMenagment);
        final Button btnFindAllRoles = (Button) findViewById(R.id.btnFindAllRoles);
        final Button btnEditRolesName = (Button) findViewById(R.id.btnEditRolesName);
        final Button btnFindRoleByName = (Button) findViewById(R.id.btnFindRoleByName);
        final Button btnDeleteROle = (Button) findViewById(R.id.btnDeleteRole);
    }

}
