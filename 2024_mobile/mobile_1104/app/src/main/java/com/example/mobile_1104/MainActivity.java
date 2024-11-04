package com.example.mobile_1104;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textview);
        EditText editWidth = findViewById(R.id.EditWidth);
        EditText editHeight = findViewById(R.id.EditHeight);

        RadioButton white = findViewById(R.id.white);
        RadioButton red = findViewById(R.id.brown);
        RadioButton black = findViewById(R.id.black);

        CheckBox tools = findViewById(R.id.tools);
        Button summitButton = findViewById(R.id.summit);

        summitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int width = Integer.parseInt(editWidth.getText().toString());

                int height = Integer.parseInt(editHeight.getText().toString());
                String color = "";
                String tool = "";
                if (white.isChecked()) {
                    color = "화이트";
                } else if (red.isChecked()) {
                    color = "브라운";
                } else if (black.isChecked()) {
                    color = "블랙";
                }


                if(tools.isChecked()){
                    tool = "필요";
                }else{
                    tool = "불필요";
                }
                textView.setText("가로: " + width + " 세로: " + height + " 색상: " + color + " 추가 공구 필요: " + tool);
            }
        });
    }
}