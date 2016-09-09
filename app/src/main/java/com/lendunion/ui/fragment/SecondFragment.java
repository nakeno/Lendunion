package com.lendunion.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lendunion.BaseListAdapter;
import com.lendunion.CommonViewHolder;
import com.lendunion.R;
import com.lendunion.ui.fragment.dummy.DummyContent;

/**
 * Created by hcz on 2016/7/27.
 */
public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new BaseListAdapter<DummyContent.DummyItem>(R.layout.item_second_list, DummyContent.ITEMS) {
                @Override
                protected void convert(CommonViewHolder commonViewHolder, DummyContent.DummyItem item) {
                    commonViewHolder.setText(R.id.tv_object_name, item.id);
                    commonViewHolder.setText(R.id.tv_object_desc, item.content);

                    Glide.with(SecondFragment.this).load("http://img0.bdstatic.com/img/image/shouye/xiaoxiao/%E5%AE%A0%E7%89%A9722.jpg").centerCrop().placeholder(R.mipmap.ic_launcher).crossFade().into((ImageView) commonViewHolder.getView(R.id.iv_object));
                }
            });
        }
        return view;
    }

    public static SecondFragment newInstance() {
        Bundle args = new Bundle();
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
