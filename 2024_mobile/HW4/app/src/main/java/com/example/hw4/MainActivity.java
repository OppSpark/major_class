package com.example.hw4;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private RadioGroup mainRadioGroup, addressRadioGroup;
    private EditText emailInput;
    private View emailLayout, addressLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainRadioGroup = findViewById(R.id.mainRadioGroup);
        addressRadioGroup = findViewById(R.id.addressRadioGroup);
        emailLayout = findViewById(R.id.emailLayout);
        addressLayout = findViewById(R.id.addressLayout);
        emailInput = findViewById(R.id.emailInput);

        mainRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioEmail) {
                emailLayout.setVisibility(View.VISIBLE);
                addressLayout.setVisibility(View.GONE);
            } else if (checkedId == R.id.radioPost) {
                emailLayout.setVisibility(View.GONE);
                addressLayout.setVisibility(View.VISIBLE);
            }
        });
    }
}