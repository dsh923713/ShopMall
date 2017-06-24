package com.zmq.shopmall.adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.FiltrateBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */

public class FiltrateClassifyAdapter extends BaseQuickAdapter<FiltrateBean.FiltrateClassifyBean, BaseViewHolder> {
    private List<FiltrateBean.FiltrateClassifyItemBean> classifyItemBeanList = new ArrayList<>();
    private List<FiltrateBean.FiltrateClassifyItemBean> classifyItemBeanList1 = new ArrayList<>();
    private boolean[] isAll;

    public FiltrateClassifyAdapter(@Nullable List<FiltrateBean.FiltrateClassifyBean> data) {
        super(R.layout.rv_item_filtrate_classify, data);
        isAll = new boolean[data.size()];
    }


    @Override
    protected void convert(final BaseViewHolder holder, final FiltrateBean.FiltrateClassifyBean item) {
        holder.setText(R.id.tv_classify_name, item.getTitle());
        RecyclerView rvItemClassify = holder.getView(R.id.rv_item_classify);
        rvItemClassify.setLayoutManager(new GridLayoutManager(mContext, 3));
        if (item.getClassifyItemList().size() < 3) {  //数量小于三 全部显示
            classifyItemBeanList.clear();
            classifyItemBeanList.addAll(item.getClassifyItemList());
        } else {  //数量大于三 则只显示三个
            classifyItemBeanList.clear();
            classifyItemBeanList1.clear();
            for (int i = 0; i < 3; i++) {
                classifyItemBeanList1.add(item.getClassifyItemList().get(i));
            }
            classifyItemBeanList.addAll(classifyItemBeanList1);
        }
        final FiltrateClassifyItemAdapter adapter = new FiltrateClassifyItemAdapter(classifyItemBeanList);
        rvItemClassify.setAdapter(adapter);
        final TextView tvAllClassify = holder.getView(R.id.tv_all_classify);
        tvAllClassify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAll[holder.getAdapterPosition()]) { //展开
                    Drawable drawable = ContextCompat.getDrawable(mContext, R.mipmap.ic_goto_up);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    tvAllClassify.setCompoundDrawables(null, null, drawable, null);
                    isAll[holder.getAdapterPosition()] = true;
                    classifyItemBeanList.clear();
                    classifyItemBeanList.addAll(item.getClassifyItemList());
                    adapter.notifyDataSetChanged();
                } else {
                    Drawable drawable = ContextCompat.getDrawable(mContext, R.mipmap.ic_down_up);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    tvAllClassify.setCompoundDrawables(null, null, drawable, null);
                    isAll[holder.getAdapterPosition()] = false;
                    classifyItemBeanList.clear();
                    classifyItemBeanList.addAll(classifyItemBeanList1);
                    adapter.notifyDataSetChanged();
                }

            }
        });
    }

    public class FiltrateClassifyItemAdapter extends BaseQuickAdapter<FiltrateBean.FiltrateClassifyItemBean, BaseViewHolder> {

        public FiltrateClassifyItemAdapter(@Nullable List<FiltrateBean.FiltrateClassifyItemBean> data) {
            super(R.layout.rv_item_filtrate_service, data);
        }

        @Override
        protected void convert(BaseViewHolder holder, FiltrateBean.FiltrateClassifyItemBean item) {
            holder.setText(R.id.cb_filtrate_service_item, item.getTitle());
        }
    }
}
