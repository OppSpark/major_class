package com.example.mobile_1028;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView textview_display;
    private Button confirm_button, reset_button;
    private CheckBox checkbox_en, checkbox_cn, checkbox_lock;
    private RadioButton radiobutton_kr, radiobutton_fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview_display = findViewById(R.id.textview_display);
        checkbox_cn = findViewById(R.id.checkbox_cn);
        checkbox_en = findViewById(R.id.checkbox_en);
        radiobutton_kr = findViewById(R.id.radiobutton_kr);
        radiobutton_fr = findViewById(R.id.radiobutton_fr);
        confirm_button = findViewById(R.id.confirm_button);
        reset_button = findViewById(R.id.reset_button);
        checkbox_lock = findViewById(R.id.checkbox_lock);

        confirm_button.setOnClickListener(v -> {
            confirmJobButtonHandler();
        });

        reset_button.setOnClickListener(v -> {
            resetJobButtonHandler();
        });

        checkbox_lock.setOnCheckedChangeListener((buttonView, isChecked) -> {
            lockJobViewHandler(isChecked);
        });

    }

    private void confirmJobButtonHandler(){
        String result = "";

        result+=("영어 회화 가능 여부: "+checkbox_en.isChecked()+"\n");
        result+=("중국어 회화 가능 여부: "+checkbox_cn.isChecked()+"\n");
        result+=("한국인: "+radiobutton_kr.isChecked()+"\n");
        result+=("외국인: "+radiobutton_fr.isChecked()+"\n");

        textview_display.setText(result);
    }

    private void resetJobButtonHandler() {
        textview_display.setText("");
        checkbox_en.setChecked(false);
        checkbox_cn.setChecked(false);
        radiobutton_kr.setChecked(false);
        radiobutton_fr.setChecked(false);
    }

    private void lockJobViewHandler(boolean isChecked){
        checkbox_en.setEnabled(!isChecked);
        checkbox_cn.setEnabled(!isChecked);
        radiobutton_kr.setEnabled(!isChecked);
        radiobutton_fr.setEnabled(!isChecked);
        confirm_button.setEnabled(!isChecked);
        reset_button.setEnabled(!isChecked);
        textview_display.setEnabled(!isChecked);
    }
}