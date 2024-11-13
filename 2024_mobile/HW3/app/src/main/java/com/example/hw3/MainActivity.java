package com.example.hw3;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String[] city = { "홍콩 역", "완차이 역", "애드미럴티 역", "침사추이 역", "몽콕 역" };

    StringBuilder sb = new StringBuilder();
    Spinner spinnerSelectCity;
    EditText EditTextPeoples;
    RadioButton radioButtonEconomy, radioButtonBusiness;
    CheckBox checkBoxWindowSeats, checkBoxAisleSeats;
    TextView textViewResult;
    Button buttonSummit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinnerSelectCity = findViewById(R.id.spinnerSelectCity);
        EditTextPeoples = findViewById(R.id.EditTextPeoples);
        radioButtonEconomy = findViewById(R.id.radioButtonEconomy);
        radioButtonBusiness = findViewById(R.id.radioButtonBusiness);
        checkBoxWindowSeats = findViewById(R.id.checkBoxWindowSeats);
        checkBoxAisleSeats = findViewById(R.id.checkBoxAisleSeats);
        buttonSummit = findViewById(R.id.buttonSummit);
        textViewResult = findViewById(R.id.textViewResult);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, city);
        spinnerSelectCity.setAdapter(arrayAdapter);

        spinnerSelectCity.setOnItemSelectedListener(onItemSelectedListener);
        EditTextPeoples.addTextChangedListener(new PeopleTextWatcher());

        radioButtonEconomy.setOnCheckedChangeListener(onCheckedChangeListener);
        radioButtonBusiness.setOnCheckedChangeListener(onCheckedChangeListener);
        checkBoxWindowSeats.setOnCheckedChangeListener(onCheckedChangeListener);
        checkBoxAisleSeats.setOnCheckedChangeListener(onCheckedChangeListener);

        buttonSummit.setOnClickListener(v -> onClickButtonSummit());
    }

    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            updateResult();
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

    private class PeopleTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            updateResult();
        }
    }

    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            updateResult();
        }
    };

    private void updateResult() {
        sb.setLength(0);

        String citySelected = spinnerSelectCity.getSelectedItem().toString();
        sb.append("목적지: ").append(citySelected).append("\n");

        String peopleCount = EditTextPeoples.getText().toString();
        if (peopleCount.isEmpty()) {
            sb.append("승차인원: 0 (명)\n");
        } else {
            sb.append("승차인원: ").append(peopleCount).append("(명)\n");
        }

        if (radioButtonEconomy.isChecked()) {
            sb.append("좌석: 일반실\n");
        } else if (radioButtonBusiness.isChecked()) {
            sb.append("좌석: 특실\n");
        }

        if (checkBoxWindowSeats.isChecked()) {
            sb.append("창측 선호\n");
        }
        if (checkBoxAisleSeats.isChecked()) {
            sb.append("복도 선호\n");
        }
        textViewResult.setText(sb.toString().trim());
    }

    private void onClickButtonSummit() {
        String resultText = textViewResult.getText().toString();
        Toast.makeText(this, resultText, Toast.LENGTH_SHORT).show();
    }
}