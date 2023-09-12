package com.soapgu.mybroadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String broadcastName = "com.soapgu.intent.broadcast.test";
    private int count;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.findViewById(R.id.btn_send).setOnClickListener( v ->{
            sendBroadcast( String.format("count %d",count ),false );
            count ++;
        });
    }

    private void sendBroadcast( String data, boolean isLocal ){
        Intent intent = new Intent();
        intent.setAction(broadcastName);
        intent.putExtra( "data", data);
        //intent.setPackage(this.getPackageName());
        intent.setComponent( new ComponentName(this, MyBroadcastReceiver.class));
        if( isLocal ){
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
        } else {
            sendBroadcast(intent);
        }
    }
}