package com.example.bidzis.e_lista.Group;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.bidzis.e_lista.R;

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

    }


}
