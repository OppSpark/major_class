package com.example.sample1week;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String str = "Mobile Programming";
    private float textSize = 33;
    private Random random = new Random();

    private int[] onChangeColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new int[]{r, g, b};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tv);

        textView.setText(str);
        textView.setTextSize(textSize);

        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int[] color = onChangeColor();
                textView.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
    }
}