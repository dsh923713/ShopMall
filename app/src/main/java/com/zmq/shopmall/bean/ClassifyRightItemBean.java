package com.zmq.shopmall.bean;

/**
 * Created by Administrator on 2017/6/7.
 */

public class ClassifyRightItemBean {
    private int imageId;
    private String title;

    public ClassifyRightItemBean(int imageId, String title) {
        this.imageId = imageId;
        this.title = title;
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
}
