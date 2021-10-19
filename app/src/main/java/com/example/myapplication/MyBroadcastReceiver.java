package com.example.myapplication;

import static android.content.ContentValues.TAG;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
//            Toast.makeText(context, "Boot Completed", Toast.LENGTH_SHORT).show();
//        }
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction()))
        {
            boolean booleanExtra = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);
            Toast.makeText(context, "Connectivity Changed ", Toast.LENGTH_SHORT).show();
        if (!booleanExtra)
        {
            Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onReceive: connected");
        }
        else{
            Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onReceive: disconnected ");
        }}
        else if (Intent.ACTION_TIME_TICK.equals(intent.getAction()))
        {
            Toast.makeText(context, "time increased", Toast.LENGTH_SHORT).show();
        }
        }
    }

