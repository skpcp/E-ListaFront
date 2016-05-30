package com.example.bidzis.e_lista.Group;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bidzis.e_lista.R;
public class FindByIDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_by_id);

        final TextView tvFindGbyID = (TextView) findViewById(R.id.tvFindGbyID);
        final TextView tvEnterGroupID = (TextView) findViewById(R.id.tvEnterGroupsID);
        final EditText etEnterGroupId = (EditText) findViewById(R.id.etEnterGroupsID);
        final Button btnFindGbyID = (Button) findViewById(R.id.btnFindGbyID);
    }
}
