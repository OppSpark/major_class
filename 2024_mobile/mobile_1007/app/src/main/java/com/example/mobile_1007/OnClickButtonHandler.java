package com.example.mobile_1007;

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