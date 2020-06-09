package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.model.sanpham;

public class listview3 extends AppCompatActivity {

    Button btnadd;
    EditText edtmsp , edtten;
    ListView lstshow;
    ArrayAdapter<sanpham> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview3);

        btnadd = findViewById(R.id.bntadd);
        edtmsp = findViewById(R.id.edtMSP);
        edtten = findViewById(R.id.edtten);
        lstshow = findViewById(R.id.lv3);

        arrayAdapter= new ArrayAdapter<sanpham>(listview3.this, android.R.layout.simple_list_item_1);
        lstshow.setAdapter(arrayAdapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sanpham sp = new sanpham();
                sp.setColorsp(edtmsp.getText().toString());
                sp.setTensp(edtten.getText().toString());
                arrayAdapter.add(sp);
            }
        });

        lstshow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sanpham sp = arrayAdapter.getItem(position);
                edtmsp.setText(sp.getColorsp());
                edtten.setText(sp.getTensp());
            }
        });

        lstshow.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                sanpham sp = arrayAdapter.getItem(position);
                arrayAdapter.remove(sp);
                return false;
            }
        });

    }

}
