package com.example.mobile_1015;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

            TextView tv = new TextView(this);
            tv.setText("helloWorld");
            tv.setGravity(Gravity.CENTER);
            setContentView(tv);

            View.OnClickListener listener = (v -> v.setBackgroundColor(Color.YELLOW));
            tv.setOnClickListener(listener);
    }
}