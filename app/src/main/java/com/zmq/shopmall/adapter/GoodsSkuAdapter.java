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

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class GoodsSkuAdapter extends BaseQuickAdapter<GoodsSkuBean, BaseViewHolder> {

    private GetSkuListener getSkuListener;

    public GoodsSkuAdapter(@Nullable List<GoodsSkuBean> data) {
        super(R.layout.item_dia_goods_sku, data);
    }


    public void GetSku(GetSkuListener getSkuListener) {
        this.getSkuListener = getSkuListener;
    }

    @Override
    protected void convert(BaseViewHolder holder, final GoodsSkuBean item) {
        holder.setText(R.id.tv_goods_sku, item.getSku());
        final RecyclerView rvGoodsSku = holder.getView(R.id.rv_goods_sku);
        rvGoodsSku.setLayoutManager(new GridLayoutManager(mContext, 4));
        final GoodsSkuChildAdapter childAdapter = new GoodsSkuChildAdapter(item.getGoodsSku());
        rvGoodsSku.setAdapter(childAdapter);
        if (getSkuListener != null) { //获取sku
            getSkuListener.getSku(item.getSku(), item.getGoodsSku().get(0).getSkuName());
        }
        childAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (getSkuListener != null) { //获取sku
                    getSkuListener.getSku(item.getSku(), item.getGoodsSku().get(position).getSkuName());
                }
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
            /**
             * 判断是否是选中状态
             */
            holder.setTextColor(R.id.tv_goods_sku, position == holder.getAdapterPosition() ? ContextCompat.getColor(mContext, R
                    .color.red) : ContextCompat.getColor(mContext, R.color.black));
            holder.setBackgroundRes(R.id.tv_goods_sku, position == holder.getAdapterPosition() ? R.drawable.shape_goods_sku_red
                    : R.drawable.shape_login_white);
            holder.getView(R.id.tv_goods_sku).setClickable(position == holder.getAdapterPosition() ? false : true);
        }

        /**
         * 传递点击时的position
         * @param position
         */
        public void selectPosition(int position) {
            this.position = position;
        }
    }

    /**
     * 声明接口获取sku
     */
    public interface GetSkuListener {
        void getSku(String skuName, String sku);
    }
}
