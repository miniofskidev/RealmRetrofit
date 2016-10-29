package jik.android.retrofitrelm.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.NotificationCompat;

import jik.android.retrofitrelm.R;

/**
 * Created by tosantechnolocal on 10/27/2016.
 */
public class Notify {

    public static void sendNotification(Context context, String title, String content) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        builder.setSmallIcon(R.drawable.notification);
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setVibrate(new long[]{500L, 500L, 500L});

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(9999, builder.build());
    }

}
