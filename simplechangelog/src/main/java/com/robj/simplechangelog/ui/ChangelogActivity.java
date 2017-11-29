package com.robj.simplechangelog.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.robj.simplechangelog.R;
import com.robj.simplechangelog.ui.fragment.ChangelogDialogFragment;

/**
 * Created by jj on 11/06/17.
 */

public class ChangelogActivity extends AppCompatActivity {

    public static final String CHANGELOG = ChangelogDialogFragment.CHANGELOG;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Bundle bundle = getIntent() != null && getIntent().getExtras() != null ? getIntent().getExtras() : new Bundle();
        Fragment fragment = Fragment.instantiate(this, ChangelogDialogFragment.class.getName(), bundle);
        pushFragment(fragment, false);
        NotificationUtils.cancelNotification(this, NotificationUtils.CHANGELOG_ID);
    }

    private void pushFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if(addToBackStack) {
            ft.addToBackStack(fragment.getClass().getName());
        }
        ft.replace(R.id.content_frame, fragment, fragment.getClass().getName());
        ft.commit();
    }

}