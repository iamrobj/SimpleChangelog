package com.robj.simplechangelog.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.annotation.StyleRes;

/**
 * Created by jj on 29/11/17.
 */

public class ChangelogUtil {

    public static void showChangelogIfRequired(Context context, Changelog changelog) {
        showChangelogIfRequired(context, changelog, 0);
    }

    public static void showChangelogIfRequired(Context context, Changelog changelog, @StyleRes int styleResId) {
        int currentVersionCode;
        try {
            currentVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        int versionCode = ChangelogPrefs.getLastChangelogShown(context);
        if(versionCode > 0) {
             if (versionCode < currentVersionCode) {
                 showChangelog(context, changelog, styleResId);
                 NotificationUtils.cancelNotification(context, NotificationUtils.CHANGELOG_ID);
             }
        } else
            ChangelogPrefs.setChangelogShown(context, currentVersionCode);
    }

    public static void showChangelogNotifIfRequired(Context context, Changelog changelog,
                                                    String channelId, @DrawableRes int iconResId, String title, String body) {
        showChangelogNotifIfRequired(context, changelog, channelId, iconResId, title, body, 0);
    }

    public static void showChangelogNotifIfRequired(Context context, Changelog changelog,
                                                    String channelId, @DrawableRes int iconResId, String title, String body, @StyleRes int styleResId) {
        Intent i = getChangelogIntent(context, changelog, styleResId);
        showChangelogNotifIfRequired(context, i, channelId, iconResId, title, body);
    }

    public static void showChangelogNotifIfRequired(Context context, Intent i, String channelId, @DrawableRes int iconResId, String title, String body) {
        int currentVersionCode;
        try {
            currentVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        int versionCode = ChangelogPrefs.getLastChangelogShown(context);
        if (versionCode > 0) {
            if (versionCode < currentVersionCode) {
                versionCode = ChangelogPrefs.getLastChangelogNotifShown(context);
                if (versionCode > 0 && versionCode < currentVersionCode) {
                    NotificationUtils.showChangelogNotification(context, i, channelId, iconResId, title, body);
                    ChangelogPrefs.setChangelogNotifShown(context, currentVersionCode);
                }
            }
        } else
            ChangelogPrefs.setChangelogNotifShown(context, currentVersionCode);
    }

    public static void showChangelog(Context context, Changelog changelog) {
        showChangelog(context, changelog, 0);
    }

    public static void showChangelog(Context context, Changelog changelog, @StyleRes int styleResId) {
        Intent i = getChangelogIntent(context, changelog, styleResId);
        context.startActivity(i);
    }

    private static Intent getChangelogIntent(Context context, Changelog changelog, @StyleRes int styleResId) {
        Intent i = new Intent(context, ChangelogActivity.class);
        i.putExtra(ChangelogActivity.CHANGELOG, changelog);
        if(styleResId != 0)
            i.putExtra(ChangelogActivity.THEME, styleResId);
        return i;
    }
}
