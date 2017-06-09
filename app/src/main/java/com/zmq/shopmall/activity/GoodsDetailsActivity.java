package com.zmq.shopmall.activity;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.zmq.shopmall.R;
import com.zmq.shopmall.adapter.ItemTitlePagerAdapter;
import com.zmq.shopmall.base.BaseActivity;
import com.zmq.shopmall.fragmen.GoodsCommentFragment;
import com.zmq.shopmall.fragmen.GoodsDetailFragment;
import com.zmq.shopmall.fragmen.GoodsInfoFragment;
import com.zmq.shopmall.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/6/7.
 */

public class GoodsDetailsActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.psts_tabs)
    public PagerSlidingTabStrip pstsTabs;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.vp_content)
    public NoScrollViewPager vpContent;
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.iv_shape)
    ImageView ivShape;
    @BindView(R.id.tv_contact_the_seller)
    TextView tvContactTheSeller;
    @BindView(R.id.tv_shop)
    TextView tvShop;
    @BindView(R.id.tv_follow)
    TextView tvFollow;
    @BindView(R.id.tv_shopping_trolley)
    TextView tvShoppingTrolley;
    @BindView(R.id.tv_into_shopping_trolley)
    TextView tvIntoShoppingTrolley;

    private List<Fragment> fragmentList = new ArrayList<>();

    public GoodsDetailsActivity() {
        super(R.layout.activity_goods_details);
    }

    @Override
    protected void initView() {
        fragmentList.add(new GoodsInfoFragment());
        fragmentList.add(new GoodsDetailFragment());
        fragmentList.add(new GoodsCommentFragment());
        vpContent.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(), fragmentList, new String[]{"商品", "详情", "评论"}));
        vpContent.setOffscreenPageLimit(3);
        pstsTabs.setViewPager(vpContent);
        setListener();
    }

    /**
     * 注册按钮的点击事件
     */
    private void setListener() {
        llBack.setOnClickListener(this);
        ivShape.setOnClickListener(this);
        ivMore.setOnClickListener(this);
        tvContactTheSeller.setOnClickListener(this);
        tvShop.setOnClickListener(this);
        tvFollow.setOnClickListener(this);
        tvShoppingTrolley.setOnClickListener(this);
        tvIntoShoppingTrolley.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_back://返回
                finish();
                break;
            case R.id.iv_shape://分享
                break;
            case R.id.iv_more://更多
                break;
            case R.id.tv_contact_the_seller://联系客服
                break;
            case R.id.tv_shop://进入店铺
                break;
            case R.id.tv_follow://关注
                break;
            case R.id.tv_shopping_trolley://购物车
                break;
            case R.id.tv_into_shopping_trolley://加入购物车
                break;
            default:
                break;
        }
    }
}
