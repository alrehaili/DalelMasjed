package com.example.dalelmasjed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dalelmasjed.Adaptor.CommentAdapter;
import com.example.dalelmasjed.Model.Comment;
import com.example.dalelmasjed.helper.AppController;
import com.example.dalelmasjed.helper.WebServices;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comments extends AppCompatActivity {

    private String TAG = Comments.class.getSimpleName();
    List<Comment> commentList = new ArrayList<>();
    ListView listView;
    CommentAdapter commentAdapter;
    EditText editText;
    Button button ;
    int MasjedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        Intent intent = getIntent();

        MasjedId = intent.getIntExtra("MasjedId" , 0 );

        editText = findViewById(R.id.commenttext);
        button=findViewById(R.id.addcomment);

        listView = findViewById(R.id.comlistv);

        commentAdapter = new CommentAdapter(this, commentList);
        listView.setAdapter(commentAdapter);

        getcomment(MasjedId);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!editText.getText().toString().isEmpty() )
                {
                    AddComment(   MasjedId ,  editText.getText().toString());
                    editText.setText("");
                }

            }
        });


    }

    public void AddComment (final int MasjedID, final  String Note)
    {

        // Tag used to cancel the request
        String tag_string_req = "req_login";
        StringRequest strReq = new StringRequest(Request.Method.POST, WebServices.URL_Addcomment, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response);

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    // Check for error node in json
                    if (!error) {

                        Comment comment = new Comment();
                        comment.setNote(Note);
                        commentList.add(comment);

                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }
                commentAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, " Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("MasjedID", String.valueOf(MasjedID));
                params.put("Note", Note);
                return params;
            }
        };
        // Adding request to request queue
        strReq.setShouldCache(false);
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);

    }

    private void getcomment(final int MasjedId) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";
        StringRequest strReq = new StringRequest(Request.Method.POST, WebServices.URL_Getcomment, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Get Comment Response: " + response);

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    // Check for error node in json
                    if (!error) {
                        JSONArray commentArray = jObj.getJSONArray("Comment");
                        //now looping through all the elements of the json array
                        for (int i = 0; i < commentArray.length(); i++) {
                            //getting the json object of the particular index inside the array
                            JSONObject commentObject = commentArray.getJSONObject(i);

                            Comment comment = new Comment();
                            //creating a hero object and giving them the values from json object
                            comment.setNote(commentObject.getString("Note"));
                            commentList.add(comment);
                        }

                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                }
                commentAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("MasjedId", String.valueOf(MasjedId));
                return params;
            }
        };
        // Adding request to request queue
        strReq.setShouldCache(false);
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }


}