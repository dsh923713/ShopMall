package com.zmq.shopmall.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.RecommendBean;
import com.zmq.shopmall.utils.ScreenUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */

public class HomeFootAdapter extends BaseQuickAdapter<RecommendBean, BaseViewHolder> {
    private boolean isRank;
    private int id;

    public HomeFootAdapter(int id, @Nullable List<RecommendBean> data) {
        super(R.layout.rv_item_child_home_foot, data);
        this.id = id;
    }

    public HomeFootAdapter(boolean isRank, @Nullable List<RecommendBean> data) {
        super(R.layout.rv_item_child_home_foot, data);
        this.isRank = isRank;
    }

    @Override
    protected void convert(BaseViewHolder holder, RecommendBean item) {
        holder.setText(R.id.tv_name, item.getTitle()).setText(R.id.tv_price, item.getPrice() + "");
        if (id == 1) { //详情页的推荐布局显示
            ImageView ivIcon = holder.getView(R.id.iv_icon);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) ivIcon.getLayoutParams();
            params.width = (ScreenUtil.getScreenWidthPix(mContext) / 3);
            params.height = (ScreenUtil.getScreenWidthPix(mContext) / 3);
            ivIcon.setLayoutParams(params);
            ivIcon.setImageResource(item.getImage());
        } else { //首页、购物车推荐列表布局显示
            ImageView ivIcon = holder.getView(R.id.iv_icon);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) ivIcon.getLayoutParams();
            params.width = (ScreenUtil.getScreenWidthPix(mContext) / 2);
            params.height = (ScreenUtil.getScreenWidthPix(mContext) / 2);
            ivIcon.setLayoutParams(params);
            ivIcon.setImageResource(item.getImage());
        }
        if (item.isFindSimilar()) {
            holder.setVisible(R.id.tv_find_similar, true);
            holder.addOnClickListener(R.id.tv_find_similar);
        }
        if (item.isShopTrolley()) {
            holder.setVisible(R.id.tv_shopping_trolley, true);
            holder.addOnClickListener(R.id.tv_shopping_trolley);
        }
        if (item.isRank() && holder.getAdapterPosition() < 3) {
            holder.setVisible(R.id.tv_rank, true);
            holder.setText(R.id.tv_rank, holder.getAdapterPosition() + 1 + "");
        } else {
            holder.setVisible(R.id.tv_rank, false);
        }


    }
}
