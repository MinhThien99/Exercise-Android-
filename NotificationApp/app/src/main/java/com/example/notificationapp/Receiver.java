package com.example.notificationapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;

import androidx.core.app.RemoteInput;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle remoteinput = RemoteInput.getResultsFromIntent(intent);

        if(remoteinput != null ){
            CharSequence replyText = remoteinput.getCharSequence("Key_Text_Reply");
            messenger answer = new messenger(replyText, null);
            Main2Activity.MESSENGER.add(answer);

            Main2Activity.messengerNotification(context);

        }
    }
}
