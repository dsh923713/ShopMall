package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zmq.shopmall.R;
import com.zmq.shopmall.adapter.FiltrateClassifyAdapter;
import com.zmq.shopmall.adapter.FiltrateServiceAdapter;
import com.zmq.shopmall.base.BaseFragment;
import com.zmq.shopmall.bean.FiltrateBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 搜索的筛选界面
 * Created by Administrator on 2017/6/22.
 */

public class FiltrateFragment extends BaseFragment implements DeliveryAddressFragment.AddressListener {
    @BindView(R.id.et_low_price)
    EditText etLowPrice; //最低价
    @BindView(R.id.et_height_price)
    EditText etHeightPrice; //最高价
    @BindView(R.id.rb_price_select1)
    RadioButton rbPriceSelect1; //价格选择按钮一
    @BindView(R.id.rb_price_select2)
    RadioButton rbPriceSelect2;//价格选择按钮二
    @BindView(R.id.rb_price_select3)
    RadioButton rbPriceSelect3;//价格选择按钮三
    @BindView(R.id.rg_price_select)
    RadioGroup rgPriceSelect; ////价格选择按钮父控件
    private TextView tvDeliveryCity; //收货地址
    @BindView(R.id.rv_filtrate_service)
    RecyclerView rvFiltrateService; //服务筛选列表
    @BindView(R.id.rl_all_classify)
    RelativeLayout rlAllClassify; //所有分类
    @BindView(R.id.rv_classify)
    RecyclerView rvClassify; //分类列表
    @BindView(R.id.tv_reset)
    TextView tvReset; //重置
    @BindView(R.id.tv_confirm)
    TextView tvConfirm; //确定
    private FiltrateBean filtrateBean;


    private DeliveryAddressFragment deliveryAddressFragment;

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_filtrate, container, false);
        tvDeliveryCity = (TextView) view.findViewById(R.id.tv_delivery_city);
        return view;
    }

    @Override
    protected void initView(View view) {
        setFiltrateBean();
        rvFiltrateService.setLayoutManager(new GridLayoutManager(activity, 3));
        rvFiltrateService.setAdapter(new FiltrateServiceAdapter(filtrateBean.getServiceList()));
        rvClassify.setLayoutManager(new LinearLayoutManager(activity));
        rvClassify.setAdapter(new FiltrateClassifyAdapter(filtrateBean.getClassifyList()));
    }


    private boolean isSelect1;
    private boolean isSelect2;
    private boolean isSelect3;

    @OnClick({R.id.rl_all_classify, R.id.tv_delivery_city, R.id.rb_price_select1, R.id.rb_price_select2, R.id.rb_price_select3})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_all_classify: //全部分类
                replaceFragment(R.id.dl_content, new FiltrateAllClassifyFragment());
                break;
            case R.id.tv_delivery_city: //选择地址
                deliveryAddressFragment = new DeliveryAddressFragment();
                deliveryAddressFragment.getAddressListener(this);
                replaceFragment(R.id.dl_content, deliveryAddressFragment);
                break;
            case R.id.rb_price_select1: //价格选择按钮一
                if (isSelect1) {
                    isSelect1 = false;
                    etLowPrice.setText("");
                    etHeightPrice.setText("");
                    rgPriceSelect.clearCheck();
                } else {
                    isSelect1 = true;
                    isSelect2 = false;
                    isSelect3 = false;
                    etLowPrice.setText("11");
                    etHeightPrice.setText("22");
                }
                break;
            case R.id.rb_price_select2://价格选择按钮二
                if (isSelect2) {
                    isSelect2 = false;
                    etLowPrice.setText("");
                    etHeightPrice.setText("");
                    rgPriceSelect.clearCheck();
                } else {
                    isSelect1 = false;
                    isSelect2 = true;
                    isSelect3 = false;
                    etLowPrice.setText("22");
                    etHeightPrice.setText("44");
                }
                break;
            case R.id.rb_price_select3://价格选择按钮三
                if (isSelect3) {
                    isSelect3 = false;
                    etLowPrice.setText("");
                    etHeightPrice.setText("");
                    rgPriceSelect.clearCheck();
                } else {
                    isSelect1 = false;
                    isSelect2 = false;
                    isSelect3 = true;
                    etLowPrice.setText("44");
                    etHeightPrice.setText("66");
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void getAddress(String address) {
        tvDeliveryCity.setText(address);
    }


    /**
     * 模拟筛选信息数据
     */
    private void setFiltrateBean() {
        setFiltrateService();
        setFiltrateClassify();
        filtrateBean = new FiltrateBean(serviceBeanList, classifyList);
    }

    private List<FiltrateBean.FiltrateServiceBean> serviceBeanList;
    private List<FiltrateBean.FiltrateClassifyBean> classifyList;

    private void setFiltrateService() {
        serviceBeanList = new ArrayList<>();
        serviceBeanList.add(new FiltrateBean.FiltrateServiceBean("京东服务"));
        serviceBeanList.add(new FiltrateBean.FiltrateServiceBean("货到付款"));
        serviceBeanList.add(new FiltrateBean.FiltrateServiceBean("仅看有货"));
        serviceBeanList.add(new FiltrateBean.FiltrateServiceBean("促销"));
        serviceBeanList.add(new FiltrateBean.FiltrateServiceBean("全球购"));
        serviceBeanList.add(new FiltrateBean.FiltrateServiceBean("PLUS专享价"));
        serviceBeanList.add(new FiltrateBean.FiltrateServiceBean("配送全球"));
    }

    private List<FiltrateBean.FiltrateClassifyItemBean> classifyItemList;

    private void setFiltrateClassify() {
        classifyList = new ArrayList<>();
        classifyItemList = new ArrayList<>();
        classifyItemList.add(new FiltrateBean.FiltrateClassifyItemBean("苏泊尔"));
        classifyItemList.add(new FiltrateBean.FiltrateClassifyItemBean("美的"));
        classifyItemList.add(new FiltrateBean.FiltrateClassifyItemBean("爱仕达"));
        classifyItemList.add(new FiltrateBean.FiltrateClassifyItemBean("炊大皇"));
        classifyItemList.add(new FiltrateBean.FiltrateClassifyItemBean("双立人"));
        classifyList.add(new FiltrateBean.FiltrateClassifyBean("品牌", classifyItemList));
        classifyList.add(new FiltrateBean.FiltrateClassifyBean("规格", classifyItemList));
        classifyList.add(new FiltrateBean.FiltrateClassifyBean("适用范围", classifyItemList));
        classifyList.add(new FiltrateBean.FiltrateClassifyBean("材质", classifyItemList));
        classifyList.add(new FiltrateBean.FiltrateClassifyBean("功能", classifyItemList));
    }

}
