package com.example.baiandroidsukien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnshow ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnshow = findViewById(R.id.btnshow);


    }

    public void XuLy(View view) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView textView = new TextView(this);
        textView.setTextSize(24);
        textView.setText("I am Tran Minh Thien");

        Button btntest = new androidx.appcompat.widget.AppCompatButton(this){
            @Override
            public boolean performClick() {

                Toast.makeText(getApplicationContext(),"thong bao",Toast.LENGTH_SHORT).show();

                //setContentView(R.layout.activity_main);

                return super.performClick();
            }
        };
        btntest.setText("Back");
        btntest.setLayoutParams(layoutParams);

        linearLayout.addView(btntest);
        linearLayout.addView(textView);
        setContentView(linearLayout);
    }
}
