package com.zmq.shopmall.adapter;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.ClassifyLeftBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */

public class ClassifyLeftAdapter extends BaseQuickAdapter<ClassifyLeftBean, BaseViewHolder> {
    private int position = 0;

    public ClassifyLeftAdapter(@Nullable List<ClassifyLeftBean> data) {
        super(R.layout.rv_item_classify_left, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ClassifyLeftBean item) {
        if (position == holder.getAdapterPosition()) {
            holder.setBackgroundColor(R.id.tv_name, ContextCompat.getColor(mContext, R.color.grey));
            holder.setTextColor(R.id.tv_name,ContextCompat.getColor(mContext, R.color.red));
        }else {
            holder.setBackgroundRes(R.id.tv_name, R.drawable.rv_classify_left_color);
            holder.setTextColor(R.id.tv_name,ContextCompat.getColor(mContext, R.color.black));
        }
        holder.setText(R.id.tv_name,item.getTitle());
    }

    public void selectPosition(int position) {
        this.position = position;
    }
}
