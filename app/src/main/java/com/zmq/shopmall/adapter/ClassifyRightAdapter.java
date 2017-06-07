package com.zmq.shopmall.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.ClassifyRightBean;
import com.zmq.shopmall.bean.ClassifyRightItemBean;
import com.zmq.shopmall.utils.ToastUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */

public class ClassifyRightAdapter extends BaseQuickAdapter<ClassifyRightBean, BaseViewHolder> {
    public ClassifyRightAdapter(@Nullable List<ClassifyRightBean> data) {
        super(R.layout.rv_item_classify_right, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ClassifyRightBean item) {
        if (item.isTop()) { //头部banner
            holder.setVisible(R.id.iv_head, true);
            holder.setImageResource(R.id.iv_head, item.getImageId());
            holder.addOnClickListener(R.id.iv_head);
        }
        if (item.isRank()) { //是否显示排行榜
            holder.setVisible(R.id.tv_rank, true);
            holder.addOnClickListener(R.id.tv_rank);
        }
        holder.setText(R.id.tv_name, item.getTitle());
        RecyclerView rv_item_classify = holder.getView(R.id.rv_item_classify);
        rv_item_classify.setLayoutManager(new GridLayoutManager(mContext, 3));
        ClassifyItemAdapter itemAdapter = new ClassifyItemAdapter(item.getRightItemList());
        rv_item_classify.setAdapter(itemAdapter);
        itemAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showLongToast(mContext,position+"");
            }
        });
    }

    class ClassifyItemAdapter extends BaseQuickAdapter<ClassifyRightItemBean, BaseViewHolder> {
        public ClassifyItemAdapter(@Nullable List<ClassifyRightItemBean> data) {
            super(R.layout.rv_item_classify_child_right, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, ClassifyRightItemBean item) {
            helper.setImageResource(R.id.iv_item_pic, item.getImageId());
            helper.setText(R.id.tv_item_title, item.getTitle());
        }
    }

}
