package com.robj.simplechangelog.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.robj.radicallyreusable.base.base_list.BaseListRecyclerAdapter;
import com.robj.radicallyreusable.base.mvp.BaseViewHolder;
import com.robj.simplechangelog.R;
import com.robj.simplechangelog.databinding.ClRowChangelogContentBinding;
import com.robj.simplechangelog.databinding.ClRowChangelogTitleBinding;

/**
 * Created by Rob J on 21/09/17.
 */

public class ChangelogAdapter extends BaseListRecyclerAdapter<Object, BaseViewHolder> {

    private final static int TYPE_TITLE = 0;
    private final static int TYPE_CONTENT = 1;

    public ChangelogAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder createVH(ViewGroup parent, int type) {
        switch (type) {
            case TYPE_TITLE:
                return createTitleViewHolder(parent);
            case TYPE_CONTENT:
                return createContentViewHolder(parent);
            default:
                return null;
        }
    }

    private BaseViewHolder createContentViewHolder(ViewGroup parent) {
        final ClRowChangelogContentBinding binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.cl_row_changelog_content, parent, false);
        return new ChangelogViewHolder(binding);
    }

    private BaseViewHolder createTitleViewHolder(ViewGroup parent) {
        final ClRowChangelogTitleBinding binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.cl_row_changelog_title, parent, false);
        return new ChangelogTitleViewHolder(binding);
    }

    @Override
    protected void onBindViewHolder(BaseViewHolder viewHolder, int pos, int type) {
        switch (type) {
            case TYPE_TITLE:
                ChangelogTitleViewHolder titleViewHolder = (ChangelogTitleViewHolder) viewHolder;
                titleViewHolder.setViewModel((ChangelogTitle) getItemAtPosition(pos));
                break;
            case TYPE_CONTENT:
                ChangelogViewHolder changelogViewHolder = (ChangelogViewHolder) viewHolder;
                changelogViewHolder.setViewModel((ChangelogItem) getItemAtPosition(pos));
                break;
            default:
                break;
        }
    }

    @Override
    protected int getViewType(int position) {
        Object o = getItemAtPosition(position);
        if(o instanceof ChangelogTitle)
            return TYPE_TITLE;
        else if(o instanceof ChangelogItem)
            return TYPE_CONTENT;
        else
            return super.getViewType(position);
    }
}
