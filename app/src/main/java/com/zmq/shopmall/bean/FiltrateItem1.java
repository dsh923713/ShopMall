package com.zmq.shopmall.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zmq.shopmall.adapter.FiltrateAllClassifyAdapter;

/**
 * Created by Administrator on 2017/6/24.
 */

public class FiltrateItem1 extends AbstractExpandableItem<FiltrateItemContent> implements MultiItemEntity {
    public String title;

    public FiltrateItem1(String title) {
        this.title = title;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return FiltrateAllClassifyAdapter.TYPE_LEVEL_1;
    }
}
