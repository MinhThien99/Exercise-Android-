package com.example.aplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class sharepreferencesDemo extends AppCompatActivity {

    String preferenName = "Thien Đẹp Trai";
    TextView txtshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepreferences_demo);

        txtshow = findViewById(R.id.txtshow);

    }

    public void Save(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(preferenName , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("int", 8);
        editor.putBoolean("boolean " , true);
        editor.putFloat("float" , 9.9f);
        editor.putLong("long" , 99);
        editor.putString("CọpCon" , "I Love You");

        Set<String> ds = new HashSet<>();
        ds.add("Thiên");
        ds.add("Thật");
        ds.add("Giỏi");
        ds.add("Quá");
        ds.add("Mà");

        editor.putStringSet("ThienSet :" , ds);

        editor.apply();


    }

    public void Load(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(preferenName , MODE_PRIVATE);
        int i = sharedPreferences.getInt("int", 0);
        Boolean b = sharedPreferences.getBoolean("boolean" , false);
        Float f = sharedPreferences.getFloat("float" , 0.0f);
        long l = sharedPreferences.getLong("long" , 0);
        String s = sharedPreferences.getString("CọpCon", "");

        Set<String> ds = sharedPreferences.getStringSet("ThienSet " , null);

        txtshow.setText("");
        txtshow.append("i =" + i +"\n");
        txtshow.append("b =" + b +"\n");
        txtshow.append("f =" + f +"\n");
        txtshow.append("l =" + l +"\n");
        txtshow.append("s =" + s +"\n");

        txtshow.append("String Set =" +"\n");
        StringBuilder builder = new StringBuilder();
        for(String k : ds){
            builder.append(k).append(" ");
        }
        txtshow.append(builder.toString());

    }
}
