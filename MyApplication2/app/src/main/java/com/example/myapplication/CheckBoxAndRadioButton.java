package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CheckBoxAndRadioButton extends AppCompatActivity {

    Button btnconf , btnconfvalue;
    android.widget.CheckBox chkfilm , chkclip, chkfpt;
    TextView txtketqua , txtvalueresult;
    RadioButton rbtntot , rbtnrattot , rbtnbinhthuong , rbtntuyetvoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        addView();

        btnconf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq ="";
                if(chkfilm.isChecked()) {
                    kq = chkfilm.getText().toString();
                }
                if(chkclip.isChecked()) {
                    kq += ", " + chkclip.getText().toString();
                }
                if(chkfpt.isChecked()) {
                    kq += ", " + chkfpt.getText().toString();
                }
                txtketqua.setText("Ban Chon La: "+kq);
            }
        });

        btnconfvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                if(rbtntot.isChecked()){
                    txtvalueresult.setText(rbtntot.getText().toString());
                }
                else if(rbtnrattot.isChecked()){
                    txtvalueresult.setText(rbtnrattot.getText().toString());
                }
                else if(rbtnbinhthuong.isChecked()){
                    txtvalueresult.setText(rbtnbinhthuong.getText().toString());
                }
                else if(rbtntuyetvoi.isChecked()){
                    txtvalueresult.setText(rbtntuyetvoi.getText().toString());
                }
                 */
                RadioGroup radioGroup;
                radioGroup = (RadioGroup)findViewById(R.id.radiogroupcheck);
                int id = radioGroup.getCheckedRadioButtonId();
                if(id>0){
                    RadioButton radioButton = findViewById(id);
                    txtvalueresult.setText(radioButton.getText().toString());
                }
            }
        });
    }

    private void addView(){
        btnconf = (Button)findViewById(R.id.btonconfirm);
        btnconfvalue = (Button)findViewById(R.id.btndanhgia);
        rbtntot =(RadioButton)findViewById(R.id.rbtTot);
        rbtnbinhthuong =(RadioButton)findViewById(R.id.rbtbthuong);
        rbtnrattot =(RadioButton)findViewById(R.id.rbtratTot);
        rbtntuyetvoi =(RadioButton)findViewById(R.id.rbttvoi);
        chkclip = findViewById(R.id.chkclip);
        chkfilm = findViewById(R.id.chkfilm);
        chkfpt = findViewById(R.id.chkFPT);
        txtketqua = (TextView)findViewById(R.id.txtresult);
        txtvalueresult=(TextView)findViewById(R.id.txtresultvalue);
    }
}
