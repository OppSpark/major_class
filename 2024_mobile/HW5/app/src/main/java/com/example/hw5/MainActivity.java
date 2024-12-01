package com.example.hw5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    String data1[] = {"https://kdca.go.kr", "https://www.busan.go.kr", "https://www.gov.kr"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listview = new ListView(this);
        MyAdapter adapter = new MyAdapter(this, data1);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedUrl = (String) parent.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), selectedUrl + " 클릭", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(selectedUrl));
                startActivity(intent);
            }
        });

        setContentView(listview);
    }
}