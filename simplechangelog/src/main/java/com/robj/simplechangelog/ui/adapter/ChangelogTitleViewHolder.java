package com.robj.simplechangelog.ui.adapter;

import com.robj.radicallyreusable.base.mvp.BaseViewHolder;
import com.robj.simplechangelog.databinding.RowChangelogTitleBinding;

/**
 * Created by Rob J on 21/09/17.
 */

class ChangelogTitleViewHolder extends BaseViewHolder {

    private final RowChangelogTitleBinding binding;

    public ChangelogTitleViewHolder(RowChangelogTitleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setViewModel(ChangelogTitle viewModel) {
        this.binding.setViewModel(viewModel);
    }

}
