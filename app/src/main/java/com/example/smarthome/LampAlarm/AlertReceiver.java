package com.example.smarthome.LampAlarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("SAMPE?","IYA");
        DatabaseReference lampuUtama;
        lampuUtama = FirebaseDatabase.getInstance().getReference().child("lampuUtama");
        String kondisi = intent.getStringExtra("kondisi");
        lampuUtama.setValue(kondisi);
        Toast.makeText(context, kondisi, Toast.LENGTH_SHORT).show();
        Log.d("SAMPE?",kondisi);

        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());
    }
}
