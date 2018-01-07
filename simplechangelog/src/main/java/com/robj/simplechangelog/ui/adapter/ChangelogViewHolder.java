package com.robj.simplechangelog.ui.adapter;

import com.robj.radicallyreusable.base.mvp.BaseViewHolder;
import com.robj.simplechangelog.databinding.ClRowChangelogContentBinding;

/**
 * Created by Rob J on 21/09/17.
 */

class ChangelogViewHolder extends BaseViewHolder {

    private final ClRowChangelogContentBinding binding;

    public ChangelogViewHolder(ClRowChangelogContentBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setViewModel(ChangelogItem viewModel) {
        this.binding.setViewModel(viewModel);
    }

}
