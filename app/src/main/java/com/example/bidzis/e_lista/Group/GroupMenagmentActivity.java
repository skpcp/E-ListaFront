package com.example.bidzis.e_lista.Group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bidzis.e_lista.R;
import com.example.bidzis.e_lista.User.ActivateNewUserActivity;

public class GroupMenagmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_menagment);

        final TextView tvMain = (TextView) findViewById(R.id.tvMain);

        final Button btnAddGroup = (Button) findViewById(R.id.btnAddGroup);
        final Button btnDeleteGroup = (Button) findViewById(R.id.btnDeleteGroup);
        final Button btnFindGbyID = (Button) findViewById(R.id.btnFindGbyID);
        final Button btnFindGbyName = (Button) findViewById(R.id.btnFindGbyName);
        final Button btnFindGbyLidersID = (Button) findViewById(R.id.btnFindGbyLidersID);
        final Button btnFindGbyLidersEmail = (Button) findViewById(R.id.btnFindGbyLidersEmail);
        final Button btnShowAllGroup = (Button) findViewById(R.id.btnShowAllGroup);

        assert btnShowAllGroup != null;
        btnShowAllGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(GroupMenagmentActivity.this, ShowAllGroupActivity.class);
                GroupMenagmentActivity.this.startActivity(intent);
            }
        });
        assert btnAddGroup != null;
        btnAddGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(GroupMenagmentActivity.this, AddGroupActivity.class);
                GroupMenagmentActivity.this.startActivity(intent);
            }
        });
        assert btnDeleteGroup != null;
        btnDeleteGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(GroupMenagmentActivity.this, DeleteGroupActivity.class);
                GroupMenagmentActivity.this.startActivity(intent);
            }
        });
        assert btnFindGbyLidersEmail != null;
        btnFindGbyLidersEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(GroupMenagmentActivity.this, FindGbyLidersEmailActivity.class);
                GroupMenagmentActivity.this.startActivity(intent);
            }
        });
        assert btnFindGbyLidersID != null;
        btnFindGbyLidersID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(GroupMenagmentActivity.this, FindGbyLidersIDActivity.class);
                GroupMenagmentActivity.this.startActivity(intent);
            }
        });
        assert btnFindGbyID != null;
        btnFindGbyID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(GroupMenagmentActivity.this, FindByIDActivity.class);
                GroupMenagmentActivity.this.startActivity(intent);
            }
        });
        assert btnFindGbyName != null;
        btnFindGbyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(GroupMenagmentActivity.this, FindGbyNameActivity.class);
                GroupMenagmentActivity.this.startActivity(intent);
            }
        });


    }


}
