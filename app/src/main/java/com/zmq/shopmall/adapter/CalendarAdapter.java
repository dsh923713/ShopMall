package com.zmq.shopmall.adapter;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.bean.CalendarBean;
import com.zmq.shopmall.utils.DateUtil;
import com.zmq.shopmall.utils.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */

public class CalendarAdapter extends BaseQuickAdapter<CalendarBean, BaseViewHolder> {

    List<String> remindList = new ArrayList<>();
    private boolean[] isOnclick;

    public CalendarAdapter(@Nullable List<CalendarBean> data) {
        super(R.layout.rv_item_calendar, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, final CalendarBean item) {
        isOnclick = new boolean[item.getCalendarChildList().size()];
        holder.setText(R.id.tv_date, DateUtil.millis2String(item.getDate(), new SimpleDateFormat("MM月dd日"))).setText(R.id
                .tv_week, DateUtil.getChineseWeek(item.getDate())); //设置显示时间
        RecyclerView rvItemCalendar = holder.getView(R.id.rv_item_calendar);
        RecyclerView rvItemCalendarRemind = holder.getView(R.id.rv_item_calendar_remind);
        final LinearLayout llRemindList = holder.getView(R.id.ll_remind_list);
        rvItemCalendarRemind.setLayoutManager(new LinearLayoutManager(mContext));
        rvItemCalendar.setLayoutManager(new LinearLayoutManager(mContext));
        final CalendarChildRemindAdapter remindAdapter = new CalendarChildRemindAdapter(remindList);
        CalendarChildAdapter adapter = new CalendarChildAdapter(item.getDate(), item.getCalendarChildList());
        rvItemCalendarRemind.setAdapter(remindAdapter);
        rvItemCalendar.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShortToast(mContext, item.getCalendarChildList().get(position).getTitle());
            }
        });

        /**活动子元素点击事件**/
        adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (!DateUtil.isToday(item.getDate())) {
                    //获取子列表数据
                    CalendarBean.CalendarChildBean adapterItem = (CalendarBean.CalendarChildBean) adapter.getItem(position);
                    if (isOnclick[position]) {
                        isOnclick[position] = false;
                        remindList.remove(adapterItem.getTitle());
                        if (remindList.size() == 0) {
                            llRemindList.setVisibility(View.GONE);
                        }
                    } else {
                        isOnclick[position] = true;
                        llRemindList.setVisibility(View.VISIBLE);
                        remindList.add(adapterItem.getTitle());
                    }
                    remindAdapter.notifyDataSetChanged();
                    adapter.notifyDataSetChanged();
                } else {
                    ToastUtils.showShortToast(mContext, "进行中");
                }
            }
        });

        /**提醒列表点击事件**/
        remindAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShortToast(mContext, remindList.get(position));
            }
        });
    }

    public class CalendarChildAdapter extends BaseQuickAdapter<CalendarBean.CalendarChildBean, BaseViewHolder> {
        private long date;

        public CalendarChildAdapter(long date, @Nullable List<CalendarBean.CalendarChildBean> data) {
            super(R.layout.rv_item_child_calendar, data);
            this.date = date;
        }

        @Override
        protected void convert(BaseViewHolder holder, CalendarBean.CalendarChildBean item) {
            Glide.with(mContext).load(item.getImageId()).into((ImageView) holder.getView(R.id.ic_bg));
            holder.setText(R.id.tv_calendar_title, item.getTitle());
            holder.setText(R.id.tv_remind, DateUtil.isToday(date) ? "进行中 ->" : "添加提醒");
            if (!DateUtil.isToday(date)) {
                holder.setText(R.id.tv_remind, isOnclick[holder.getAdapterPosition()] ? "取消提醒" : "添加提醒");
                holder.setBackgroundColor(R.id.tv_remind, isOnclick[holder.getAdapterPosition()] ? ContextCompat.getColor
                        (mContext, R.color.mb_gray) : ContextCompat.getColor(mContext, R.color.tf25d53));
            }
            holder.addOnClickListener(R.id.tv_remind);
        }
    }

    public class CalendarChildRemindAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public CalendarChildRemindAdapter(@Nullable List<String> data) {
            super(R.layout.rv_item_child_remind_calendar, data);
        }

        @Override
        protected void convert(BaseViewHolder holder, String item) {
            TextView tvRemindTime = holder.getView(R.id.tv_remind_time);
            tvRemindTime.setVisibility(holder.getAdapterPosition() == 0 ? View.VISIBLE : View.INVISIBLE);
            holder.setText(R.id.tv_title, item);
        }
    }
}
