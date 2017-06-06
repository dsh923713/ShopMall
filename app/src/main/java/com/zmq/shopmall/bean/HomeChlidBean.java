package com.zmq.shopmall.bean;

/**
 * 首页分组子布局
 * Created by Administrator on 2017/6/6.
 */

public class HomeChlidBean {

    private String title;//标题
    private String preferential; //优惠
    private int imageId1;//图片地址
    private int imageId2;//图片地址

    public HomeChlidBean(String title, String preferential, int imageId1, int imageId2) {
        this.title = title;
        this.preferential = preferential;
        this.imageId1 = imageId1;
        this.imageId2 = imageId2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreferential() {
        return preferential;
    }

    public void setPreferential(String preferential) {
        this.preferential = preferential;
    }

    public int getImageId1() {
        return imageId1;
    }

    public void setImageId1(int imageId1) {
        this.imageId1 = imageId1;
    }

    public int getImageId2() {
        return imageId2;
    }

    public void setImageId2(int imageId2) {
        this.imageId2 = imageId2;
    }
}
