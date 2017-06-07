package com.zmq.shopmall.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */

public class ClassifyRightBean {
    private int imageId;
    private boolean isTop;
    private boolean isRank;
    private String title;
    List<ClassifyRightItemBean> rightItemList;

    public ClassifyRightBean(int imageId, boolean isTop, boolean isRank, String title, List<ClassifyRightItemBean> rightItemList) {
        this.imageId = imageId;
        this.isTop = isTop;
        this.isRank = isRank;
        this.title = title;
        this.rightItemList = rightItemList;
    }

    public boolean isRank() {
        return isRank;
    }

    public void setRank(boolean rank) {
        isRank = rank;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ClassifyRightItemBean> getRightItemList() {
        return rightItemList;
    }

    public void setRightItemList(List<ClassifyRightItemBean> rightItemList) {
        this.rightItemList = rightItemList;
    }



}
