package com.zmq.shopmall.adapter;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
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

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(mContext);
        layoutManager.setFlexWrap(FlexWrap.WRAP); //设置是否换行
        layoutManager.setFlexDirection(FlexDirection.ROW); //设置子元素的排列方向 默认水平排列
        layoutManager.setAlignItems(AlignItems.STRETCH);//沿副轴对齐(单行起作用) 高度充满
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);//沿主轴左对齐
        rvGoodsSku.setLayoutManager(layoutManager);
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
             * 设置子元素相对父容器所占比例 于weight相似
             */
//            TextView tv = holder.getView(R.id.tv_goods_sku);
//            ViewGroup.LayoutParams lp = tv.getLayoutParams();
//            if (lp instanceof FlexboxLayoutManager.LayoutParams) {
//                FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams) tv.getLayoutParams();
//                flexboxLp.setFlexGrow(1.0f);
//            }
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
         *
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
