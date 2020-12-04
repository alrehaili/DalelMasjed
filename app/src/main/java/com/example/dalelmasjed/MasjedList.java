package com.example.dalelmasjed;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dalelmasjed.Adaptor.MasjedRowAdaptor;
import com.example.dalelmasjed.Model.Masjed;
import com.example.dalelmasjed.helper.AppController;
import com.example.dalelmasjed.helper.WebServices;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MasjedList extends AppCompatActivity {

    private String TAG = com.example.dalelmasjed.MasjedList.class.getName();

/* Decleartion...*/
    List<Masjed>  MasjedList =  new ArrayList<>();
    MasjedRowAdaptor masjedRowAdaptor;
    ListView listView;
    String Region ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masjed_list);

        listView = findViewById(R.id.MasjedListV);

        TextView emptyText = findViewById(R.id.emptyElement);
        listView.setEmptyView(emptyText);
        masjedRowAdaptor = new MasjedRowAdaptor(this,MasjedList);
        listView.setAdapter(masjedRowAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Toast.makeText(getApplicationContext() , MasjedList.get(i).getName() , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext() , Comments.class);
                intent.putExtra("MasjedId" , 0);

                startActivity(intent);

            }
        });

        Intent intent = getIntent();
        Region = intent.getStringExtra("region");

        GetMasjed(Region);
     }

    private void GetMasjed(final String region) {

        String tag_string_req = "req_login";
        StringRequest strReq = new StringRequest(Request.Method.POST , WebServices.URL_GetMasjed, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, " Response: " + response);

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    // Check for error node in json
                    if (!error) {
                        JSONArray MsjdArray = jObj.getJSONArray("Msjd");

                        //now looping through all the elements of the json array
                        for (int i = 0; i < MsjdArray.length(); i++) {

                            JSONObject MsjdObject = MsjdArray.getJSONObject(i);

                            Masjed m = new Masjed();
                            m.setName(MsjdObject.getString("name"));
                            m.setRating(MsjdObject.getDouble("rating"));
                            m.setCapacity(MsjdObject.getInt("Capacity"));

                            if (MsjdObject.getInt("womensec")  == 1) {
                                m.setWomensec(true);
                            }
                            else {
                                m.setWomensec(false);
                            }

                            if ( MsjdObject.getInt("Parking")== 1) {
                                m.setParking(true);
                            }
                            else {
                                m.setParking(false);
                            }

                            if (MsjdObject.getInt("Wodhow")  == 1) {
                                m.setWodhow(true);
                            }
                            else {
                                m.setWodhow(false);
                            }

                            if (MsjdObject.getInt("Jumaah")  == 1) {
                                m.setJumaah(true);
                            }
                            else {
                                m.setJumaah(false);
                            }


                            MasjedList.add(m);
                        }

                        masjedRowAdaptor.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, " Error: " + error.getMessage());
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to Deactivated the account  url
                Map<String, String> params = new HashMap<>();
                params.put("region", region);
                return params;
            }
        };
        // Adding request to request queue
        strReq.setShouldCache(false);
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

}