package com.decoderssquad.ekrishisheba.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.decoderssquad.ekrishisheba.ChadKrishi;
import com.decoderssquad.ekrishisheba.Chasabad;
import com.decoderssquad.ekrishisheba.KrishiOdekta;
import com.decoderssquad.ekrishisheba.Krishitotho;
import com.decoderssquad.ekrishisheba.Member;
import com.decoderssquad.ekrishisheba.MotsoSompod;
import com.decoderssquad.ekrishisheba.PokaMakor;
import com.decoderssquad.ekrishisheba.PraniSompod;
import com.decoderssquad.ekrishisheba.R;
import com.decoderssquad.ekrishisheba.Video;

public class Frag_Two extends Fragment {


    LinearLayout aff;


    public Frag_Two() {


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
        View v = inflater.inflate(R.layout.frag_two, container, false);


        CardView btn = v.findViewById(R.id.ajkcard);
        CardView btn1 = v.findViewById(R.id.sodosho);
        CardView btn2 = v.findViewById(R.id.poramorsho);
        CardView btn3 = v.findViewById(R.id.krishitotho);
        CardView btn4 = v.findViewById(R.id.nogor);
        CardView btn5 = v.findViewById(R.id.krishiprojokti);
        CardView btn6 = v.findViewById(R.id.chasabad);
        CardView btn7 = v.findViewById(R.id.motsosompod);
        CardView btn8 = v.findViewById(R.id.pranisompod);
        CardView btn9 = v.findViewById(R.id.poka);
        CardView btn10 = v.findViewById(R.id.oddekta);
        CardView btn11 = v.findViewById(R.id.jogajog);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Krishitotho.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Chasabad.class);
              startActivity(intent);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChadKrishi.class);
                startActivity(intent);
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PraniSompod.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MotsoSompod.class);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PokaMakor.class);
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Video.class);
                startActivity(intent);

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KrishiOdekta.class);
                startActivity(intent);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Member.class);
                startActivity(intent);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intent = new Intent(getActivity(), Poramorsho.class);
               // startActivity(intent);

                Toast.makeText(getActivity(), "Coming Soon", Toast.LENGTH_LONG).show();

            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Coming Soon", Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(getActivity(), Contact.class);
               //  startActivity(intent);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Coming Soon", Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(getActivity(), KrishiPonno.class);
                // startActivity(intent);
            }
        });


        return v;

    }

}
