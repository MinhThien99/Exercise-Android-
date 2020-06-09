package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listviewhigh.MainActivity;
import com.example.listviewhigh.R;
import com.example.model.sanpham;

import java.util.ArrayList;
import java.util.List;

public class sanphamadapter extends ArrayAdapter<sanpham> {
    Activity context;
    int resource;
    private List<sanpham> arrsanpham;


    public sanphamadapter(@NonNull Context context, int resource , ArrayList<sanpham> arrsanpham) {
        super(context, resource);
        this.context = (Activity) context;
        this.resource = resource;
        this.arrsanpham = arrsanpham;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View customView = inflater.inflate(this.resource,null);

        ImageView imgHinh = customView.findViewById(R.id.imghinh);
        TextView txtten = customView.findViewById(R.id.txtten);
        TextView txtgia = convertView.findViewById(R.id.txtgia);

        sanpham sp = getItem(position);
        imgHinh.setImageResource(sp.getImageid());
        txtten.setText(sp.getTen());
        txtgia.setText(String.format("%.0f" ,sp.getGia() +"VND"));

        return customView ;
    }


}
