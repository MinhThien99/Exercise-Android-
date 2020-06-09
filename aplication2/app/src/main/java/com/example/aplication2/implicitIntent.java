package com.example.aplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class implicitIntent extends AppCompatActivity {

    EditText edtphone , edtsms;
    Button btndial , btncall , btnsms;
    Intent intent = null;
    ImageView imgicon;

    public static final int Request_code = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impcicit_intent);

        edtphone  = findViewById(R.id.txtphone);
        edtsms = findViewById(R.id.txtmessenger);

        imgicon = findViewById(R.id.imageView);

        btndial = findViewById(R.id.btndial);
        btncall = findViewById(R.id.btncall);
        btnsms = findViewById(R.id.btnSMS);

        addEvents();
    }

    private void addEvents() {

        btndial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xyLyDial();
            }
        });

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyCall();
            }
        });

        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLySMS();
            }
        });

        imgicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://khoahoc.tv/"));
                startActivity(intent);
            }
        });
    }

    private void xuLySMS() {
        SmsManager smsManager = SmsManager.getDefault();
        intent = new Intent("ACTION_MSG_SENT");

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this , 0, intent , 0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int kq = getResultCode();
                if(kq == Activity.RESULT_OK){
                    Toast.makeText(implicitIntent.this, "Đã gửi thành công ", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(implicitIntent.this, "Đã gửi thất bại ", Toast.LENGTH_LONG).show();
                }

            }
        }, new IntentFilter("ACTION_MSG_SENT"));

        smsManager.sendTextMessage(edtphone.getText().toString() , null , edtsms.getText().toString(), pendingIntent, null);

    }
/*
    private void xuLySMS() {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(
                edtphone.getText().toString(),null,
                edtsms.getText().toString(), null, null
        );
        Intent setSmsAppIntent =
                new Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT);
        setSmsAppIntent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME,
                getPackageName());
        startActivityForResult(setSmsAppIntent, Request_code);
    }

 */

    private void xuLyCall() {
        intent = new Intent(Intent.ACTION_CALL);
        Uri uri= Uri.parse("tel: " + edtphone.getText().toString());
        intent.setData(uri);
        startActivity(intent);
    }

    private void xyLyDial() {
        intent = new Intent(Intent.ACTION_DIAL);
        Uri uri= Uri.parse("tel: " + edtphone.getText().toString());
        intent.setData(uri);
        startActivity(intent);

    }
}
