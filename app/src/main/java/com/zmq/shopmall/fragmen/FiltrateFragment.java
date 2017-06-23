package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 搜索的筛选界面
 * Created by Administrator on 2017/6/22.
 */

public class FiltrateFragment extends BaseFragment implements DeliveryAddressFragment.AddressListener {
    @BindView(R.id.et_low_price)
    EditText etLowPrice;
    @BindView(R.id.et_height_price)
    EditText etHeightPrice;
    private TextView tvDeliveryCity; //收货地址
    @BindView(R.id.rv_filtrate_service)
    RecyclerView rvFiltrateService; //服务筛选列表
    LinearLayout llPriceSelect;
    @BindView(R.id.rl_all_classify)
    RelativeLayout rlAllClassify;
    @BindView(R.id.rv_classify)
    RecyclerView rvClassify;
    @BindView(R.id.tv_reset)
    TextView tvReset;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;


    private DeliveryAddressFragment deliveryAddressFragment;

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_filtrate, container, false);
        tvDeliveryCity = (TextView) view.findViewById(R.id.tv_delivery_city);
        return view;
    }

    @Override
    protected void initView(View view) {

    }

    @OnClick({R.id.rl_all_classify, R.id.tv_delivery_city, R.id.rb_price_select1, R.id.rb_price_select2, R.id.rb_price_select3})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_all_classify:
                replaceFragment(R.id.dl_content, new DeliveryAddressFragment());
                break;
            case R.id.tv_delivery_city:
                deliveryAddressFragment = new DeliveryAddressFragment();
                deliveryAddressFragment.getAddressListener(this);
                replaceFragment(R.id.dl_content, deliveryAddressFragment);
                break;
            case R.id.rb_price_select1:
                etLowPrice.setText("11");
                etHeightPrice.setText("22");
                break;
            case R.id.rb_price_select2:
                etLowPrice.setText("22");
                etHeightPrice.setText("44");
                break;
            case R.id.rb_price_select3:
                etLowPrice.setText("44");
                etHeightPrice.setText("66");
                break;
            default:
                break;
        }
    }

    @Override
    public void getAddress(String address) {
        tvDeliveryCity.setText(address);
    }
}
