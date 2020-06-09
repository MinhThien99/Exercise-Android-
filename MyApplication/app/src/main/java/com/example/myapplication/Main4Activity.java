package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import model.sinhvien;

public class Main4Activity extends AppCompatActivity {

    TextView txthienthi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txthienthi = findViewById(R.id.txtview12);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("1");


        int key = intent.getIntExtra("a" , 0);
        double key1 = intent.getDoubleExtra("b" , 0.0);

        sinhvien e = (sinhvien) bundle.getSerializable("1");


        txthienthi.append("a =" +key + "\n");
        txthienthi.append("b =" + key1 + "\n");
        txthienthi.append("sv =" + e + "\n");

    }
}
