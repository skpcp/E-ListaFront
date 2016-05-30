package com.example.bidzis.e_lista.DailyPlans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.bidzis.e_lista.R;

public class ShowDailyPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_daily_plan);

        final EditText etID = (EditText) findViewById(R.id.etIdShowDailyPlan);
        final Button btShow = (Button) findViewById(R.id.btnShowDailyPlan);

        assert etID != null;
        etID.setText("0");
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        etID.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                etID.setText("");
            }
        });

        assert btShow != null;
        btShow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ShowDailyPlan.this, ShowDailyPlanResult.class);
                ShowDailyPlan.this.startActivity(intent);
            }
        });

    }
}
