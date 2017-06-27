package com.zmq.shopmall.bean;

import java.util.List;

/**
 * 我的日历
 * Created by Administrator on 2017/6/27.
 */

public class CalendarBean {
    private long date;
    private List<CalendarChildBean> calendarChildList;

    public CalendarBean(long date, List<CalendarChildBean> calendarChildList) {
        this.date = date;
        this.calendarChildList = calendarChildList;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public List<CalendarChildBean> getCalendarChildList() {
        return calendarChildList;
    }

    public void setCalendarChildList(List<CalendarChildBean> calendarChildList) {
        this.calendarChildList = calendarChildList;
    }

    public static class CalendarChildBean{
        private String imageId;
        private String title;

        public CalendarChildBean(String imageId, String title) {
            this.imageId = imageId;
            this.title = title;
        }

        public String getImageId() {
            return imageId;
        }

        public void setImageId(String imageId) {
            this.imageId = imageId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
