package com.lendunion;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * Created by hcz on 2016/7/26.
 */
public class CommonViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> views;

    public CommonViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray();
    }

    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public CommonViewHolder setText(int viewId, CharSequence text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }
}
