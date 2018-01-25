package com.robj.simplechangelog.ui.fragment;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.robj.radicallyreusable.base.mvp.fragment.BaseMvpPresenter;
import com.robj.simplechangelog.R;
import com.robj.simplechangelog.ui.models.Changelog;
import com.robj.simplechangelog.ui.ChangelogPrefs;
import com.robj.simplechangelog.ui.adapter.ChangelogItem;
import com.robj.simplechangelog.ui.adapter.ChangelogTitle;
import com.robj.simplechangelog.ui.models.LineItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rob J on 21/09/17.
 */

class ChangelogPresenter extends BaseMvpPresenter<ChangelogView> {

    public static final String CHANGELOG = "changelog";

    public void loadChangelog(Context context, Bundle bundle) {
        List viewModels = new ArrayList();
        int currentVersionCode;
        try {
            currentVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            getView().showError(R.string.cl_error_generic);
            return;
        }

        if (bundle == null || bundle.isEmpty() || !bundle.containsKey(CHANGELOG)) {
            getView().showError(R.string.cl_error_no_changelog);
            return;
        }

        Changelog changelog = bundle.getParcelable(CHANGELOG);

        viewModels.add(new ChangelogTitle(changelog.getTitle()));
        for (LineItem line : changelog.getLineItems())
            if((line.getMinSdkVersion() == 0 && line.getMinSdkVersion() == 0)
                    || Build.VERSION.SDK_INT >= line.getMinSdkVersion()
                    || Build.VERSION.SDK_INT <= line.getMaxSdkVersion())
            viewModels.add(new ChangelogItem(line.getLine()));

        ChangelogPrefs.setChangelogShown(context, currentVersionCode);

        getView().addResults(viewModels);
        getView().hideProgress();
    }

}
