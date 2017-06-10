package com.zmq.shopmall.activity;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/10.
 */

public class NewsActivity extends BaseActivity {
    @BindView(R.id.rv_special)
    RecyclerView rvSpecial; //消息列表
    @BindView(R.id.tv_no_login)
    TextView tvNoLogin; //未登录状态
    @BindView(R.id.tv_news)
    TextView tvNews; //消息
    @BindView(R.id.tv_subscription)
    TextView tvSubscription; //订阅号

    private boolean isNews = true; //是否选中消息
    private boolean isSubscription; //是否选中订阅号
    private Drawable drawable; //图片切换



    public NewsActivity() {
        super(R.layout.activity_news);
    }

    @Override
    protected void initView() {
        setTitle("消息中心");
        setLeftIcon(R.mipmap.ic_back, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setRightIcon(R.mipmap.ic_calendar, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShortToast("日历");
           }
        });

        tvNews.setClickable(false);//默认选中消息，先禁用其点击
    }




    @OnClick({R.id.tv_no_login,R.id.tv_news,R.id.tv_subscription})
    void onClick(View v){
        switch (v.getId()){
            case R.id.tv_no_login: //未登录 跳转到登录界面
                showShortToast("登录");
                break;
            case R.id.tv_news: //消息
                tvNews.setClickable(false);
                tvSubscription.setClickable(true);
                isNews = true;
                isSubscription = false;
                break;
            case R.id.tv_subscription:  //订阅号
                tvNews.setClickable(true);
                tvSubscription.setClickable(false);
                isNews = false;
                isSubscription = true;
                break;
            default:
                break;
        }
        isNewsOrSubscription();
    }

    /**
     * 判断点击的是消息还是订阅号
     */
    private void isNewsOrSubscription() {
        if (isNews){
            tvNews.setTextColor(ContextCompat.getColor(this, R.color.red));
            drawable = ContextCompat.getDrawable(this, R.mipmap.ic_news_red);
            // 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvNews.setCompoundDrawables(null, drawable, null, null);
        }else {
            tvNews.setTextColor(ContextCompat.getColor(this, R.color.t313131));
            drawable = ContextCompat.getDrawable(this, R.mipmap.ic_news_normal);
            // 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvNews.setCompoundDrawables(null, drawable, null, null);
        }
        if (isSubscription){
            tvSubscription.setTextColor(ContextCompat.getColor(this, R.color.red));
            drawable = ContextCompat.getDrawable(this, R.mipmap.ic_subscription_red);
            // 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvSubscription.setCompoundDrawables(null, drawable, null, null);
        }else {
            tvSubscription.setTextColor(ContextCompat.getColor(this, R.color.t313131));
            drawable = ContextCompat.getDrawable(this, R.mipmap.ic_subscription_normal);
            // 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvSubscription.setCompoundDrawables(null, drawable, null, null);
        }
    }
}
