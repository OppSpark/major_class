package com.example.mobile_1007;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    OnClickButtonHandler onClickButtonHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickButtonHandler = new OnClickButtonHandler();

        EditText editTexts = findViewById(R.id.lengthEditText);
        Button button = findViewById(R.id.lengthTextButton);
        TextView textView = findViewById(R.id.lengthTextView);

        EditText tempEditText = findViewById(R.id.tempText);
        Button tempButton = findViewById(R.id.tempTextButton);
        TextView tempTextView = findViewById(R.id.tempTextView);

        tempButton.setOnClickListener(v -> {
            if(tempEditText.getText().toString().equals("")){
                tempTextView.setText("온도를 입력해주세요.");
                return;
            }
            double temp = Double.parseDouble(tempEditText.getText().toString());
            temp = temp * 1.8 + 32;
            tempTextView.setText("화씨 온도는 " + temp + "입니다.");
        });

        button.setOnClickListener(v ->{
                String textLength = editTexts.getText().toString();
                int length = onClickButtonHandler.getOnClickButtonHandler(textLength);
                textView.setText("입력한 문자열의 길이는 " + length + "입니다.");
        });

    }
}