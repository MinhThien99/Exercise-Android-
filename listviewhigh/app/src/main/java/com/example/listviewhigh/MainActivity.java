package com.example.listviewhigh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.sanphamadapter;
import com.example.model.sanpham;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstsanpham;
    TextView txtten,txtgia;
    sanphamadapter sp;
    View loadmoreView;
    boolean isloading = false;
    myHandler handlerlove;
    String [] abc = {"milk" , "c2" , "organge" ,"tra xanh" , "tra sua","trà đào"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstsanpham = findViewById(R.id.lvhigh);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        loadmoreView = layoutInflater.inflate(R.layout.load_more, null);

        txtgia= findViewById(R.id.txtgia);
        txtten= findViewById(R.id.txtten);
        //sp= new sanphamadapter(this , R.layout.item);

        // addViews();


        ArrayList<sanpham> arrayList = new ArrayList<>();

        sanpham sp2 = new sanpham(R.drawable.dog, "Dog", 800);
        sanpham sp3 = new sanpham(R.drawable.tigericon, "Tiger", 300);


        arrayList.add(sp2);
        arrayList.add(sp3);

        sp = new sanphamadapter(MainActivity.this, R.layout.item, arrayList);

        lstsanpham.setAdapter(sp);

        //addEvents();
    }


    public void LoaddingNewItems(ArrayList<sanpham> newItems){
        sp.addAll(newItems);
    }

    public class myHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0:
                    lstsanpham.addFooterView(loadmoreView);
                    break;
                case 1:
                    lstsanpham.removeFooterView(loadmoreView);
                    LoaddingNewItems((ArrayList<sanpham>) msg.obj);
                    isloading = false;
                    break;
            }
        }
    }

    public class ThreadData extends Thread{
        @Override
        public void run() {
            handlerlove.sendEmptyMessage(0);
            ArrayList<sanpham> data = getmoredata();
            try{
                SystemClock.sleep(3000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            Message message = handlerlove.obtainMessage(1,data);
            handlerlove.sendMessage(message);
        }
    }

    public ArrayList<sanpham> getmoredata() {
        ArrayList<sanpham> ds = new ArrayList<>();
        ds.add(new sanpham(R.drawable.dog, "Dog", 800));
        ds.add(new sanpham(R.drawable.tigericon, "Tiger", 300));

        return ds;
    }

    private void addEvents() {
        lstsanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sanpham sanpham = sp.getItem(position);
                Toast.makeText(MainActivity.this, sanpham.getTen(), Toast.LENGTH_SHORT).show();
            }
        });

        lstsanpham.setOnScrollListener(new AbsListView.OnScrollListener(){

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(view.getLastVisiblePosition() == totalItemCount - 1 && !isloading){
                    isloading= true;
                    Thread thread = new ThreadData();
                    thread.start();
                }

            }
        });
    }

/*

    private void addViews() {
        lvSanPham = findViewById(R.id.lvhigh);
        sp = new sanphamadapter(MainActivity.this, R.layout.item);
        sp.add(new sanpham(R.drawable.cat, "Cat", 100));
        sp.add(new sanpham(R.drawable.dog, "Dog", 800));
        sp.add(new sanpham(R.drawable.tigericon, "Tiger", 300));
        lvSanPham.setAdapter(sp);
    }

 */

}
