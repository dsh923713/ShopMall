package com.zmq.shopmall.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zmq.shopmall.adapter.FiltrateAllClassifyAdapter;

/**
 * Created by Administrator on 2017/6/24.
 */

public class FiltrateItem extends AbstractExpandableItem<FiltrateItem1> implements MultiItemEntity {

    @Override
    public int getItemType() {
        return FiltrateAllClassifyAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
