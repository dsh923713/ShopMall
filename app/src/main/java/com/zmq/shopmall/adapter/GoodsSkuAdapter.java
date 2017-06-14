package com.zmq.shopmall.adapter;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.GoodsSkuBean;
import com.zmq.shopmall.utils.ToastUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class GoodsSkuAdapter extends BaseQuickAdapter<GoodsSkuBean, BaseViewHolder> {

    public GoodsSkuAdapter(@Nullable List<GoodsSkuBean> data) {
        super(R.layout.item_dia_goods_sku, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, final GoodsSkuBean item) {
        holder.setText(R.id.tv_goods_sku, item.getSku());
        final RecyclerView rvGoodsSku = holder.getView(R.id.rv_goods_sku);
        rvGoodsSku.setLayoutManager(new GridLayoutManager(mContext, 6));
        final GoodsSkuChildAdapter childAdapter = new GoodsSkuChildAdapter(item.getGoodsSku());
        rvGoodsSku.setAdapter(childAdapter);
        childAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShortToast(mContext, item.getGoodsSku().get(position).getSkuName());
//                TextView tv = (TextView) childAdapter.getViewByPosition(rvGoodsSku, position, R.id.tv_goods_sku);
//                tv.setTextColor(ContextCompat.getColor(mContext, R.color.red));
//                tv.setBackground(ContextCompat.getDrawable(mContext, R.drawable.shape_goods_sku_red));
                childAdapter.selectPosition(position);
                childAdapter.notifyDataSetChanged();

            }
        });


    }

    public class GoodsSkuChildAdapter extends BaseQuickAdapter<GoodsSkuBean.GoodsSkuChild, BaseViewHolder> {

        private int position = 0;

        public GoodsSkuChildAdapter(@Nullable List<GoodsSkuBean.GoodsSkuChild> data) {
            super(R.layout.item_child_dia_goods_sku, data);
        }

        @Override
        protected void convert(BaseViewHolder holder, GoodsSkuBean.GoodsSkuChild item) {
            holder.setText(R.id.tv_goods_sku, item.getSkuName());
            holder.addOnClickListener(R.id.tv_goods_sku);
            if (position == holder.getAdapterPosition()) {
                holder.setTextColor(R.id.tv_goods_sku, ContextCompat.getColor(mContext, R.color.red));
                holder.setBackgroundRes(R.id.tv_goods_sku, R.drawable.shape_goods_sku_red);
            }else {
                holder.setTextColor(R.id.tv_goods_sku, ContextCompat.getColor(mContext, R.color.black));
                holder.setBackgroundRes(R.id.tv_goods_sku, R.drawable.shape_login_white);
            }
        }

        public void selectPosition(int position) {
            this.position = position;
        }
    }
}
