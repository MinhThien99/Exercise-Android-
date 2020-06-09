package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button btsh , btcan;
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    int idnotify = 001;
    String str = "welcome , my name is Thien , i am a student in HCM university";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btsh = (Button)findViewById(R.id.show);
        btcan =(Button)findViewById(R.id.btcancel);

        btsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new NotificationCompat.Builder(getApplicationContext()).setSmallIcon(R.drawable.tesnoti).setContentTitle("My Notification").setContentText(str);

                notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(idnotify, builder.build());

                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("Content" , str);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext() , 0 , intent , PendingIntent.FLAG_CANCEL_CURRENT);
                //set content intent
                builder.setContentIntent(pendingIntent);
            }
        });

        btcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.cancel(idnotify);
            }
        });
    }
}
