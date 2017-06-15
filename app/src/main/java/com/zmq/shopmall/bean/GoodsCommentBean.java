package com.zmq.shopmall.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */

public class GoodsCommentBean {
    private int userIcon;
    private String userName;
    private int srbRating;
    private String goodsComment;
    private List<GoodsCommentImage> images;

    public GoodsCommentBean(int userIcon, String userName, int srbRating, String goodsComment, List<GoodsCommentImage> images) {
        this.userIcon = userIcon;
        this.userName = userName;
        this.srbRating = srbRating;
        this.goodsComment = goodsComment;
        this.images = images;
    }

    public String getGoodsComment() {
        return goodsComment;
    }

    public void setGoodsComment(String goodsComment) {
        this.goodsComment = goodsComment;
    }

    public int getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(int userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSrbRating() {
        return srbRating;
    }

    public void setSrbRating(int srbRating) {
        this.srbRating = srbRating;
    }

    public List<GoodsCommentImage> getImages() {
        return images;
    }

    public void setImages(List<GoodsCommentImage> images) {
        this.images = images;
    }

    public static class GoodsCommentImage {
        private String imageId;

        public GoodsCommentImage(String imageId) {
            this.imageId = imageId;
        }

        public String getImageId() {
            return imageId;
        }

        public void setImageId(String imageId) {
            this.imageId = imageId;
        }
    }
}
