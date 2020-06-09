package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.adapter.SanPhamAdapter;
import com.example.model.SanPham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }



    private void addViews() {
        recyclerView=findViewById(R.id.rcvBeer);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.HORIZONTAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        itemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<SanPham> dsSP = new ArrayList<>();
        dsSP.add(new SanPham(R.drawable.beer333,"Bia 333",15000));
        dsSP.add(new SanPham(R.drawable.heineken,"Bia Heniken",20000));
        dsSP.add(new SanPham(R.drawable.larue,"Bia Larue",10000));
        dsSP.add(new SanPham(R.drawable.saigon,"Bia Saigon",10000));
        dsSP.add(new SanPham(R.drawable.sapporo,"Bia Saporo",10000));
        dsSP.add(new SanPham(R.drawable.tiger,"Bia Tiget",15000));

        SanPhamAdapter sanPhamAdapter = new SanPhamAdapter(dsSP,getApplicationContext());
        recyclerView.setAdapter(sanPhamAdapter);

    }
    private void addEvents() {

    }

}
