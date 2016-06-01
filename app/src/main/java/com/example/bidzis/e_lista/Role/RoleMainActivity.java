package com.example.bidzis.e_lista.Role;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bidzis.e_lista.Group.ShowAllGroupActivity;
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

        assert btnFindAllRoles != null;
        btnFindAllRoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(RoleMainActivity.this, FindAllRolesActivity.class);
                RoleMainActivity.this.startActivity(intent);
            }
        });
        assert btnDeleteROle != null;
        btnDeleteROle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(RoleMainActivity.this, DeleteRoleActivity.class);
                RoleMainActivity.this.startActivity(intent);
            }
        });
        assert btnEditRolesName != null;
        btnEditRolesName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(RoleMainActivity.this, EditRolesNameActivity.class);
                RoleMainActivity.this.startActivity(intent);
            }
        });
        assert btnFindRoleByName != null;
        btnFindRoleByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(RoleMainActivity.this, FindRoleByNameActivity.class);
                RoleMainActivity.this.startActivity(intent);
            }
        });
    }

}
