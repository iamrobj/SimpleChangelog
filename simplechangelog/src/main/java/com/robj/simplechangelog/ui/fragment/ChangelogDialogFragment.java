package com.robj.simplechangelog.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.robj.radicallyreusable.base.base_list.BaseListFragment;
import com.robj.simplechangelog.R;
import com.robj.simplechangelog.ui.adapter.ChangelogAdapter;

/**
 * Created by Rob J on 22/05/15.
 */
public class ChangelogDialogFragment extends BaseListFragment<ChangelogView, ChangelogPresenter, ChangelogAdapter, Object> implements ChangelogView {

    public static final String CHANGELOG = ChangelogPresenter.CHANGELOG;

    private View btnOk;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().loadChangelog(getActivity(), getArguments());
        btnOk = view.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.cl_fragment_changelog;
    }

    @Override
    public ChangelogPresenter createPresenter() {
        return new ChangelogPresenter();
    }

    @Override
    protected String getSearchString() {
        return getString(R.string.cl_progress_changelog);
    }

    @Override
    protected ChangelogAdapter createAdapter() {
        return new ChangelogAdapter(getActivity());
    }

    @Override
    public void onRefresh() {

    }
}
