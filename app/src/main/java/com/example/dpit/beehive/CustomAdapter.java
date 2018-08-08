package com.example.dpit.beehive;


import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    private final List<Product> countryList;
    int image;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, List<Product> countryList, int image) {
        this.context = context;
        this.countryList = countryList;
        this.image = image;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview, null);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        icon.setImageResource(image);
        return view;
    }}