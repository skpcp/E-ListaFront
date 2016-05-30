package com.example.bidzis.e_lista.Group;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bidzis.e_lista.R;

import org.w3c.dom.Text;

public class AddGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_group);

        final TextView tvAddGroupsName = (TextView) findViewById(R.id.tvAddGroupMain);
        final TextView tvEnterGroupsName = (TextView) findViewById(R.id.tvEnterGroupsName);
        final TextView tvEnterLidersEmail = (TextView) findViewById(R.id.tvEnterLidersEmail);
        final EditText etEnterGroupsName = (EditText) findViewById(R.id.etEnterGroupsName);
        final EditText etEnterLidersEmail = (EditText) findViewById(R.id.etEnterLidersEmail);
        final Button btnAddGroup = (Button) findViewById(R.id.btnAddGroup);

    }
}
