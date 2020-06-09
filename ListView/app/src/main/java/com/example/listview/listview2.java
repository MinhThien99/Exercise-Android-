package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listview2 extends AppCompatActivity {

    String [] eat ;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview2);

        listView = findViewById(R.id.lv2);
        eat = getResources().getStringArray(R.array.eat);
        arrayAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1, eat);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(listview2.this, eat[i],Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
