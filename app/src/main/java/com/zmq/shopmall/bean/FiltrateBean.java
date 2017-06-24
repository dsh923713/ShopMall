package com.zmq.shopmall.bean;

import java.util.List;

/**
 * 筛选实例
 * Created by Administrator on 2017/6/24.
 */

public class FiltrateBean {
    private List<FiltrateServiceBean> serviceList;
    private List<FiltrateClassifyBean> classifyList;

    public FiltrateBean(List<FiltrateServiceBean> serviceList, List<FiltrateClassifyBean> classifyList) {
        this.serviceList = serviceList;
        this.classifyList = classifyList;
    }

    public List<FiltrateServiceBean> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<FiltrateServiceBean> serviceList) {
        this.serviceList = serviceList;
    }

    public List<FiltrateClassifyBean> getClassifyList() {
        return classifyList;
    }

    public void setClassifyList(List<FiltrateClassifyBean> classifyList) {
        this.classifyList = classifyList;
    }


    public static class FiltrateServiceBean {
        private String title;

        public FiltrateServiceBean(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }


    public static class FiltrateClassifyBean {
        private String title;
        private List<FiltrateClassifyItemBean> classifyItemList;

        public FiltrateClassifyBean(String title, List<FiltrateClassifyItemBean> classifyItemList) {
            this.title = title;
            this.classifyItemList = classifyItemList;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<FiltrateClassifyItemBean> getClassifyItemList() {
            return classifyItemList;
        }

        public void setClassifyItemList(List<FiltrateClassifyItemBean> classifyItemList) {
            this.classifyItemList = classifyItemList;
        }
    }


    public static class FiltrateClassifyItemBean {
        private String title;

        public FiltrateClassifyItemBean(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
