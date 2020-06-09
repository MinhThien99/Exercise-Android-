package com.example.baiandroidsukien;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class toastlayout extends AppCompatActivity {

    Button btnshow1 , btnshow2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toastlayout);

        btnshow1 = findViewById(R.id.button);
        btnshow2 = findViewById(R.id.button2);

        btnshow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Toast.makeText(toastlayout.this, "Tran Minh Thien" , Toast.LENGTH_SHORT).show();
            }
        });

        btnshow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.customtoast , (ViewGroup) findViewById(R.id.toastcustomtest));

                TextView text = layout.findViewById(R.id.txttoast) ;
                text.setText("Tran Minh Thien");

                Toast t = new Toast(getApplicationContext());
                t.setGravity(Gravity.CENTER ,0 ,30);
                t.setDuration(Toast.LENGTH_LONG);

                t.setView(layout);
                t.show();
            }
        });

    }

    public void showdialog(View view) {

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(toastlayout.this);
        builder.setTitle("Xac Nhan Thoat");
        builder.setMessage("Ban co chac muon thoat ung dung");
        builder.setIcon(R.drawable.androidicon);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
         */

        final Dialog dialog = new Dialog(toastlayout.this);
        dialog.setContentView(R.layout.customdialog);
        dialog.setCanceledOnTouchOutside(false);

        ImageView imgok = dialog.findViewById(R.id.imgyes);
        ImageView imgcance = dialog.findViewById(R.id.imgno);

        imgok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgcance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}
