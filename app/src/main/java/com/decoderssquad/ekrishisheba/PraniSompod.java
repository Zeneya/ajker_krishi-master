package com.decoderssquad.ekrishisheba;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class PraniSompod extends AppCompatActivity {

    Integer[] imgid = {
            R.drawable.fish,


    };

    String url = "http://www.ajkerkrishi.com/wp-json/wp/v2/posts?per_page=20&categories=6&fields=id,title";
    List<Object> list;
    Gson gson;
    ProgressDialog progressDialog;
    ListView postList;
    Map<String, Object> mapPost;
    Map<String, Object> mapTitle;
    int postID;
    String postTitle[];
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chad_krishi);

        setTitle("প্রানিসম্পদ");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        postList = findViewById(R.id.postList);
        progressDialog = new ProgressDialog(PraniSompod.this);
        progressDialog.setMessage("অপেক্ষা করুন লোড হচ্ছে...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                gson = new Gson();
                list = (List) gson.fromJson(s, List.class);
                postTitle = new String[list.size()];

                for (int i = 0; i < list.size(); ++i) {
                    mapPost = (Map<String, Object>) list.get(i);
                    mapTitle = (Map<String, Object>) mapPost.get("title");
                    postTitle[i] = (String) mapTitle.get("rendered");
                }

                // postList.setAdapter(new ArrayAdapter(ChadKrishi.this,android.R.layout.simple_list_item_1,postTitle));

                CustomListAdapter adapter = new CustomListAdapter(PraniSompod.this, postTitle, imgid);
                postList.setAdapter(adapter);
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(PraniSompod.this, "wait", Toast.LENGTH_LONG).show();
                finish();

                startActivity(getIntent());
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(PraniSompod.this);
        rQueue.add(request);

        postList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mapPost = (Map<String, Object>) list.get(position);
                postID = ((Double) mapPost.get("id")).intValue();

                Intent intent = new Intent(getApplicationContext(), Post.class);
                intent.putExtra("id", "" + postID);
                startActivity(intent);
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
