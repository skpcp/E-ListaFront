package com.example.bidzis.e_lista.Role;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.bidzis.e_lista.R;

public class FindAllRolesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_all_roles);

        final TextView tvFindAllRoles = (TextView) findViewById(R.id.tvFindAllRoles);
        final Button btnFindAllRoles = (Button) findViewById(R.id.btnFindAllRoles);
    }
}
