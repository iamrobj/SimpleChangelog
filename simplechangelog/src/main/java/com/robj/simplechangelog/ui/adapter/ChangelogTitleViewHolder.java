package com.robj.simplechangelog.ui.adapter;

import com.robj.radicallyreusable.base.mvp.BaseViewHolder;
import com.robj.simplechangelog.databinding.ClRowChangelogTitleBinding;

/**
 * Created by Rob J on 21/09/17.
 */

class ChangelogTitleViewHolder extends BaseViewHolder {

    private final ClRowChangelogTitleBinding binding;

    public ChangelogTitleViewHolder(ClRowChangelogTitleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setViewModel(ChangelogTitle viewModel) {
        this.binding.setViewModel(viewModel);
    }

}
