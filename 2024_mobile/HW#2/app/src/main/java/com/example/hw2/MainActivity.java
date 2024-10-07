package com.example.hw2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TempChangeButtonHandler tempChangeButtonHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tempChangeButtonHandler = new TempChangeButtonHandler();

        EditText tempInputEditText = findViewById(R.id.tempInputEditText);
        Button tempConvertButton = findViewById(R.id.tempConvertButton);
        TextView tempTextView = findViewById(R.id.tempTextView);

        tempConvertButton.setOnClickListener(v -> {
            tempChangeButtonHandler.convertTemperature(tempInputEditText, tempTextView);
        });
    }
}