package com.zmq.shopmall.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */

public class ClassifyLeftBean {
    private String title;
    private List<ClassifyRightBean> rightBeanList;

    public List<ClassifyRightBean> getRightBeanList() {
        return rightBeanList;
    }

    public void setRightBeanList(List<ClassifyRightBean> rightBeanList) {
        this.rightBeanList = rightBeanList;
    }

    public ClassifyLeftBean(String title) {
        this.title = title;
    }

    public ClassifyLeftBean(String title, List<ClassifyRightBean> rightBeanList) {
        this.title = title;
        this.rightBeanList = rightBeanList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
