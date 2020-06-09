package com.example.bailist2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import example.model.SanPhamAdapter;
import example.model.sanpham;

public class MainActivity extends AppCompatActivity {
    ListView lvSanPham;
    SanPhamAdapter sanPhamAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }

    private void addEvents() {
      lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             sanpham sp=sanPhamAdapter.getItem(position);
              Toast.makeText(MainActivity.this,sp.getTenSp(),Toast.LENGTH_LONG).show();
          }
      });

    }

    private void addViews() {
        lvSanPham=findViewById(R.id.listview);
        sanPhamAdapter=new SanPhamAdapter(MainActivity.this,R.layout.listbia);
        sanPhamAdapter.add(new sanpham("BiaSG",30000,R.drawable.bia));
        sanPhamAdapter.add(new sanpham("BiaHN",30000,R.drawable.biahn));
        sanPhamAdapter.add(new sanpham("BiaTiger",30000,R.drawable.biasg));
        lvSanPham.setAdapter(sanPhamAdapter);

    }

}
