package com.example.bidzis.e_lista.Group;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bidzis.e_lista.R;

public class FindGbyLidersEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_gby_liders_email);

        final TextView tvFindGbyLidersEmial = (TextView) findViewById(R.id.tvFindGbyLidersEmial);
        final TextView tvEnterLidersEmial = (TextView) findViewById(R.id.tvEnterLidersEmail);
        final EditText etEnterLidersEmial = (EditText) findViewById(R.id.etEnterLidersEmail);
        final Button btnFindGbyLidersEmail = (Button) findViewById(R.id.btnFindGbyLidersEmail);
    }
}
