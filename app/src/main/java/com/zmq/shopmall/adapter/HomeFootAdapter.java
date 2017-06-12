package com.zmq.shopmall.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.RecommendBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */

public class HomeFootAdapter extends BaseQuickAdapter<RecommendBean, BaseViewHolder> {
    public HomeFootAdapter(@Nullable List<RecommendBean> data) {
        super(R.layout.rv_item_child_home_foot, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, RecommendBean item) {
        holder.setImageResource(R.id.iv_icon, item.getImage())
                .setText(R.id.tv_name, item.getTitle())
                .setText(R.id.tv_price, item.getPrice() + "");
        if (item.isFindSimilar()) {
            holder.setVisible(R.id.tv_find_similar, true);
            holder.addOnClickListener(R.id.tv_find_similar);
        }
        if (item.isShopTrolley()) {
            holder.setVisible(R.id.tv_shopping_trolley, true);
            holder.addOnClickListener(R.id.tv_shopping_trolley);
        }

    }
}
