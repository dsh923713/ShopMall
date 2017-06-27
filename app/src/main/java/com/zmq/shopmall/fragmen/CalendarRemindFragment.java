package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/6/27.
 */

public class CalendarRemindFragment extends BaseFragment {
    @BindView(R.id.rv_item_calendar_remind)
    RecyclerView rvItemCalendarRemind;

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.rv_item_remind_calendar, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {

    }
}
