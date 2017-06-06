package com.zmq.shopmall.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by Administrator on 2017/6/6.
 */

public class HomeItemBean extends SectionEntity<HomeChlidBean> {
    public boolean isMore; //是否显示更多
    public String moreText;

    public HomeItemBean(boolean isHeader, String header, boolean isMore, String moreText) {
        super(isHeader, header);
        this.moreText = moreText;
        this.isMore = isMore;
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }

    public void setMoreText(String moreText) {
        this.moreText = moreText;
    }

    public String getMoreText() {
        return moreText;
    }

    public HomeItemBean(HomeChlidBean homeChlidBean) {
        super(homeChlidBean);
    }

}
