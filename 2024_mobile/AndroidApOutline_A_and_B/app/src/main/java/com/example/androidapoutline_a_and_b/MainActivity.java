package com.example.androidapoutline_a_and_b;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String name = "홍길동";
    private String pgm ="JAVA(중), Python(상)";
    private String country = "한국";

    private String number = "admin@adnin.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = new LinearLayout(this);

        TextView nameTv = new TextView(this);
        TextView pgmTv = new TextView(this);
        TextView countryTv = new TextView(this);
        TextView phoneTv = new TextView(this);

        linearLayout.setOrientation(LinearLayout.VERTICAL);

        nameTv.setText("이름 : "+name);
        pgmTv.setText("프로그래밍 능력 : " + pgm);
        countryTv.setText("국적 : " + country);
        phoneTv.setText("연락처 : " + number);

        linearLayout.addView(nameTv);
        linearLayout.addView(pgmTv);
        linearLayout.addView(countryTv);
        linearLayout.addView(phoneTv);

        setContentView(linearLayout);

    }
}