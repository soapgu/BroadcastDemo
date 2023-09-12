package com.soapgu.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String message = String.format( "receive broadcast data:%s from receiver", intent.getStringExtra("data"));
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
