package com.zmq.shopmall.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.GoodShopTrolleyBean;
import com.zmq.shopmall.widget.NumberButton;

import java.util.List;


/**
 * Created by Administrator on 2017/6/16.
 */

public class GoodShopTrolleyAdapter extends BaseQuickAdapter<GoodShopTrolleyBean, BaseViewHolder> {
    GoodsAccountListener listener;
    public NumberButton numberButton;

    public GoodShopTrolleyAdapter(GoodsAccountListener listener,@Nullable List<GoodShopTrolleyBean> data) {
        super(R.layout.rv_item_shop_trolley, data);
        this.listener = listener;
    }

    @Override
    protected void convert(BaseViewHolder holder, GoodShopTrolleyBean item) {
        holder.setChecked(R.id.cb_shop, item.isChecked()).setChecked(R.id.cb_goods, item.isChecked()).setText(R.id
                .tv_shop_name, item.getShopName()).setText(R.id.tv_goods_name, item.getGoodsName()).setImageResource(R.id
                .riv_goods_icon, item.getImageId()).setText(R.id.tv_goods_attribute, item.getGoodsAttribute()).setText(R.id
                .tv_goods_price, "￥" + item.getGoodsPrice());
        numberButton = holder.getView(R.id.nb_goods_count);
        holder.addOnClickListener(R.id.cb_goods);
        holder.addOnClickListener(R.id.cb_shop);
        holder.addOnClickListener(R.id.nb_goods_count);
        /**
         * 增减按钮的监听事件
         */
        numberButton.setOnWarnListener(new NumberButton.OnWarnListener() {
            @Override
            public void onWarningForInventory(int inventory) {

            }

            @Override
            public void onWarningForBuyMax(int max) {

            }

            @Override
            public void getNumber(int num) {
                if (listener != null){
                    listener.getGoodsAccount(num);
                }
            }
        });
    }


    public interface GoodsAccountListener{
        void getGoodsAccount(int number);
    }
}
