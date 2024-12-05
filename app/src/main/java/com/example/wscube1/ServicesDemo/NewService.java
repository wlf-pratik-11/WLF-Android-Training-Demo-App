package com.example.wscube1.ServicesDemo;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.example.wscube1.R;

public class NewService extends Service {

    MediaPlayer player;
    //    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.download, null);
//    BitmapDrawable bmp = (BitmapDrawable) ;
//    Bitmap icon = bmp.getBitmap();
    private static final String CHANNEL_ID = "MusicPlayer";
    private static final int NOTIFICATION_ID = 100;

    @SuppressLint({"ForegroundServiceType", "NewApi"})
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (player != null) {
            startMyPlayer();
        } else {
            player = MediaPlayer.create(getApplicationContext(), Settings.System.DEFAULT_ALARM_ALERT_URI);
            startMyPlayer();
        }

        startNotification();
        Log.d("abc", "Not PPlay In forground");


        return START_STICKY;
    }

    @SuppressLint("NewApi")
    @Override
    public void onCreate() {
        super.onCreate();
        startNotification();

    }

    @SuppressLint("NewApi")
    public void startNotification() {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification songPlaynotification = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.download)
                .setContentText("Music Player")
                .setSubText("new Massage from Music Player")
                .setChannelId(CHANNEL_ID).setAutoCancel(false)
                .setOngoing(true)
                .build();
        nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New Channel", NotificationManager.IMPORTANCE_HIGH));
        startForeground(
                NOTIFICATION_ID,
                songPlaynotification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK
        );
    }


    public void startMyPlayer() {
        if (player.isPlaying()) {
            player.seekTo(0);
            return;
        }
        player.setLooping(true);
        player.start();
    }

    public void stopMyPlayer() {
        if (player.isPlaying()) {
            player.stop();
        }

    }

    @Override
    public void onDestroy() {
        stopMyPlayer();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
