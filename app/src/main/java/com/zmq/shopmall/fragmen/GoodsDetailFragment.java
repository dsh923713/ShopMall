package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseFragment;

import butterknife.BindView;

/**
 * 商品详情
 * Created by Administrator on 2017/6/7.
 */

public class GoodsDetailFragment extends BaseFragment {
    @BindView(R.id.rb_goods_introduce)
    RadioButton rbGoodsIntroduce;
    @BindView(R.id.rb_specification_parameter)
    RadioButton rbSpecificationParameter;
    @BindView(R.id.rb_packaging_after_sale)
    RadioButton rbPackagingAfterSale;
    @BindView(R.id.rg_goods)
    RadioGroup rgGoods;
    @BindView(R.id.fl_content)
    FrameLayout flContent;

    private Fragment nowFragment;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private GoodsDetailWebFragment goodsDetailWebFragment;

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.goods_detail_item_tab, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        setGoodsDetail();
        setRgListener();
    }
    private void setGoodsDetail() {
        goodsDetailWebFragment = new GoodsDetailWebFragment(2);
        nowFragment = goodsDetailWebFragment;
        fragmentManager = getChildFragmentManager();
        //默认显示商品详情tab
        fragmentManager.beginTransaction().replace(R.id.fl_content, nowFragment).commitAllowingStateLoss();
    }
    /**
     * 设置radiogroup监听
     */
    private void setRgListener() {
        rgGoods.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (R.id.rb_goods_introduce == checkedId) {
                    rbGoodsIntroduce.setChecked(true);
                    rbGoodsIntroduce.setTextColor(ContextCompat.getColor(activity, R.color.red));
                    rbSpecificationParameter.setChecked(false);
                    rbSpecificationParameter.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    rbPackagingAfterSale.setChecked(false);
                    rbPackagingAfterSale.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    switchFragment(nowFragment, goodsDetailWebFragment);
                    nowFragment = goodsDetailWebFragment;
                    return;
                }
                if (R.id.rb_specification_parameter == checkedId) {
                    rbSpecificationParameter.setChecked(true);
                    rbSpecificationParameter.setTextColor(ContextCompat.getColor(activity, R.color.red));
                    rbGoodsIntroduce.setChecked(false);
                    rbGoodsIntroduce.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    rbPackagingAfterSale.setChecked(false);
                    rbPackagingAfterSale.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    return;
                }
                if (R.id.rb_packaging_after_sale == checkedId) {
                    rbPackagingAfterSale.setChecked(true);
                    rbPackagingAfterSale.setTextColor(ContextCompat.getColor(activity, R.color.red));
                    rbSpecificationParameter.setChecked(false);
                    rbSpecificationParameter.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    rbGoodsIntroduce.setChecked(false);
                    rbGoodsIntroduce.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    return;
                }
            }
        });
    }

    /**
     * 切换Fragment
     * <p>(hide、show、add)
     *
     * @param fromFragment
     * @param toFragment
     */
    private void switchFragment(Fragment fromFragment, Fragment toFragment) {
        if (nowFragment != toFragment) {
            fragmentTransaction = fragmentManager.beginTransaction();
            if (!toFragment.isAdded()) {    // 先判断是否被add过
                fragmentTransaction.hide(fromFragment).add(R.id.fl_content, toFragment).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到activity中
            } else {
                fragmentTransaction.hide(fromFragment).show(toFragment).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
        }
    }
}
