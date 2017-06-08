package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseFragment;
import com.zmq.shopmall.utils.GlideImageLoader;
import com.zmq.shopmall.widget.Page;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 商品
 * Created by Administrator on 2017/6/7.
 */

public class GoodsInfoFragment extends BaseFragment {
    @BindView(R.id.iv_banner)
    Banner ivBanner;
    @BindView(R.id.tv_goods_title)
    TextView tvGoodsTitle;
    @BindView(R.id.tv_new_price)
    TextView tvNewPrice;
    @BindView(R.id.tv_current_goods)
    TextView tvCurrentGoods;
    @BindView(R.id.ll_current_goods)
    LinearLayout llCurrentGoods;
    @BindView(R.id.tv_delivery_address)
    TextView tvDeliveryAddress;
    @BindView(R.id.tv_spot_goods_content)
    TextView tvSpotGoodsContent;
    @BindView(R.id.tv_goods_quality)
    TextView tvGoodsQuality;
    @BindView(R.id.tv_goods_quality_content)
    TextView tvGoodsQualityContent;
    @BindView(R.id.tv_comment_count)
    TextView tvCommentCount;
    @BindView(R.id.tv_good_comment)
    TextView tvGoodComment;
    @BindView(R.id.ll_comment)
    LinearLayout llComment;
    @BindView(R.id.rv_comment)
    RecyclerView rvComment;
    @BindView(R.id.tv_inquire)
    TextView tvInquire;
    @BindView(R.id.iv_shop_icon)
    ImageView ivShopIcon;
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    @BindView(R.id.tv_shop_introduce)
    TextView tvShopIntroduce;
    @BindView(R.id.tv_goods_grade)
    TextView tvGoodsGrade;
    @BindView(R.id.tv_serve_grade)
    TextView tvServeGrade;
    @BindView(R.id.tv_logistics_grade)
    TextView tvLogisticsGrade;
    @BindView(R.id.ll_shop_grade)
    LinearLayout llShopGrade;
    @BindView(R.id.tv_follow_num)
    TextView tvFollowNum;
    @BindView(R.id.tv_all_shop)
    TextView tvAllShop;
    @BindView(R.id.tv_shop_status)
    TextView tvShopStatus;
    @BindView(R.id.tv_server)
    TextView tvServer;
    @BindView(R.id.tv_into_shop)
    TextView tvIntoShop;
    @BindView(R.id.tv_of_you_recommend)
    TextView tvOfYouRecommend;
    @BindView(R.id.tv_rank)
    TextView tvRank;
    @BindView(R.id.rv_shop_of_you)
    RecyclerView rvShopOfYou;
    @BindView(R.id.tv_examine_image)
    TextView tvExamineImage;
    @BindView(R.id.pageOne)
    Page pageOne;
    @BindView(R.id.tv_goods_introduce)
    TextView tvGoodsIntroduce;
    @BindView(R.id.tv_specification_parameter)
    TextView tvSpecificationParameter;
    @BindView(R.id.tv_packaging_after_sale)
    TextView tvPackagingAfterSale;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.fab_up_slide)
    FloatingActionButton fabUpSlide;


    private List<Integer> imageId;//图标集合

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_goods_info, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        setBanner();
        fabUpSlide.hide();
        pageOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent ev) {
                switch (ev.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });
    }

    /**
     * 设置轮播模式
     */
    private void setBanner() {
        getImageList();
        //设置banner样式
        ivBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        ivBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        ivBanner.setImages(imageId);
        //设置banner动画效果
        ivBanner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        ivBanner.isAutoPlay(false);
        //设置指示器位置（当banner模式中有指示器时）
        ivBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        ivBanner.start();
    }

    /**
     * 添加头部轮播图
     */
    private void getImageList() {
        imageId = new ArrayList<>();
        imageId.add(R.mipmap.im1);
        imageId.add(R.mipmap.im2);
        imageId.add(R.mipmap.im3);
        imageId.add(R.mipmap.im4);
    }
}
