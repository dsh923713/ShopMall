package com.zmq.shopmall.activity;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseActivity;
import com.zmq.shopmall.fragmen.MyCalendarFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/6/27.
 */

public class MyCalendarActivity extends BaseActivity {
    @BindView(R.id.stl_calendar)
    SmartTabLayout stlCalendar; //顶部导航
    @BindView(R.id.vp_calendar)
    ViewPager vpCalendar;//viewpager内容

    private FragmentPagerItemAdapter adapter;

    public MyCalendarActivity() {
        super(R.layout.activity_my_calendar);
    }

    @Override
    protected void initView() {
        setTitle("我的日历");
        setLeftIcon(R.mipmap.ic_back, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setRightIcon(R.mipmap.ic_calendar_item, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(), FragmentPagerItems.with(this).add(R.string
                .all, MyCalendarFragment.class).add(R.string.remind_list, MyCalendarFragment.class).add(R.string
                .home_furnishing, MyCalendarFragment.class).add(R.string.household_appliances, MyCalendarFragment.class).add(R
                .string.food_fresh, MyCalendarFragment.class).add(R.string.general_merchandise, MyCalendarFragment.class).add(R
                .string.shoe_and_bag, MyCalendarFragment.class).add(R.string.mobile_digital, MyCalendarFragment.class).add(R
                .string.horologe_jewelry, MyCalendarFragment.class).create());
        vpCalendar.setAdapter(adapter);
        stlCalendar.setViewPager(vpCalendar);
    }
}
