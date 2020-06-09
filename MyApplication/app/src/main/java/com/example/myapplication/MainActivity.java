package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    private static final String state ="Trang Thai :";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public void onPause(){
        super.onPause();
        Log.e(state , "onPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.e(state , "onResume");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.e(state , "onDestroy");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.e(state , "onStop");
    }

   @Override
   protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Log.e(state , "onRestoreInstanceState");
   }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Log.e(state ,"onSaveInstanceState");
    }


}











