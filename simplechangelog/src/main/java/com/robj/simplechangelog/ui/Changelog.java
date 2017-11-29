package com.robj.simplechangelog.ui;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jj on 29/11/17.
 */

public class Changelog implements Parcelable {

    private final int versionCode;
    private final String title;
    private final List<String> lines = new ArrayList();


    public Changelog(int versionCode, String title, List<String> lines) {
        this.versionCode = versionCode;
        this.title = title;
        this.lines.addAll(lines);
    }

    protected Changelog(Parcel in) {
        versionCode = in.readInt();
        title = in.readString();
        lines.addAll(in.createStringArrayList());
    }

    public static final Creator<Changelog> CREATOR = new Creator<Changelog>() {
        @Override
        public Changelog createFromParcel(Parcel in) {
            return new Changelog(in);
        }

        @Override
        public Changelog[] newArray(int size) {
            return new Changelog[size];
        }
    };

    public int getVersionCode() {
        return versionCode;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getLines() {
        return lines;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(versionCode);
        dest.writeString(title);
        dest.writeStringList(lines);
    }
}
