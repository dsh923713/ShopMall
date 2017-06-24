package com.zmq.shopmall.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zmq.shopmall.adapter.FiltrateAllClassifyAdapter;

/**
 * Created by Administrator on 2017/6/24.
 */

public class FiltrateItemContent implements MultiItemEntity {
    public String title;

    public FiltrateItemContent(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return FiltrateAllClassifyAdapter.TYPE_PERSON;
    }
}
