package com.zmq.shopmall.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.FiltrateBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */

public class FiltrateServiceAdapter extends BaseQuickAdapter<FiltrateBean.FiltrateServiceBean, BaseViewHolder> {

    public FiltrateServiceAdapter(@Nullable List<FiltrateBean.FiltrateServiceBean> data) {
        super(R.layout.rv_item_filtrate_service, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, FiltrateBean.FiltrateServiceBean item) {
        holder.setText(R.id.cb_filtrate_service_item, item.getTitle());
    }
}
