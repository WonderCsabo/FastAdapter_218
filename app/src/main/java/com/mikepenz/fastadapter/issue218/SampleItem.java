package com.mikepenz.fastadapter.issue218;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.fastadapter.IExpandable;
import com.mikepenz.fastadapter.items.GenericAbstractItem;

import java.util.List;

public class SampleItem extends GenericAbstractItem<String, SampleItem, SampleItem.ViewHolder> implements
        IExpandable<SampleItem, SampleSubItem> {

    private boolean expanded;

    private List<SampleSubItem> subItems;

    public SampleItem(String s) {
        super(s);
    }

    @Override
    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public SampleItem withIsExpanded(boolean collapsed) {
        this.expanded = collapsed;
        return this;
    }

    @Override
    public SampleItem withSubItems(List<SampleSubItem> subItems) {
        this.subItems = subItems;
        return this;
    }

    @Override
    public List<SampleSubItem> getSubItems() {
        return subItems;
    }

    @Override
    public boolean isAutoExpanding() {
        return !isSelected();
    }

    @Override
    public boolean isSelectable() {
        return !isSelected();
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public int getLayoutRes() {
        return android.R.layout.simple_list_item_1;
    }

    @Override
    public void bindView(ViewHolder holder, List payloads) {
        super.bindView(holder, payloads);

        holder.setText(getModel());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        void setText(String text) {
            ((TextView) itemView).setText(text);
        }
    }
}
