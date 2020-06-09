package com.example.notificationapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.os.Build;

public class channel extends Application {

    public static final String Group_ID = "group1";

    public static final String Group1_ID = "group2";

    public static final String myChannel_ID = "MyChannel";

    public static final String myChannel1_ID = "MyChannel1";

    public static final String myChannel2_ID = "MyChannel2";

    public static final String myChannelcustom_ID = "MyChannelCustom";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannelGroup group1 = new NotificationChannelGroup(
              Group_ID,"group1"
            );

            NotificationChannelGroup group2 = new NotificationChannelGroup(
                    Group1_ID,"group2"
            );

            NotificationChannel channel = new NotificationChannel(myChannel_ID,"My Channel", NotificationManager.IMPORTANCE_HIGH);

            NotificationChannel channel1 = new NotificationChannel(myChannel1_ID,"My Channel 1", NotificationManager.IMPORTANCE_LOW);

            NotificationChannel channel2 = new NotificationChannel(myChannel2_ID,"My Channel 2", NotificationManager.IMPORTANCE_LOW);

            NotificationChannel channelCustom = new NotificationChannel(myChannelcustom_ID,"MyChannel Custom", NotificationManager.IMPORTANCE_LOW);

            channel.setDescription("this is chanel 1");
            channel.setGroup(Group_ID);

            channel1.setDescription("this is chanel 1");
            channel1.setGroup(Group_ID);

            channel2.setDescription("this is chanel 2");
            channel2.setGroup(Group1_ID);


            NotificationManager manager = getSystemService(NotificationManager.class);

            manager.createNotificationChannelGroup(group1);
            manager.createNotificationChannelGroup(group2);

            manager.createNotificationChannel(channel);
            manager.createNotificationChannel(channelCustom);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }


}
