package com.example.baitapandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChuyenLichAndroid extends AppCompatActivity {

    Button btnchange ;
    EditText edtduong;
    TextView txtam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnchange =(Button)findViewById(R.id.btnchange);

        edtduong = (EditText)findViewById(R.id.edtduong);
        txtam =(TextView)findViewById(R.id.txtam);

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtduong.getText().toString());
                String kq = "";
                int can = (a % 10);
                int chi = (a % 12);

                switch (can){
                    case 0:
                        kq = "Canh";
                        break;
                    case 1:
                        kq = "Tan";
                        break;
                    case 2:
                        kq = "Nhâm";
                        break;
                    case 3:
                        kq = "Quý";
                        break;
                    case 4:
                        kq = "Giáp";
                        break;
                    case 5:
                        kq = "Ất";
                        break;
                    case 6:
                        kq = "Bính";
                        break;
                    case 7:
                        kq = "Đinh";
                        break;
                    case 8:
                        kq = "Mậu";
                        break;
                    case 9:
                        kq = "Kỷ";
                        break;
                    default:break;
                }

                switch (chi){
                    case 0:
                        kq += " Thân";
                        break;
                    case 1:
                        kq += " Dậu";
                        break;
                    case 2:
                        kq += " Tất";
                        break;
                    case 3:
                        kq += " Hợi";
                        break;
                    case 4:
                        kq += " Tý";
                        break;
                    case 5:
                        kq += " Sửu";
                        break;
                    case 6:
                        kq += " Dần";
                        break;
                    case 7:
                        kq += " Mẹo";
                        break;
                    case 8:
                        kq += " Thìn";
                        break;
                    case 9:
                        kq += " Tỵ";
                        break;
                    case 10:
                        kq += " Ngọ";
                        break;
                    case 11:
                        kq += " Mùi";
                        break;

                    default:break;
                }

                txtam.setText("Kết quả là: " + kq);
            }
        });


    }
}
