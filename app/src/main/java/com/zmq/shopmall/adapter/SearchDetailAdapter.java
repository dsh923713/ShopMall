package com.zmq.shopmall.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.SearchDetailBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */

public class SearchDetailAdapter extends BaseQuickAdapter<SearchDetailBean, BaseViewHolder> {
    private int id;

    public SearchDetailAdapter(int id, @Nullable List<SearchDetailBean> data) {
        super(R.layout.rv_item_search_detail, data);
        this.id = id;
    }

    @Override
    protected void convert(BaseViewHolder holder, SearchDetailBean item) {
        if (id == 1) {
            holder.setVisible(R.id.ll_search_detail, true).setVisible(R.id.ll_search_detail_list, false).setImageResource(R.id
                    .iv_goods_icon, item.getImageId()).setText(R.id.tv_goods_title, item.getTitle()).setText(R.id
                    .tv_goods_price, item.getPrice() + "").setText(R.id.tv_recommend_num, item.getRecommend() + "条评价　" + item
                    .getGoodRecommend() + "%好评");

        } else {
            holder.setVisible(R.id.ll_search_detail, false).setVisible(R.id.ll_search_detail_list, true).setImageResource(R.id
                    .iv_goods_icon_list, item.getImageId()).setText(R.id.tv_goods_title_list, item.getTitle()).setText(R.id
                    .tv_goods_price_list, item.getPrice() + "").setText(R.id.tv_recommend_num_list, item.getRecommend() +
                    "条评价　" + item.getGoodRecommend() + "%好评");
        }
    }
}
