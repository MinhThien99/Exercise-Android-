package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import model.sinhvien;

public class Main2Activity extends AppCompatActivity {

    CheckBox checkBox1 , checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);

    }
    public void checkRequest(View v){

        String abc = checkBox1.getText().toString();

        Intent intent = new Intent(this, Main3Activity.class);

        intent.putExtra("key" ,"123" );

        intent.putExtra("a" , "Bạn có khỏe không");

        intent.putExtra("b" , abc);

        sinhvien sv = new sinhvien(1,"tran minh thien","123456" );

        intent.putExtra("name" , sv);


        startActivity(intent);
    }

    public void checkRequestbundle(View view) {

        Intent intent = new Intent(this, Main4Activity.class);

        Bundle bundle = new Bundle();
        bundle.putInt("a", 8);
        bundle.putDouble("b",9.8);
        bundle.putBoolean("c", false);

        sinhvien sv = new sinhvien(2, "Minh Thien","123456");
        bundle.putSerializable("e", sv);

        intent.putExtra("1", bundle);

        startActivity(intent);

    }
}
