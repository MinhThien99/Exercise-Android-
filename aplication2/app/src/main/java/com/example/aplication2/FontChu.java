package com.example.aplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FontChu extends AppCompatActivity {

    TextView textView;
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font_chu);
        textView = findViewById(R.id.txttitle);
        listView = findViewById(R.id.lstshow);
        adapter = new ArrayAdapter<>(FontChu.this , android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        try{
            AssetManager assetManager= getAssets();
            String[] font = assetManager.list("Fort");
            adapter.addAll(font);

        }catch (Exception e){
            Log.e("error:" , e.toString());
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "Fort/" + adapter.getItem(position));
                textView.setTypeface(typeface);
                playAudio();
            }
        });

    }

    private void playAudio() {

        try {
            AssetFileDescriptor descriptor = getAssets().openFd("audio/tingting.mp3");
            MediaPlayer player = new MediaPlayer();

            player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            player.prepare();
            player.start();

        }catch (Exception e){
            Log.e("error:" , e.toString());
        }
    }
}
