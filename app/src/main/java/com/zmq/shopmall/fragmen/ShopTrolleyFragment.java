package com.zmq.shopmall.fragmen;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.github.nuptboyzhb.lib.SuperSwipeRefreshLayout;
import com.zmq.shopmall.R;
import com.zmq.shopmall.activity.GoodsDetailsActivity;
import com.zmq.shopmall.adapter.HomeFootAdapter;
import com.zmq.shopmall.base.BaseFragment;
import com.zmq.shopmall.bean.RecommendBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/12.
 */

public class ShopTrolleyFragment extends BaseFragment {
    @BindView(R.id.tv_login)
    TextView tvLogin; //登录按钮
    @BindView(R.id.tv_shop_isempty)
    TextView tvShopIsempty; //购物车为空
    @BindView(R.id.tv_good_goods)
    TextView tvGoodGoods;//抢好货
    @BindView(R.id.tv_look_follow)
    TextView tvLookFollow;//看看关注
    @BindView(R.id.rv_shop_trolley)
    RecyclerView rvShopTrolley; //购物车列表
    @BindView(R.id.rv_shop_of_you)
    RecyclerView rvShopOfYou; //推荐列表
    @BindView(R.id.nsv_shop_trolley)
    NestedScrollView nsvShopTrolley; //整体滑动控件
    @BindView(R.id.srl_shop_trolley)
    SuperSwipeRefreshLayout srlShopTrolley; //下拉刷新
    private View v1; //下拉刷新头布局
    private ImageView ivHead; //下拉刷新图片
    private TextView tvHead; //下拉刷新文字

    private List<RecommendBean> data = new ArrayList<>();
    private HomeFootAdapter ofYouAdapter;

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop_trolley, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        setOfYouData();
        setRefresh();
        ofYouAdapter = new HomeFootAdapter(data);
        rvShopOfYou.setLayoutManager(new GridLayoutManager(activity, 2));
        rvShopOfYou.setAdapter(ofYouAdapter);
        ofYouAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(GoodsDetailsActivity.class);
            }
        });
        ofYouAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                showShortToast("加入购物车");
            }
        });
    }

    /**
     * 设置下拉刷新 上拉加载
     */
    private void setRefresh() {
        v1 = View.inflate(activity, R.layout.item_superswiper_head, null);
        ivHead = (ImageView) v1.findViewById(R.id.iv_head);
        tvHead = (TextView) v1.findViewById(R.id.tv_head);
        srlShopTrolley.setHeaderView(v1);
        srlShopTrolley.setTargetScrollWithLayout(true);
        srlShopTrolley.setOnPullRefreshListener(new SuperSwipeRefreshLayout.OnPullRefreshListener() {
            @Override
            public void onRefresh() {//TODO 开始刷新
                tvHead.setText("更新中...");
                final AnimationDrawable anima = (AnimationDrawable) ivHead.getDrawable();
                anima.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (srlShopTrolley != null) {
                            srlShopTrolley.setRefreshing(false);
                            anima.stop();
                        }
                    }
                }, 3000);
            }

            @Override
            public void onPullDistance(int i) {//TODO 下拉距离

            }

            @Override
            public void onPullEnable(boolean b) {//TODO 下拉过程中，下拉的距离是否足够出发刷新
//                ivHead
                tvHead.setText(b ? "松开刷新..." : "下拉刷新...");
            }
        });
        srlShopTrolley.setOnPushLoadMoreListener(new SuperSwipeRefreshLayout.OnPushLoadMoreListener() {
            @Override
            public void onLoadMore() {
                srlShopTrolley.setLoadMore(false);
            }

            @Override
            public void onPushDistance(int i) {// TODO 上拉距离

            }

            @Override
            public void onPushEnable(boolean b) {//TODO 上拉过程中，上拉的距离是否足够出发刷新

            }
        });
    }

    @OnClick({R.id.tv_good_goods, R.id.tv_look_follow})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_good_goods:
                showShortToast("抢好货");
                break;
            case R.id.tv_look_follow:
                showShortToast("看看关注");
                break;
            default:
                break;
        }
    }


    /**
     * 推荐列表模拟数据
     */
    private void setOfYouData() {
        data.clear();
        data.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, true));
        data.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, true));
        data.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, true));
        data.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, true));
        data.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, true));
        data.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, true));
        data.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, true));
        data.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, true));
        data.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, true));
        data.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, true));
    }
}
