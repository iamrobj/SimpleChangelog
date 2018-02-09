package com.robj.simplechangelog.ui;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Rob J on 29/11/17.
 */

public class ChangelogPrefs {

    private final static String PREFS = "_changelog_Prefs";
    private static final String CHANGELOG_VERSION_SHOWN = "CHANGELOG_VERSION_SHOWN";
    private static final String CHANGELOG_NOTIF_VERSION_SHOWN = "CHANGELOG_NOTIF_VERSION_SHOWN";

    public static void setChangelogShown(Context context, int versionCode) {
        writeIntPref(context, CHANGELOG_VERSION_SHOWN, versionCode);
    }

    public static int getLastChangelogShown(Context context) {
        return readIntPref(context, CHANGELOG_VERSION_SHOWN);
    }

    public static void setChangelogNotifShown(Context context, int versionCode) {
        writeIntPref(context, CHANGELOG_NOTIF_VERSION_SHOWN, versionCode);
    }

    public static int getLastChangelogNotifShown(Context context) {
        return readIntPref(context, CHANGELOG_NOTIF_VERSION_SHOWN);
    }

    public static void writeIntPref(Context context, String name, int i) {
        SharedPreferences.Editor editor = context.getSharedPreferences(context.getPackageName() + PREFS, Context.MODE_PRIVATE).edit();
        editor.putInt(name, i);
        editor.apply();
    }

    public static void writeBoolPref(Context context, String name, boolean b) {
        SharedPreferences.Editor editor = context.getSharedPreferences(context.getPackageName() + PREFS, Context.MODE_PRIVATE).edit();
        editor.putBoolean(name, b);
        editor.apply();
    }

    public static int readIntPref(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(context.getPackageName() + PREFS, Context.MODE_PRIVATE);
        return sp.getInt(name, 0);
    }

}
