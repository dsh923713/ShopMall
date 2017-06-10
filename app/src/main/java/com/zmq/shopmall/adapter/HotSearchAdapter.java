package com.zmq.shopmall.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;

import java.util.List;

/**
 * Created by Administrator on 2017/6/10.
 */

public class HotSearchAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public HotSearchAdapter(@Nullable List<String> data) {
        super(R.layout.rv_item_hot_search, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, String item) {
        holder.setText(R.id.tv_hot_search_name, item);
        holder.addOnClickListener(R.id.tv_hot_search_name);
    }
}
