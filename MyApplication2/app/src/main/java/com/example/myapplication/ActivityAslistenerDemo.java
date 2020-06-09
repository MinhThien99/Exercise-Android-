package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityAslistenerDemo extends AppCompatActivity  {

    Button btnios, btnandroid;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aslistener_demo);

        btnandroid =(Button)findViewById(R.id.btnandroid);
        btnios =(Button)findViewById(R.id.btnios);
        imageView = (ImageView)findViewById(R.id.imgicon);

        btnios.setOnClickListener(new myEvents());
        btnandroid.setOnClickListener(new myEvents());
        btnandroid.setOnLongClickListener(new myEvents());

    }
    class myEvents implements View.OnClickListener , View.OnLongClickListener {

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btnios){
                imageView.setImageResource(R.drawable.appleicon);
            }
            else if(v.getId() == R.id.btnandroid){
                imageView.setImageResource(R.drawable.androidicon);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if(v.equals(btnandroid)){
                imageView.setVisibility(v.INVISIBLE);
            }
            return false;
        }
    }

/*
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnios){
            imageView.setImageResource(R.drawable.appleicon);
        }
        else if(v.getId() == R.id.btnandroid){
            imageView.setImageResource(R.drawable.androidicon);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId() == R.id.btnandroid){
            imageView.setVisibility(v.INVISIBLE);
        }
        return false;
    }

 */
}
