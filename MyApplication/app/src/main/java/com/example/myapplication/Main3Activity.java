package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import model.sinhvien;

public class Main3Activity extends AppCompatActivity {

    TextView txtshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txtshow= findViewById(R.id.txtview);

        Intent intent = getIntent();
        int a = intent.getIntExtra("key",0);

        String key = intent.getStringExtra("a");
        String key1 = intent.getStringExtra("b");

        sinhvien sv = (sinhvien) intent.getSerializableExtra("tran minh thien");

        txtshow.append("a =" + a + "\n");
        txtshow.append("a =" + key1 + "\n");
        txtshow.append("a =" + key + "\n");
        txtshow.append("sv =" + sv + "\n");




    }
}
