package com.example.localnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendLocalNotification(View view){
        NotificationCompat.Builder notiBuilder =  new NotificationCompat.Builder(MainActivity.this,"1")
                .setSmallIcon(R.drawable.noti)
                .setContentTitle("Study Hard")
                .setContentText("Hi, you didn't study for many months...");

        //set screen which is wanted to go when user tap notificaiton
        Intent resultIntent = new Intent(MainActivity.this,ShowNotificationInfo.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,resultIntent,0);

        notiBuilder.setContentIntent(pendingIntent);
        int notificaitonId = 001;
        NotificationManager notifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notifyManager.notify(notificaitonId,notiBuilder.build());
    }

    public void goToNotificationScreen(View view){
        Intent notiScreenIntent = new Intent(MainActivity.this,ShowNotificationInfo.class);
        startActivity(notiScreenIntent);
    }
}
