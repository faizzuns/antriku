package com.example.user.qroom.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.user.qroom.R;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by denail on 17/08/13.
 */

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        showNotification(
                remoteMessage.getData().get("antrian_numb"),
                remoteMessage.getData().get("antrian_code")
        );
    }

    private void showNotification(String antrianNumb, String antrianCode) {
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Uri notifSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        String message = "Nomor Antrian: " + antrianNumb + " | Kode Antrian: " + antrianCode;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("My App")
                .setContentText(message)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(icon);

        Notification notification = builder.build();

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.bigText(message)
                .setBigContentTitle("Queue Reserved")
                .setSummaryText("FROM: Server");

        builder.setStyle(bigText);
        builder.setSound(notifSound);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}
