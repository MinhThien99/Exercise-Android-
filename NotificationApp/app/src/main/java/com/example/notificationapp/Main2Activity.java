package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;
import android.widget.RemoteViews;

import java.util.ArrayList;
import java.util.List;

import static com.example.notificationapp.channel.myChannel1_ID;
import static com.example.notificationapp.channel.myChannel2_ID;
import static com.example.notificationapp.channel.myChannel_ID;
import static com.example.notificationapp.channel.myChannelcustom_ID;

public class Main2Activity extends AppCompatActivity  {

    EditText edt1title , edification;
    NotificationManagerCompat notificationCompat;


    static List<messenger> MESSENGER = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edt1title = findViewById(R.id.edtten);
        edification = findViewById(R.id.edtnotifi);

        notificationCompat = NotificationManagerCompat.from(this);



        MESSENGER.add(new messenger("Good morning !", "Linh"));
        MESSENGER.add(new messenger("Hello !", null));
        MESSENGER.add(new messenger("I love you !", "Linh"));

    }

    public void createNotification(View view){
        messengerNotification(this);
    }

    public static void messengerNotification(Context context) {

        Intent intent = new Intent(context , Main2Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context , 0 , intent, 0);

        //Intent receiver = new Intent(context , Receiver.class);
        //receiver.putExtra("NOTIFICATION" , edification.getText().toString());
        //PendingIntent actioning = PendingIntent.getBroadcast(context ,0 , receiver , PendingIntent.FLAG_UPDATE_CURRENT);

       // Bitmap mybitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dog);

        RemoteInput remoteInput = new RemoteInput.Builder( "Key_Text_Reply")
                .setLabel("your answer ...")
                .build();

        Intent relyintent;
        PendingIntent relypending = null;

        if(Build.VERSION.SDK_INT  >= Build.VERSION_CODES.N){
            relyintent = new Intent(context , Receiver.class);
            relypending = PendingIntent.getBroadcast(context , 0,relyintent, 0);
        }
        else {
            // start chat activity instead
            // cancel notification
        }

        NotificationCompat.Action relyaction = new NotificationCompat.Action.Builder(
                R.drawable.cat,
                "Reply",
                relypending
        ).addRemoteInput(remoteInput).build();
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle("Me");
        messagingStyle.setConversationTitle("Group Chat");

        for (messenger chatMessenger : MESSENGER){
            NotificationCompat.MessagingStyle.Message notificationMessage = new NotificationCompat.MessagingStyle.Message(
                    chatMessenger.getText(),
                    chatMessenger.getTimestamp(),
                    chatMessenger.getSender()
            );
            messagingStyle.addMessage(notificationMessage);
        }


        Notification notification = new NotificationCompat.Builder(context , myChannel_ID)
                .setSmallIcon(R.drawable.tesnoti)
               // .setContentTitle(edt1title.getText().toString())
               // .setContentText(edification.getText().toString())
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
            //    .setStyle(new NotificationCompat.BigPictureStyle()
             //       .bigPicture(mybitmap)
             //       .bigLargeIcon(null))
                .setStyle(messagingStyle)
                .setAutoCancel(true)
                .setColor(Color.GREEN)
                //.addAction(R.drawable.appnoti , "show" , actioning)
                //.setLargeIcon(mybitmap)
                .addAction(relyaction)
                .setColor(Color.BLUE)
                .build();
        NotificationManagerCompat notificationCompat = NotificationManagerCompat.from(context);
        notificationCompat.notify(1, notification);
    }

    public void createNotification2(View view) {
        final int progressMax = 100;
        final NotificationCompat.Builder notification = new NotificationCompat.Builder(this , myChannel1_ID)
                .setSmallIcon(R.drawable.appnoti)
                .setContentTitle("Download")
                .setContentText("Download in progress")
                .setColor(Color.BLUE)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setProgress(progressMax,0 ,false) // can change to True
                .setOngoing(true)
                .setOnlyAlertOnce(true);
//                .setStyle(new NotificationCompat.InboxStyle()
//                        .addLine("Line 1")
//                        .addLine("Line 2")
//                        .addLine("Line 3")
//                        .addLine("Line 4")
//                        .addLine("Line 5")
//                        .addLine("Line 6")
//               )
//                .setStyle(new NotificationCompat.BigTextStyle().bigText("ta la Minh thien , la sieu nhan cuong phong sieu nhan gao :))")
//                        .setBigContentTitle("big title")
//                        .setSummaryText("Android ... ")
//                )
//                .setStyle(new NotificationCompat.BigPictureStyle()
//                        .bigLargeIcon(null)
//                        .bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.cat))
//                )
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.cat))


        notificationCompat.notify(2, notification.build());

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                for(int progress = 0 ; progress <= progressMax ; progress += 10){
                    //if change to true , you must hide 2 next line
                    notification.setProgress(progressMax,progress,false);
                    notificationCompat.notify(2,notification.build());
                    //no effect finish when you download
                    SystemClock.sleep(1000);
                }
                notification.setContentText("Download finish")
                        .setProgress(0,0,false)
                        .setOngoing(false);
                notificationCompat.notify(2, notification.build());
            }
        }).start();
    }

    public void createNotification3(View view) {

        String title1 = "Title 1";
        String messenger1 = "Messenger 1";

        String title2 = "Title 2";
        String messenger2 = "Messenger 2";

        Notification notification2 = new NotificationCompat.Builder(this , myChannel2_ID)
                .setSmallIcon(R.drawable.cat)
                .setContentTitle(title2)
                .setContentText(messenger2)
                .setGroup("Example Group")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        Notification notification1 = new NotificationCompat.Builder(this , myChannel2_ID)
                .setSmallIcon(R.drawable.cat)
                .setContentTitle(title1)
                .setContentText(messenger1)
                .setGroup("Example Group")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();
        Notification summarynotification = new NotificationCompat.Builder(this , myChannel2_ID)
                .setSmallIcon(R.drawable.dog)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine(title2 + " " + messenger2)
                        .addLine(title1 + " " + messenger1)
                        .setBigContentTitle("2 new messenger")
                        .setSummaryText("MinhThien@example.com")
                )
                .setGroup("Example Group")
                .setGroupAlertBehavior(NotificationCompat.GROUP_ALERT_CHILDREN)
                .setGroupSummary(true)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        SystemClock.sleep(2000);
        notificationCompat.notify(3 , notification1);
        SystemClock.sleep(2000);
        notificationCompat.notify(4 , notification2);
        SystemClock.sleep(2000);
        notificationCompat.notify(5 , summarynotification);

    }

    public void createNotification4(View view) {

        RemoteViews collapsedView = new RemoteViews(getPackageName(), R.layout.notification_collased);
        RemoteViews expandedView = new RemoteViews(getPackageName() , R.layout.notification_expand);

        Intent intent = new Intent(this , NotificationReceiver.class);
        PendingIntent clickPending = PendingIntent.getBroadcast(this , 0 , intent , 0);

        collapsedView.setTextViewText(R.id.text_view_collapsed_1, "Hello , My name is Thien");
        expandedView.setImageViewResource(R.id.image_view_expanded,R.drawable.cat);
        expandedView.setOnClickPendingIntent(R.id.image_view_expanded, clickPending);

        Notification notification = new NotificationCompat.Builder(this , myChannelcustom_ID)
                .setSmallIcon(R.drawable.cat)
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(expandedView)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .build();


        notificationCompat.notify(7, notification);
    }
}
