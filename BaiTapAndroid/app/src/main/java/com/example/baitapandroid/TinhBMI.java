package com.example.baitapandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class TinhBMI extends AppCompatActivity {

    EditText edtten , edtcao , edtnang, edtbmi , edtketqua;
    Button btntinh ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_b_m_i);

        edtbmi = findViewById(R.id.edtbmi);
        edtten = findViewById(R.id.edtten);
        edtcao = findViewById(R.id.edtcao);
        edtnang = findViewById(R.id.edtnang);
        edtketqua = findViewById(R.id.edtkqua);

        btntinh = findViewById(R.id.btntinhbmi);

        btntinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double H=Double.parseDouble(edtcao.getText()+"");
                double W=Double.parseDouble(edtnang.getText()+"");
                double BMI=W/Math.pow(H, 2);
                String chandoan="";
                if(BMI<18)
                {
                    chandoan="Bạn gầy";
                }
                else if(BMI<=24.9)
                {
                    chandoan="Bạn bình thường";
                }
                else if(BMI<=29.9)
                {
                    chandoan="Bạn béo phì độ 1";
                }
                else if(BMI<=34.9)
                {
                    chandoan="Bạn béo phì độ 2";
                }
                else
                {
                    chandoan="Bạn béo phì độ 3";
                }
                DecimalFormat dcf=new DecimalFormat("#.0");
                edtbmi.setText(dcf.format(BMI));
                edtketqua.setText(chandoan);
            }
        });


    }
}
