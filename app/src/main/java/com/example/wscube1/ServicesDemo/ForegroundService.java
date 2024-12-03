//package com.example.wscube1.ServicesDemo;
//
//import android.app.Notification;
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.Service;
//import android.content.Intent;
//import android.media.MediaPlayer;
//import android.os.IBinder;
//import android.provider.Settings;
//
//import androidx.annotation.Nullable;
//
//import com.example.wscube1.R;
//
//public class ForegroundService extends Service {
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        MediaPlayer player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
//        player.setLooping(true);
//        player.start();
//
//        final String CHANNELID = "Foreground Service ID";
//        NotificationChannel channel = new NotificationChannel(
//                CHANNELID,
//                CHANNELID,
//                NotificationManager.IMPORTANCE_LOW
//        );
//        getSystemService(NotificationManager.class).createNotificationChannel(channel);
//        Notification.Builder notification = new Notification.Builder(this,CHANNELID).setContentText("Service is Running")
//                .setContentTitle("Service Enabled")
//                .setSmallIcon(R.drawable.download);
////        startForeground(1001,notification.build());
//        return super.onStartCommand(intent,flags,startId);
//    }
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//}
