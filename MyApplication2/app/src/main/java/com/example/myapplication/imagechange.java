package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class imagechange extends AppCompatActivity {

    Button  btclose;
    ImageView imageView;
    ImageButton imgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagechange);

        btclose = (Button)findViewById(R.id.btnclose);
        imgbtn = (ImageButton) findViewById(R.id.imgbtnchange);
        imageView = (ImageView)findViewById(R.id.imageView);

        btclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView.getTag() == null || imageView.getTag().equals("androidicon")){
                    imageView.setImageResource(R.drawable.appleicon);
                    imageView.setTag("appleicon");
                }
                else if(imageView.getTag().equals("appleicon")){
                    imageView.setImageDrawable(getResources().getDrawable(R.drawable.androidicon));
                    imageView.setTag("androidicon");
                }
            }
        });

    }
}
