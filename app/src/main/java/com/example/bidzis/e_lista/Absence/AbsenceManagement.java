package com.example.bidzis.e_lista.Absence;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bidzis.e_lista.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class AbsenceManagement extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absence_management);

        final Button btnFindByDate = (Button) findViewById(R.id.btnFindByDate);
        final Button btnFindByUserID = (Button) findViewById(R.id.btnFIndByUserId);
        final Button btnFindByUserType = (Button) findViewById(R.id.btnFindByUserType);
        final Button btnFindByType = (Button) findViewById(R.id.btnFindByType);
        final Button btnShowAllAbsence = (Button) findViewById(R.id.btnShowAllAbsence);
        final Button btnDelete = (Button) findViewById(R.id.btnDelete);
        final Button btnSaveAbsence = (Button) findViewById(R.id.btnSaveAbsence);

        assert btnFindByDate != null;
        btnFindByDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsenceManagement.this, FindByDate.class);
                AbsenceManagement.this.startActivity(intent);

            }
        });
        assert btnFindByUserID != null;
        btnFindByUserID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsenceManagement.this, FindByUserID.class);
                AbsenceManagement.this.startActivity(intent);
            }
        });
        assert btnFindByUserType != null;
        btnFindByUserType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsenceManagement.this, FindByUserType.class);
                AbsenceManagement.this.startActivity(intent);
            }
        });
        assert btnFindByType != null;
        btnFindByType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsenceManagement.this, FindByType.class);
                AbsenceManagement.this.startActivity(intent);
            }
        });
        assert btnShowAllAbsence != null;
        btnShowAllAbsence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsenceManagement.this, ShowAllAbsence.class);
                AbsenceManagement.this.startActivity(intent);
            }
        });
        assert btnDelete != null;
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsenceManagement.this, Delete.class);
                AbsenceManagement.this.startActivity(intent);
            }
        });
        assert btnSaveAbsence != null;
        btnSaveAbsence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsenceManagement.this, SaveAbsence.class);
                AbsenceManagement.this.startActivity(intent);
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "AbsenceManagement Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.bidzis.e_lista.Absence/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "AbsenceManagement Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.bidzis.e_lista.Absence/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
