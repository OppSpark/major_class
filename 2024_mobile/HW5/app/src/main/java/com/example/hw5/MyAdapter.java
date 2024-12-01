package com.example.hw5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    String[] data1;
    LayoutInflater inflater;
    public MyAdapter(Context context, String[] data1) {

        this.inflater=LayoutInflater.from(context);
        this.data1=data1;
    }
    @Override public int getCount() { return data1.length; }
    @Override public Object getItem(int position) { return data1[position]; }
    @Override public long getItemId(int position) { return position; }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) convertView = inflater.inflate(R.layout.listitem, parent, false);
        TextView textview1=convertView.findViewById(R.id.listitem_text1);
        textview1.setText(data1[position]);
        return convertView;
    }
}