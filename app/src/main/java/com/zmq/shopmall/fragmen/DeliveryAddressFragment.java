package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseFragment;
import com.zmq.shopmall.utils.LogUtils;

import butterknife.BindView;
import butterknife.OnClick;
import chihane.jdaddressselector.AddressSelector;
import chihane.jdaddressselector.OnAddressSelectedListener;
import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;

/**
 * Created by Administrator on 2017/6/23.
 */

public class DeliveryAddressFragment extends BaseFragment implements OnAddressSelectedListener {
    @BindView(R.id.iv_clear)
    ImageView ivClear; //关闭
    @BindView(R.id.fl_address)
    FrameLayout flAddress; //内容容器
    private FragmentManager fragmentManager; //当前fragment管理器

   private AddressListener listener;


    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_delivery_address, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        fragmentManager = getFragmentManager();
        AddressSelector selector = new AddressSelector(activity);
        View selectorView = selector.getView();
        flAddress.addView(selectorView);
        selector.setOnAddressSelectedListener(this);
    }

    @Override
    public void onAddressSelected(Province province, City city, County county, Street street) {
        String address = (province == null ? "" : province.name) + (city == null ? "" : city.name) + (county == null ? "" :
                county.name) + (street == null ? "" : street.name);
        if (listener != null){
            LogUtils.e(address);
            listener.getAddress(address);
        }
        fragmentManager.popBackStack();//将当前的事务退出回退栈
    }

    @OnClick(R.id.iv_clear)
    void onClick(View v){
        switch (v.getId()){
            case R.id.iv_clear:
                fragmentManager.popBackStack();//将当前的事务退出回退栈
                break;
            default:
                break;
        }
    }

    public void getAddressListener(AddressListener listener){
        this.listener = listener;
    }

    interface AddressListener{
        void getAddress(String address);
    }

}
