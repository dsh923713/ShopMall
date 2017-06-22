package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class FiltrateFragment extends BaseFragment {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rb_task_total)
    RadioButton rbTaskTotal;
    @BindView(R.id.rb_assigning)
    RadioButton rbAssigning;
    @BindView(R.id.rb_no_assigning)
    RadioButton rbNoAssigning;
    @BindView(R.id.rg_task_group)
    RadioGroup rgTaskGroup;
    @BindView(R.id.ll_task_status)
    LinearLayout llTaskStatus;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.department_arrow)
    ImageView departmentArrow;
    @BindView(R.id.department_selected)
    TextView departmentSelected;
    @BindView(R.id.rl_department)
    RelativeLayout rlDepartment;

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_filtrate, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {

    }

    @OnClick({R.id.rl_department})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_department:
                replaceFragment(R.id.dl_content,new GoodsInfoFragment());
                break;
            default:
                break;
        }
    }
}
