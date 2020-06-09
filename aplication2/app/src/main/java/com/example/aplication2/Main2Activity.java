package com.example.aplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    TextView txtnhan;
    Button btnnhan;
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtnhan = findViewById(R.id.txtsonhan);
        btnnhan = findViewById(R.id.btnnhan);
        intent = getIntent();

        txtnhan.setText(intent.getIntExtra("thien" , 0) + "");

        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhUocSo();
            }
        });

    }

    private void tinhUocSo() {
        int n = Integer.parseInt(txtnhan.getText().toString());
        ArrayList<Integer> ds = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                ds.add(i);
            }
        }

        intent.putExtra("dsUS", ds);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
