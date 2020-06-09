package com.example.aplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtresult;
    EditText txtso;
    Button btngui;
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtso = findViewById(R.id.txtso);
        txtresult = findViewById(R.id.txtketqua);
        btngui = findViewById(R.id.btngui);

        btngui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moManHinhTimUS();

            }
        });

    }
    private void moManHinhTimUS() {
        Intent intent = new Intent(this , Main2Activity.class);
        intent.putExtra("thien",Integer.parseInt( txtso.getText().toString()));
        startActivityForResult(intent, REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            ArrayList<Integer> ds = data.getIntegerArrayListExtra("dsUS" );
            txtresult.setText("");
            for (int i : ds){
                txtresult.append(i + "\n");
            }
        }
    }
}
