package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listview1 extends AppCompatActivity {

    String [] abc = {"milk" , "c2" , "organge" ,"tra xanh" , "tra sua","trà đào"};
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview1);

        addViews();

        addEvents();
    }

    private void addEvents() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(listview1.this, abc[i],Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addViews() {
        listView = findViewById(R.id.lv1);
        arrayAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1, abc);
        listView.setAdapter(arrayAdapter);
    }
}
