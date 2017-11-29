package com.robj.simplechangelog.ui;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v4.app.NotificationCompat;

/**
 * Created by jj on 29/11/17.
 */

class NotificationUtils {

    public static final int CHANGELOG_ID = 2;

    public static void showChangelogNotification(Context context, Intent i, String channelId, @DrawableRes int iconResId,
                                                 String title, String body) {
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context, channelId)
                        .setAutoCancel(true)
                        .setOngoing(false)
                        .setSmallIcon(iconResId)
                        .setContentTitle(title)
                        .setContentText(body)
                        .setTicker(title)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(body))
                        .setContentIntent(pendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(CHANGELOG_ID, mBuilder.build());
    }

    public static void cancelNotification(Context context, int id) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.cancel(id);
    }

}
