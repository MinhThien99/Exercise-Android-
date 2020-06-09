package com.example.listviewhigh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.adapter.MyAdapter;
import com.example.model.items;

import java.util.ArrayList;

public class gridview extends AppCompatActivity {

    GridView gridView;
//    ArrayAdapter<String> arrayAdapter;
    ArrayList birdList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        /*
        ArrayList<String> dsSP= new ArrayList<>();

        dsSP.add("May Anh"); dsSP.add("Laptop") ; dsSP.add("Dien Thoai") ;
        dsSP.add("Sac Du Phong") ; dsSP.add("O Cung Di Dong") ;

        gridView = findViewById(R.id.gridview1);

        arrayAdapter = new ArrayAdapter<String>(gridview.this , android.R.layout.simple_list_item_1);
        arrayAdapter.addAll(dsSP);

        gridView.setAdapter(arrayAdapter);

         */
        gridView = findViewById(R.id.gridview1);

        birdList.add(new items("Bird 1",R.drawable.b1));
        birdList.add(new items("Bird 2",R.drawable.b2));
        birdList.add(new items("Bird 3",R.drawable.b3));
        birdList.add(new items("Bird 4",R.drawable.b4));
        birdList.add(new items("Bird 5",R.drawable.b5));
        birdList.add(new items("Bird 6",R.drawable.b6));

        final MyAdapter myAdapter=new MyAdapter(this,R.layout.layoutcustom,birdList);
        gridView.setAdapter(myAdapter);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(gridview.this, showImage.class);
                intent.putExtra("image" ,myAdapter.getPosition(position) );
                startActivity(intent);
            }
        });

    }
}
