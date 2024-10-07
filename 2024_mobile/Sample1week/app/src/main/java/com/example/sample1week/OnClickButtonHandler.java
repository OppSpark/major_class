package com.example.sample1week;

import android.view.View;
import android.widget.TextView;

public class OnClickButtonHandler implements View.OnClickListener {


    @Override
    public void onClick(View v) {
    }

    public int getOnClickButtonHandler(String textLength) {
        return textLength.length();
    }
}