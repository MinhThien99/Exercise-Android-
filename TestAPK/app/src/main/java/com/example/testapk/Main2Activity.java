package com.example.testapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button b1 ;
    public static DataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1 = (Button)findViewById(R.id.button);

        dataBase = new DataBase(this , "QuanLy.sqlite",null,1);
        dataBase.queryDatabase("CREATE TABLE IF NOT EXISTS DoVat(Id INTEGER PRIMARY KEY AUTOINCREMENT , Ten VARCHAR(150), MoTa VARCHAR(250) , Anh BLOB)");

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Main2Activity.this,loadImageActivity.class));
            }
        });
    }


}
