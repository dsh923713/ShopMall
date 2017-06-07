package com.zmq.shopmall.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.zmq.shopmall.R;
import com.zmq.shopmall.adapter.ItemTitlePagerAdapter;
import com.zmq.shopmall.base.BaseActivity;
import com.zmq.shopmall.fragmen.GoodsInfoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/6/7.
 */

public class GoodsDetailsActivity extends BaseActivity {
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.psts_tabs)
    PagerSlidingTabStrip pstsTabs;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.vp_content)
    ViewPager vpContent;
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.iv_shape)
    ImageView ivShape;

    private List<Fragment> fragmentList = new ArrayList<>();

    public GoodsDetailsActivity() {
        super(R.layout.activity_goods_details);
    }

    @Override
    protected void initView() {
        fragmentList.add(new GoodsInfoFragment());
        fragmentList.add(new GoodsInfoFragment());
        fragmentList.add(new GoodsInfoFragment());
        vpContent.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(), fragmentList, new String[]{"商品", "详情", "评论"}));
        vpContent.setOffscreenPageLimit(3);
        pstsTabs.setViewPager(vpContent);
    }

}
