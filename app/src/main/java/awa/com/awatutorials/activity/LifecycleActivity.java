package awa.com.awatutorials.activity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import awa.com.awatutorials.R;

public class LifecycleActivity extends Activity {
    private static final String TAG = LifecycleActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d(TAG, " onCreate");
       // createNotification();
        generateNotification();
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, " onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, " onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, " onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, " onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, " onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, " onDestroy");
    }
    private void createNotification() {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this,RecyclerViewMainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,(int)System.currentTimeMillis(),intent,0);
        Notification notification = new Notification.Builder(this)
                .setContentTitle("New notification")
                .setContentText("detailed notification text comes here")
                .setSmallIcon(R.drawable.history_screen_heart)
                .setAutoCancel(true).build();

        nm.notify(0,notification);
    }

    private void generateNotification() {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this,TutorialMainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        nm.notify(getNotificationIdentifier(), new NotificationCompat
                .Builder(this)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.footer_home_icon_enabled)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(),
                        R.drawable.celebration_box_2))
                .setColor(ContextCompat.getColor(this, R.color.app_color))
               // .setColor(andr)
                .setContentTitle("New notification p ")
                .setContentText("detailed notification text comes here p")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line... fdsbgvdfb bgfnfgbn  gmhmghkgnklgmnlgmnlghmnlmlmnlkghmnlghmnlghmnlghmnlghmnlghmnlhmnlghmnlhgmn " +
                                "mlymonhlgmlghmnlghmnlghmnlghmnlghmnlghmnlghmnlghmnlghmnlghmnlm    ghmjjhjm,hj,jh,hj,hj,jh,jh,jh,hj,hj,lttgmhnglmnlfgmnlglgmlgmlghmnlgml mhlymjnjoltym  " +
                                "lmhnotgmn        rtgg"))
                //.setStyle(new NotificationCompat.BigTextStyle().bigText("" + bundle.get(XTIFY_NOTIFICATION_CONTENT_TEXT)))
                .setContentIntent(pendingIntent)
                .build());
    }



    /**
     * This function generates a unique integer based on current time.
     *
     * @return current time in millis
     */
    private int getNotificationIdentifier(){
        return (int)System.currentTimeMillis();
    }

}
