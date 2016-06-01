package com.example.bidzis.e_lista.Role;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bidzis.e_lista.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FindRoleByNameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_role_by_name);

        final EditText etName = (EditText) findViewById(R.id.etEnterRolesName);
        final Button btShow = (Button) findViewById(R.id.btnFindRoleByName);
        final TextView tvRole = (TextView) findViewById(R.id.tvRoleFindRoleByName);
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        final JSONArray[] jsonArray = {null};
        final JSONObject jsonObject = null;
        assert btShow != null;
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                assert etName != null;
                String url = getString(R.string.ip) + "/elista/role/znajdzRolePoNazwie/" + etName.getText().toString();
                JsonObjectRequest request = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    tvRole.setText("Rola: " +response.get("nazwa").toString());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    jsonArray[0] = (JSONArray) response.get("uprawnienia");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                ArrayList<String> value = new ArrayList<>();
                                String uprawnienia = "Uprawnienia: ";
                                if (jsonArray[0] != null) {
                                    int len = jsonArray[0].length();
                                    for (int i = 0; i < len; i++) {

                                        try {
                                            JSONObject jsonObject = (JSONObject) jsonArray[0].get(i);
                                            if (i == jsonArray[0].length()-1){
                                                uprawnienia+=jsonObject.getString("nazwa");
                                                break;
                                            }
                                            uprawnienia+=jsonObject.getString("nazwa")+", ";
                                            value.add(i, "Rola: "+jsonObject.get("nazwa").toString()+"\n"+uprawnienia);

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                final ListView listview = (ListView) findViewById(R.id.lvFindRoleByName);
                                Iterator it = value.iterator();

                                final ArrayList<String> list = new ArrayList<String>();
                                while (it.hasNext()) {
                                    list.add((String) it.next());
                                }
                                final StableArrayAdapter adapter = new StableArrayAdapter(FindRoleByNameActivity.this,
                                        android.R.layout.simple_list_item_1, list);
                                assert listview != null;
                                listview.setAdapter(adapter);
                                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        final ArrayList<Integer> help = new ArrayList<Integer>();
                                        for (int j = 0; j < 10; j++) {
                                            help.add(j);
                                        }

                                    }
                                });
                            }
                        },

                                new Response.ErrorListener() {

                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                                            Toast.makeText(getApplicationContext(), "Timeout",
                                                    Toast.LENGTH_LONG).show();
                                        } else if (error instanceof AuthFailureError) {
                                            Toast.makeText(getApplicationContext(), "1",
                                                    Toast.LENGTH_LONG).show();
                                        } else if (error instanceof ServerError) {
                                            Toast.makeText(getApplicationContext(), "Bląd serwera",
                                                    Toast.LENGTH_LONG).show();
                                        } else if (error instanceof NetworkError) {
                                            Toast.makeText(getApplicationContext(), "Problem z połączeniem internetowym",
                                                    Toast.LENGTH_LONG).show();
                                        } else if (error instanceof ParseError) {
                                            Toast.makeText(getApplicationContext(), "Błąd",
                                                    Toast.LENGTH_LONG).show();
                                        }
                                    }

                                });
                requestQueue.add(request);
            }
        });

    }




    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }
}
