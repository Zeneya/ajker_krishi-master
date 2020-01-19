package com.decoderssquad.ekrishisheba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ImageView;

public class AjkerKrishi extends AppCompatActivity {
    private WebView abt;
    ImageView image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajker_krishi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.abt = findViewById(R.id.about);
        //image = findViewById(R.id.img);

      //  Picasso.get().load("http://shayshab.decoderssquad.com/ajker.png").into(image);


        setTitle("আমাদের সম্পর্কে");
        this.abt.loadUrl("file:///android_asset/ajkerkrishi.html");


    }
}
