package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.SanPham;
import com.example.recyclerview.R;

import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.Viewholder> {
    ArrayList<SanPham> dsSP;
    Context context;

    public SanPhamAdapter(ArrayList<SanPham> dsSP, Context context) {
        this.dsSP = dsSP;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.custom_item,parent,false);
        return new Viewholder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.imgPhoto.setImageResource(dsSP.get(position).getHinh());
        holder.txtInfo.setText(
                dsSP.get(position).getTenSP()+" - "+
                        dsSP.get(position).getGia() +"VND"
        );
    }

    @Override
    public int getItemCount() {
        return dsSP.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView txtInfo;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            txtInfo = itemView.findViewById(R.id.txtInfo);
            
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RemoveItem(getAdapterPosition());
                    Toast.makeText(context,txtInfo.getText().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void RemoveItem(int pos) {
        dsSP.remove(pos);
        notifyItemRemoved(pos);
    }

}

