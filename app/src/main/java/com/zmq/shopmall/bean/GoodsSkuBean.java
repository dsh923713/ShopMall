package com.zmq.shopmall.bean;

import java.util.List;

/**
 * 商品属性
 * Created by Administrator on 2017/6/14.
 */

public class GoodsSkuBean {
    private String sku;
    private List<GoodsSkuChild> goodsSku;

    public GoodsSkuBean(String sku, List<GoodsSkuChild> goodsSku) {
        this.sku = sku;
        this.goodsSku = goodsSku;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<GoodsSkuChild> getGoodsSku() {
        return goodsSku;
    }

    public void setGoodsSku(List<GoodsSkuChild> goodsSku) {
        this.goodsSku = goodsSku;
    }

    public static class GoodsSkuChild {
        private String skuName;

        public GoodsSkuChild(String skuName) {
            this.skuName = skuName;
        }

        public String getSkuName() {
            return skuName;
        }

        public void setSkuName(String skuName) {
            this.skuName = skuName;
        }
    }
}
