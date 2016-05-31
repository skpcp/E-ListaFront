package com.example.bidzis.e_lista.DailyPlans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bidzis.e_lista.R;

public class DailyPlansManagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_plans_management);

        final Button btShowDailyPlan = (Button) findViewById(R.id.btnShowDailyPlan);
        final Button btShowAllDailyPlans = (Button) findViewById(R.id.btnShowAllDailyPlans);
        final Button btSaveDailyPlan = (Button) findViewById(R.id.btnSaveDailyPlan);

        assert btShowDailyPlan != null;
        btShowDailyPlan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(DailyPlansManagement.this, ShowDailyPlan.class);
                DailyPlansManagement.this.startActivity(intent);
            }
        });
        assert btShowAllDailyPlans != null;
        btShowAllDailyPlans.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(DailyPlansManagement.this, ShowAllDailyPlans.class);
                DailyPlansManagement.this.startActivity(intent);
            }
        });
        assert btSaveDailyPlan != null;
        btSaveDailyPlan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(DailyPlansManagement.this, SaveDailyPlan.class);
                DailyPlansManagement.this.startActivity(intent);
            }
        });

    }
}
