package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SaveInstanceActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText firstnumber ;
    private EditText secondnumber;
    private TextView tvresult;
    private Button bttinh,btn1 , btn2;
    private RadioButton rb;
    private RadioGroup rg;
    private int nbfirst , nbsecond , result;
    int selectionID;

    @Override
    protected void onCreate(@Nullable Bundle save){
        super.onCreate(save);
        setContentView(R.layout.activity_main);

        firstnumber = (EditText) findViewById(R.id.edtext1);
        secondnumber = (EditText) findViewById(R.id.edtext2);
        tvresult = (TextView) findViewById(R.id.tvresult);
        bttinh =(Button) findViewById(R.id.button3);
        btn1 = (Button)findViewById(R.id.button) ;
        btn2 = findViewById(R.id.btnnua);
        rg = (RadioGroup)findViewById(R.id.radiogroup);

        if(save != null ){
            firstnumber.setText(String.valueOf(save.getInt("SoThuNhat")));
            secondnumber.setText(String.valueOf(save.getInt("SoThuHai")));
            tvresult.setText(String.valueOf(save.getInt("KetQua")));

        }

        bttinh.setOnClickListener(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , Main2Activity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , Main3Activity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onClick(View v) {

        selectionID = rg.getCheckedRadioButtonId();


        if(v == bttinh) {
            if (firstnumber.getText().toString().isEmpty() || secondnumber.getText().toString().isEmpty()) {
                Toast.makeText(this, "Input Number , please", Toast.LENGTH_SHORT).show();
            } else {
                switch(selectionID){
                    case R.id.rbcong:
                        nbfirst = Integer.parseInt(firstnumber.getText().toString());
                        nbsecond = Integer.parseInt(secondnumber.getText().toString());

                        result = nbfirst + nbsecond;
                        tvresult.setText(String.valueOf(result));
                        break;
                    case R.id.rbtru:
                        nbfirst = Integer.parseInt(firstnumber.getText().toString());
                        nbsecond = Integer.parseInt(secondnumber.getText().toString());

                        result = nbfirst - nbsecond;
                        tvresult.setText(String.valueOf(result));
                        break;
                    case R.id.rbnhan:
                        nbfirst = Integer.parseInt(firstnumber.getText().toString());
                        nbsecond = Integer.parseInt(secondnumber.getText().toString());

                        result = nbfirst * nbsecond;
                        tvresult.setText(String.valueOf(result));
                        break;
                    case R.id.rbchia:
                        nbfirst = Integer.parseInt(firstnumber.getText().toString());
                        nbsecond = Integer.parseInt(secondnumber.getText().toString());

                        result = nbfirst / nbsecond;
                        tvresult.setText(String.valueOf(result));
                        break;
                }
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle save) {

        super.onSaveInstanceState(save);

        if(!tvresult.getText().toString().isEmpty()){
            save.putInt("SoThuNhat", Integer.parseInt(firstnumber.getText().toString()));
            save.putInt("SoThuHai", Integer.parseInt(secondnumber.getText().toString()));
            save.putInt("KetQua", Integer.parseInt(tvresult.getText().toString()));
        }
    }
}







