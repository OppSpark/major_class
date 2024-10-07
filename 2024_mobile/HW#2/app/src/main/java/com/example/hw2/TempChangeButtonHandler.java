package com.example.hw2;

import android.widget.EditText;
import android.widget.TextView;

public class TempChangeButtonHandler {

    public void convertTemperature(EditText editText, TextView textView) {
        double temp = Double.parseDouble(editText.getText().toString());
        temp = (temp - 32) * (5.0 / 9);

        temp = Math.round(temp * 100) / 100.0;
        textView.setText("섭씨 " + temp + "(도)");

    }
}