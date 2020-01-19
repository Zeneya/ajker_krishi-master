package com.decoderssquad.ekrishisheba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.activity_my_list, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_my_list, null, true);

        TextView txtTitle = rowView.findViewById(R.id.item);
        ImageView imageView = rowView.findViewById(R.id.icon);


        txtTitle.setText(itemname[position]);
        //imageView.setImageResource(imgid[position]);
        imageView.setImageResource(R.drawable.iconajkerkrishilogo);

        return rowView;

    }
}