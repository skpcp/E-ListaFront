package com.example.bidzis.e_lista.Group;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bidzis.e_lista.R;
public class FindGbyLidersIDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_gby_liders_id);


        final TextView tvFindGbyLidersID = (TextView) findViewById(R.id.tvFindGbyLidersID);
        final TextView tvEnterLidersID = (TextView) findViewById(R.id.tvEnterLidersID);
        final EditText etEnterLidersID = (EditText) findViewById(R.id.etEnterLidersID);
        final Button btnFindGbyLidersID = (Button) findViewById(R.id.btnFindGbyLidersID);
        
    }
}
