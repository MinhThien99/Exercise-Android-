package com.example.testapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1 , b2;
    TextView tv1;
    EditText ed1, ed2;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button2);
        b2 =(Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        tv1 =(TextView)findViewById(R.id.textView4);
        tv1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("ThuyLinh") && ed2.getText().toString().equals("emgaicute")){
                    //Toast.makeText(getApplicationContext() ,  "Redirecting..." , Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext() ,  "WrongCredenntials..." , Toast.LENGTH_SHORT).show();
                    tv1.setVisibility(View.VISIBLE);
                    tv1.setBackgroundColor(Color.GRAY);
                    counter --;
                    tv1.setText(Integer.toString(counter));

                    if(counter == 0){
                        b1.setEnabled(false);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}
