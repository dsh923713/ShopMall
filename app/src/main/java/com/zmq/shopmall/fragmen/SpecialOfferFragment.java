package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/6/13.
 */

public class SpecialOfferFragment extends BaseFragment {
    @BindView(R.id.stl_specical)
    SmartTabLayout stlSpecical;
    @BindView(R.id.vp_special)
    ViewPager vpSpecial;
    private FragmentPagerItemAdapter adapter;

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_special_offer, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        adapter = new FragmentPagerItemAdapter(activity.getSupportFragmentManager(), FragmentPagerItems.with(activity).add(R
                .string.myself, MyselfFragment.class).add(R.string.classify, ClassifyFragment.class).add(R.string.myself,
                MyselfFragment.class).add(R.string.classify, ClassifyFragment.class).add(R.string.myself, MyselfFragment.class)
                .add(R.string.classify, ClassifyFragment.class).add(R.string.myself, MyselfFragment.class).add(R.string
                        .classify, ClassifyFragment.class).add(R.string.myself, MyselfFragment.class).add(R.string.classify,
                        ClassifyFragment.class).create());
        vpSpecial.setAdapter(adapter);
        stlSpecical.setViewPager(vpSpecial);
    }

}
