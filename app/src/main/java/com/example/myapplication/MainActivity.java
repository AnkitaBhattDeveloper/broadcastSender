package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AppComponentFactory;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.channels.InterruptedByTimeoutException;

public class MainActivity extends AppCompatActivity {
MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
private TextView textView;
private Button button;

//  Anonymous inner class
private BroadcastReceiver minnerreceiver = new BroadcastReceiver(){

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("com.example.broadcastreceiver.ACTION_SEND".equals(intent.getAction()))
        {
            String intentExtra = intent.getStringExtra("com.example.EXTRA_DATA");

            textView.setText("inner broadcast received "+intentExtra);
        }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
         button = findViewById(R.id.button);
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(myBroadcastReceiver,intentFilter);
    }

    public void sendBroadcast(View view){
        Intent intent = new Intent("com.example.broadcastreceiver.ACTION_SEND");
        intent.putExtra("com.example.EXTRA_DATA","Hello from sender app");
        sendBroadcast(intent);


    }



    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("com.example.broadcastreceiver.ACTION_SEND");
        registerReceiver(minnerreceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(minnerreceiver);
    }
}