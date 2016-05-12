package com.example.bidzis.e_lista.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bidzis.e_lista.R;

public class UsersMenagmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_menagment);

        final Button btActivateNewUser = (Button) findViewById(R.id.btActiveNewUser);
        final Button btActivateUser = (Button) findViewById(R.id.btActivateUser);
        final Button btDeactivateUser = (Button) findViewById(R.id.btDeactivateUser);
        final Button btEditAddUser = (Button) findViewById(R.id.btAddEditUser);
        final Button btShowAll = (Button) findViewById(R.id.btShowAllUsers);

        assert btActivateNewUser != null;
        btActivateNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(UsersMenagmentActivity.this, ActivateNewUserActivity.class);
                UsersMenagmentActivity.this.startActivity(intent);
            }
        });
        assert btActivateUser != null;
        btActivateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(UsersMenagmentActivity.this, ActivateUserActivity.class);
                UsersMenagmentActivity.this.startActivity(intent);
            }
        });
        assert btDeactivateUser != null;
        btDeactivateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(UsersMenagmentActivity.this, DeactivateUserActivity.class);
                UsersMenagmentActivity.this.startActivity(intent);
            }
        });
        assert btShowAll != null;
        btShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(UsersMenagmentActivity.this, ShowAllUsersActivity.class);
                UsersMenagmentActivity.this.startActivity(intent);
            }
        });
        assert btEditAddUser != null;
        btEditAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(UsersMenagmentActivity.this, RegisterUserActivity.class);
                UsersMenagmentActivity.this.startActivity(intent);
            }
        });
    }
}
