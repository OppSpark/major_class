package com.example.studyonlyapplication_2;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    String data1[]={"한국","스페인","중국","일본","캐나다","독일","프랑스"};
    String data2[]={"Korea","Spain","China","Japan","Canada","Germany","France"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listview = new ListView(this);
        MyAdapter adapter=new MyAdapter(this, data1, data2);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String v= (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), v+" 클릭", Toast.LENGTH_SHORT).show();
            }
        });
        setContentView(listview);
    }
}