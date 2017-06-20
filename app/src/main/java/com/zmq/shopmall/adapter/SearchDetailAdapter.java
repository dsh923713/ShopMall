package com.zmq.shopmall.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.bean.SearchDetailBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */

public class SearchDetailAdapter extends BaseQuickAdapter<SearchDetailBean, BaseViewHolder> {
    public SearchDetailAdapter(@LayoutRes int layoutResId, @Nullable List<SearchDetailBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, SearchDetailBean item) {
//        holder.setImageResource(R.id.iv_goods_icon, item.getImageId()).setText(R.id.tv_goods_title, item.getTitle()).setText(R
//                .id.tv_price, item.getPrice() + "").setText(R.id.tv_recommend_num, item.getRecommend() + "条评价　" + item
//                .getGoodRecommend() + "%好评");
    }
}
