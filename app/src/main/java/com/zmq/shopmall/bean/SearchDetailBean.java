package com.zmq.shopmall.bean;

/**
 * Created by Administrator on 2017/6/20.
 */

public class SearchDetailBean {
    private int imageId;
    private String title;
    private double price;
    private int recommend;
    private int goodRecommend;

    public SearchDetailBean(int imageId, String title, double price, int recommend, int goodRecommend) {
        this.imageId = imageId;
        this.title = title;
        this.price = price;
        this.recommend = recommend;
        this.goodRecommend = goodRecommend;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public int getGoodRecommend() {
        return goodRecommend;
    }

    public void setGoodRecommend(int goodRecommend) {
        this.goodRecommend = goodRecommend;
    }
}
