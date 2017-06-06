package com.zmq.shopmall.adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.HomeChlidBean;
import com.zmq.shopmall.bean.HomeItemBean;

import java.util.List;

/**
 * 首页适配器 分组模式
 * Created by Administrator on 2017/6/5.
 */

public class HomeAdapter extends BaseSectionQuickAdapter<HomeItemBean, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public HomeAdapter(int layoutResId, int sectionHeadResId, List<HomeItemBean> data) {
        super(layoutResId, sectionHeadResId, data);
        data.get(1).t.getTitle();
    }

    @Override
    protected void convertHead(BaseViewHolder helper, HomeItemBean item) {
        helper.setText(R.id.tv_title, item.header);
        helper.setVisible(R.id.tv_more, item.isMore())
                .setText(R.id.tv_more, item.getMoreText());
        helper.addOnClickListener(R.id.tv_more);

    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItemBean item) {
        HomeChlidBean bean = item.t;
        helper.setText(R.id.tv_item_title, bean.getTitle())
                .setText(R.id.tv_item_preferential, bean.getPreferential())
                .setImageResource(R.id.iv_item_pic1, bean.getImageId1())
                .setImageResource(R.id.iv_item_pic2, bean.getImageId2());
        helper.addOnClickListener(R.id.iv_item_pic1);
        helper.addOnClickListener(R.id.iv_item_pic2);
    }
}
