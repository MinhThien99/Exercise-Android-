package example.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bailist2.R;

public class SanPhamAdapter extends ArrayAdapter<sanpham> {
    public SanPhamAdapter(@NonNull Activity context, int resource) {
        super(context, resource);
        this.myContext= context;
        this.resource=resource;
    }
    Activity myContext;
    int resource;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.myContext.getLayoutInflater();
        View customView=inflater.inflate(this.resource,null);
        sanpham sp= getItem(position);
        TextView txTenSP=customView.findViewById(R.id.textView);
        txTenSP.setText(sp.getTenSp());

        TextView txGia=customView.findViewById(R.id.textView2);
        txGia.setText(sp.getGiaSp()+" VND");
           // dm code nhơ cc
        ImageView img =customView.findViewById(R.id.hinh);
        img.setImageResource(sp.getHinh());


        return customView;
    }
}
