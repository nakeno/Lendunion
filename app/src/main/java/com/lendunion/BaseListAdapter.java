package com.lendunion;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by hcz on 2016/7/26.
 */
public abstract class BaseListAdapter<T> extends RecyclerView.Adapter {
    private final List<T> mData;
    private final int mItemLayoutId;

    public BaseListAdapter(int itemLayoutId, List<T> data) {
        mItemLayoutId = itemLayoutId;
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mItemLayoutId, parent, false);

        return new CommonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        convert((CommonViewHolder)holder, mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    protected abstract void convert(CommonViewHolder commonViewHolder, T item);
}
