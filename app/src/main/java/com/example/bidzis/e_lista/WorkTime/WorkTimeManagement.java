package com.example.bidzis.e_lista.WorkTime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bidzis.e_lista.R;
import com.example.bidzis.e_lista.User.ShowAllUsersActivity;

public class WorkTimeManagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_time_management);
        final Button btShowWorkTime = (Button) findViewById(R.id.btnShowWorkTime);
        final Button btShowAllWorkTimes = (Button) findViewById(R.id.btnShowAllWorkTimes);
        final Button btSaveWorkTime = (Button) findViewById(R.id.btnSaveWorkTime);
        final Button btSaveWorkTimeUsingPlan = (Button) findViewById(R.id.btnSaveWorkTimeUsingPlan);
        final Button btDeleteWorkTime = (Button) findViewById(R.id.btnDeleteWorkTime);

        assert btShowWorkTime != null;
        btShowWorkTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkTimeManagement.this, ShowWorkTime.class);
                WorkTimeManagement.this.startActivity(intent);
            }
        });
        assert btShowAllWorkTimes != null;
        btShowAllWorkTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkTimeManagement.this, ShowAllWorkTimes.class);
                WorkTimeManagement.this.startActivity(intent);
            }
        });
        assert btSaveWorkTime != null;
        btSaveWorkTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkTimeManagement.this, SaveWorkTime.class);
                WorkTimeManagement.this.startActivity(intent);
            }
        });
        assert btSaveWorkTimeUsingPlan != null;
        btSaveWorkTimeUsingPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkTimeManagement.this, SaveWorkTimeUsingPlan.class);
                WorkTimeManagement.this.startActivity(intent);
            }
        });
        assert btDeleteWorkTime != null;
        btDeleteWorkTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkTimeManagement.this, DeleteWorkTime.class);
                WorkTimeManagement.this.startActivity(intent);
            }
        });
    }
}
