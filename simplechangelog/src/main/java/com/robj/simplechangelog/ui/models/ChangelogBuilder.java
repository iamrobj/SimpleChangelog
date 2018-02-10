package com.robj.simplechangelog.ui.models;

import java.util.ArrayList;
import java.util.List;

public class ChangelogBuilder {

    private int versionCode;
    private String title;
    private List<LineItem> lines = new ArrayList();

    public ChangelogBuilder setVersionCode(int versionCode) {
        this.versionCode = versionCode;
        return this;
    }

    public ChangelogBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public ChangelogBuilder addLineItem(CharSequence line) {
        this.lines.add(new LineItem(line));
        return this;
    }

    public ChangelogBuilder addMinSdkVersionLineItem(int minSdkVersion, String line) {
        LineItem lineItem = new LineItem(line);
        lineItem.setMinSdkVersion(minSdkVersion);
        this.lines.add(lineItem);
        return this;
    }

    public ChangelogBuilder addMaxSdkVersionLineItem(int maxSdkVersion, String line) {
        LineItem lineItem = new LineItem(line);
        lineItem.setMaxSdkVersion(maxSdkVersion);
        this.lines.add(lineItem);
        return this;
    }

    public Changelog build() {
        return new Changelog(versionCode, title, lines);
    }
}