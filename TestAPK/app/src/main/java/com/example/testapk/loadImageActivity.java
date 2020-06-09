package com.example.testapk;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class loadImageActivity extends AppCompatActivity {

    Button b1 , b2;
    EditText e1, e2;
    ImageButton ib1 , ib2;
    ImageView image;

    int Request_code_camera = 123;
    int Request_code_folder = 456;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);

        //load anh len
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyen data imageview = byte[]
                BitmapDrawable bitmapDrawable = (BitmapDrawable) image.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100 ,bytearray);
                byte[] hinhanh = bytearray.toByteArray();

                Main2Activity.dataBase.InsertDoVat(
                        e1.getText().toString().trim(),
                        e2.getText().toString().trim(),
                        hinhanh
                );
                Toast.makeText(loadImageActivity.this ,"ADD IMAGES SUCCESS", Toast.LENGTH_LONG).show();
                startActivity(new Intent( loadImageActivity.this , Main2Activity.class));

            }
        });

        Anhxa();
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,Request_code_camera);
            }
        });

        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, Request_code_folder);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == Request_code_camera && resultCode == RESULT_OK && data != null){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            image.setImageBitmap(bitmap);
        }

        if(requestCode == Request_code_folder && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                image.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        super.onActivityResult(requestCode, resultCode, data);

    }

    private void Anhxa() {
        b1 = (Button)findViewById(R.id.buttonthem);
        b2 = (Button)findViewById(R.id.buttonhuy);
        e1 = (EditText)findViewById(R.id.editname);
        e2 = (EditText)findViewById(R.id.editmota);
        image = (ImageView)findViewById(R.id.imageView2);
        ib1 = (ImageButton)findViewById(R.id.imageButton);
        ib2 = (ImageButton)findViewById(R.id.imageButton2);

    }


}
