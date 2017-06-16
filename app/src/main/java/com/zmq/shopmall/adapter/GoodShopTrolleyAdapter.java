package com.zmq.shopmall.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.GoodShopTrolleyBean;

import java.util.List;

import ren.qinc.numberbutton.NumberButton;

/**
 * Created by Administrator on 2017/6/16.
 */

public class GoodShopTrolleyAdapter extends BaseQuickAdapter<GoodShopTrolleyBean, BaseViewHolder> {
    public GoodShopTrolleyAdapter(@Nullable List<GoodShopTrolleyBean> data) {
        super(R.layout.rv_item_shop_trolley, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, GoodShopTrolleyBean item) {
        holder.setChecked(R.id.cb_shop, item.isChecked()).setChecked(R.id.cb_goods, item.isChecked()).setText(R.id
                .tv_shop_name, item.getShopName()).setText(R.id.tv_goods_name, item.getGoodsName()).setImageResource(R.id
                .riv_goods_icon, item.getImageId()).setText(R.id.tv_goods_attribute, item.getGoodsAttribute()).setText(R.id
                .tv_goods_price, "￥" + item.getGoodsPrice());
        NumberButton numberButton = holder.getView(R.id.nb_goods_count);
        numberButton.setCurrentNumber(1);
        holder.addOnClickListener(R.id.cb_goods);
        holder.addOnClickListener(R.id.cb_shop);
    }
}
