package com.example.bidzis.e_lista.Group;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bidzis.e_lista.R;

public class FindGbyNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_gby_name);


        final TextView tvFindGbyName = (TextView) findViewById(R.id.tvFindGbyName);
        final TextView tvEnterGroupsName = (TextView) findViewById(R.id.tvEnterGroupsName);
        final EditText etEnterGroupsName = (EditText) findViewById(R.id.etEnterGroupsName);
        final Button btnFindGbyName = (Button) findViewById(R.id.btnFindGbyName);
        
    }
}
