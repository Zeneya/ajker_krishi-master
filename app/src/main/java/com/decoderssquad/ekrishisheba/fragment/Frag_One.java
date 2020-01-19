package com.decoderssquad.ekrishisheba.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.decoderssquad.ekrishisheba.CustomListAdapter;
import com.decoderssquad.ekrishisheba.Post;
import com.decoderssquad.ekrishisheba.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class Frag_One extends Fragment {

    public ProgressDialog progressDialog;
    String url = "http://www.ajkerkrishi.com/wp-json/wp/v2/posts?per_page=15&categories=69&fields=id,title";
    List<Object> list;
    Gson gson;
    ListView postList;
    Map<String, Object> mapPost;
    Map<String, Object> mapTitle;
    int postID;
    String postTitle[];


    Integer[] imgid = {
            R.drawable.fish,


    };


    public Frag_One() {


        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frag_one, container, false);


        postList = v.findViewById(R.id.postList);
        progressDialog = new ProgressDialog(getActivity());
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

                CustomListAdapter adapter = new CustomListAdapter(getActivity(), postTitle, imgid);
                postList.setAdapter(adapter);

                //postList.setAdapter(new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, postTitle));
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getActivity().getApplicationContext(), "wait", Toast.LENGTH_LONG).show();
               Intent i = getActivity().getApplicationContext().getPackageManager()
                        .getLaunchIntentForPackage(getActivity().getApplicationContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);













            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        rQueue.add(request);

        postList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mapPost = (Map<String, Object>) list.get(position);
                postID = ((Double) mapPost.get("id")).intValue();

                Intent intent = new Intent(getActivity().getApplicationContext(), Post.class);
                intent.putExtra("id", "" + postID);
                startActivity(intent);
            }
        });


        return v;
    }

}