package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zmq.shopmall.R;
import com.zmq.shopmall.adapter.CalendarAdapter;
import com.zmq.shopmall.base.BaseFragment;
import com.zmq.shopmall.bean.CalendarBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/6/27.
 */

public class MyCalendarFragment extends BaseFragment {
    @BindView(R.id.rv_calendar)
    RecyclerView rvCalendar;

    private List<CalendarBean> mData;
    private List<CalendarBean.CalendarChildBean> mItemData;

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calendar, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        setmData();
        rvCalendar.setLayoutManager(new LinearLayoutManager(activity));
        rvCalendar.setAdapter(new CalendarAdapter(mData));
    }

    private void setmData() {
        mData = new ArrayList<>();
        mItemData = new ArrayList<>();
        mItemData.add(new CalendarBean.CalendarChildBean("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1089399937," +
                "" + "" + "" + "1684001946&fm=26&gp=0.jpg", "海尔特惠26日特价促销"));
        mItemData.add(new CalendarBean.CalendarChildBean("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=787324823,"
                + "4149955059&fm=26&gp=0.jpg," + "" + "1684001946&fm=26&gp=0.jpg", "海尔特惠27日特价促销"));
        mItemData.add(new CalendarBean.CalendarChildBean("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3241219306," +
                "" + "" + "" + "1400876595&fm=26&gp=0.jpg", "天猫特惠27日特价促销"));
        mData.add(new CalendarBean(1498536185000l, mItemData));
        mData.add(new CalendarBean(1498622585000l, mItemData));
        mData.add(new CalendarBean(1498708985000l, mItemData));
    }
}
