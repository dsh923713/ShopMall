package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseFragment;
import com.zmq.shopmall.utils.GlideImageLoader;

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


    private List<Integer> imageId;//图标集合
    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_goods_info, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        setBanner();
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
