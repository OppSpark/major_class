package com.example.studyonlyapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.util.Log;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textview);

        tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.textview)
            v.setBackgroundColor(Color.RED);
    }
}