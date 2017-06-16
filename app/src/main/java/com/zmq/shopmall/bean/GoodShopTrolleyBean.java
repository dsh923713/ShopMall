package com.zmq.shopmall.bean;

/**
 * Created by Administrator on 2017/6/16.
 */

public class GoodShopTrolleyBean {
    private boolean isChecked;
    private String shopName;
    private int ImageId;
    private String goodsName;
    private String goodsAttribute;
    private double goodsPrice;

    public GoodShopTrolleyBean(boolean isChecked, String shopName, int imageId, String goodsName, String goodsAttribute, double
            goodsPrice) {
        this.isChecked = isChecked;
        this.shopName = shopName;
        ImageId = imageId;
        this.goodsName = goodsName;
        this.goodsAttribute = goodsAttribute;
        this.goodsPrice = goodsPrice;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsAttribute() {
        return goodsAttribute;
    }

    public void setGoodsAttribute(String goodsAttribute) {
        this.goodsAttribute = goodsAttribute;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
