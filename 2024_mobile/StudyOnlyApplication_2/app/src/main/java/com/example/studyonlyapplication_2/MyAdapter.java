package com.example.studyonlyapplication_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    String[] data1, data2;
    LayoutInflater inflater;
    public MyAdapter(Context context, String[] data1, String[] data2) {
        this.inflater=LayoutInflater.from(context);
        this.data1=data1;
        this.data2=data2;
    }
    @Override public int getCount() { return data1.length; }
    @Override public Object getItem(int position) { return data1[position]+", "+data2[position]; }
    @Override public long getItemId(int position) { return position; }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) convertView = inflater.inflate(R.layout.listitem, parent, false);
        TextView textview1=convertView.findViewById(R.id.listitem_text1);
        textview1.setText(data1[position]);
        TextView textview2=convertView.findViewById(R.id.listitem_text2);
        textview2.setText(data2[position]);
        return convertView;
    }
}