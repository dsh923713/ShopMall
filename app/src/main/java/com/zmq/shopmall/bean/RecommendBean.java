package com.zmq.shopmall.bean;

/**
 * Created by Administrator on 2017/6/10.
 */

public class RecommendBean {
    private int image;
    private String title;
    private double price;
    private String findSimilar;

    public RecommendBean(int image, String title, double price, String findSimilar) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.findSimilar = findSimilar;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public String getFindSimilar() {
        return findSimilar;
    }

    public void setFindSimilar(String findSimilar) {
        this.findSimilar = findSimilar;
    }
}
