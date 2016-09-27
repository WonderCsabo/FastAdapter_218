package com.mikepenz.fastadapter.issue218;

import com.mikepenz.fastadapter.items.GenericAbstractItem;

import java.util.List;

public class SampleSubItem extends GenericAbstractItem<String, SampleSubItem, SampleItem.ViewHolder> {

    public SampleSubItem(String s) {
        super(s);
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public int getLayoutRes() {
        return android.R.layout.simple_list_item_1;
    }

    @Override
    public void bindView(SampleItem.ViewHolder holder, List payloads) {
        super.bindView(holder, payloads);

        holder.setText(getModel());
    }
}
