package com.example.bidzis.e_lista.Group;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bidzis.e_lista.R;
public class DeleteGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_group);



        final TextView tvDeleteGroupMain = (TextView) findViewById(R.id.tvDeleteGroupMain);
        final TextView tvEnterGroupsID = (TextView) findViewById(R.id.tvEnterGroupsID);
        final EditText etEnterGroupsID = (EditText) findViewById(R.id.etEnterGroupsID);
        final Button btnDeleteGroup = (Button) findViewById(R.id.btnDeleteGroup);


    }
}
