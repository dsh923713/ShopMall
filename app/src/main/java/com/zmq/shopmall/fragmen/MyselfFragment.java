package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zmq.shopmall.R;
import com.zmq.shopmall.activity.NewsActivity;
import com.zmq.shopmall.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/13.
 */

public class MyselfFragment extends BaseFragment {
    @BindView(R.id.iv_bg)
    ImageView ivBg; //背景图
    @BindView(R.id.iv_user)
    ImageView ivUser;//用户
    @BindView(R.id.iv_user_max)
    ImageView ivUserMax; //用户大头像
    @BindView(R.id.toolbar)
    Toolbar toolbar; //标题栏
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout collapsing; //收缩控件
    @BindView(R.id.appbar)
    AppBarLayout appbar;//
    @BindView(R.id.tv_title)
    TextView tvTitle;//标题
    @BindView(R.id.iv_news)
    ImageView ivNews; //消息
    @BindView(R.id.iv_set)
    ImageView ivSet; //设置
    @BindView(R.id.tv_obligation)
    TextView tvObligation; //待付款
    @BindView(R.id.tv_wait_for_receive)
    TextView tvWaitForReceive; //到收货
    @BindView(R.id.tv_no_evaluated)
    TextView tvNoEvaluated; //待评价
    @BindView(R.id.tv_after_sale)
    TextView tvAfterSale; //退换/售后
    @BindView(R.id.tv_my_order)
    TextView tvMyOrder;//我的订单
    @BindView(R.id.rv_myself)
    RecyclerView rvMyself; //自定义布局

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_myself, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        /**
         * 根据appbar的高度来判断是否改变控件状态
         */
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                if (i == 0) { //展开状态
                    ivUser.setVisibility(View.GONE);
                    tvTitle.setVisibility(View.GONE);
                    ivNews.setImageResource(R.mipmap.ic_news);
                    ivSet.setImageResource(R.mipmap.ic_set);
                } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) { //折叠状态
                    ivUser.setVisibility(View.VISIBLE);
                    tvTitle.setVisibility(View.VISIBLE);
                    ivNews.setImageResource(R.mipmap.ic_news_black);
                    ivSet.setImageResource(R.mipmap.ic_set_black);
                } else {  //中间状态
                    ivUser.setVisibility(View.GONE);
                    tvTitle.setVisibility(View.GONE);
                    ivNews.setImageResource(R.mipmap.ic_news);
                    ivSet.setImageResource(R.mipmap.ic_set);
                }
            }
        });
    }

    @OnClick({R.id.iv_user, R.id.iv_user_max, R.id.iv_news, R.id.iv_set, R.id.tv_obligation, R.id.tv_wait_for_receive, R.id
            .tv_no_evaluated, R.id.tv_after_sale, R.id.tv_my_order})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_user: //用户
                showShortToast("用户");
                break;
            case R.id.iv_user_max: //用户大头像
                showShortToast("用户");
                break;
            case R.id.iv_news: //消息
                startActivity(NewsActivity.class);
                break;
            case R.id.iv_set: //设置
                showShortToast("设置");
                break;
            case R.id.tv_obligation: //待付款
                showShortToast("待付款");
                break;
            case R.id.tv_wait_for_receive:
                showShortToast("待收货");
                break;
            case R.id.tv_no_evaluated://待评价
                showShortToast("待评价");
                break;
            case R.id.tv_after_sale://退换/售后
                showShortToast("退换/售后");
                break;
            case R.id.tv_my_order: //我的订单
                showShortToast("我的订单");
                break;
            default:
                break;
        }
    }
}
