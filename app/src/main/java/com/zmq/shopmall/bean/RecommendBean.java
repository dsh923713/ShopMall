package com.zmq.shopmall.bean;

/**
 * Created by Administrator on 2017/6/10.
 */

public class RecommendBean {
    private int image;
    private String title;
    private double price;
    private boolean isFindSimilar;
    private boolean isShopTrolley;

    public RecommendBean(int image, String title, double price, boolean isFindSimilar, boolean isShopTrolley) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.isFindSimilar = isFindSimilar;
        this.isShopTrolley = isShopTrolley;
    }


    public boolean isShopTrolley() {
        return isShopTrolley;
    }

    public void setShopTrolley(boolean shopTrolley) {
        isShopTrolley = shopTrolley;
    }

    public boolean isFindSimilar() {
        return isFindSimilar;
    }

    public void setFindSimilar(boolean findSimilar) {
        isFindSimilar = findSimilar;
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
}
