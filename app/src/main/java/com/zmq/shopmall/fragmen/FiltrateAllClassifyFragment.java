package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.zmq.shopmall.R;
import com.zmq.shopmall.adapter.FiltrateAllClassifyAdapter;
import com.zmq.shopmall.base.BaseFragment;
import com.zmq.shopmall.bean.FiltrateItem;
import com.zmq.shopmall.bean.FiltrateItem1;
import com.zmq.shopmall.bean.FiltrateItemContent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/24.
 */

public class FiltrateAllClassifyFragment extends BaseFragment {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rv_filtrate_all_classify)
    RecyclerView rvFiltrateAllClassify;
    List<MultiItemEntity> data;
    private FragmentManager fragmentManager;
    private FiltrateAllClassifyAdapter adapter;

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_filtrate_all_classify, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        data = generateData();
        fragmentManager = getFragmentManager();
        rvFiltrateAllClassify.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new FiltrateAllClassifyAdapter(fragmentManager, data);
        rvFiltrateAllClassify.setAdapter(adapter);
    }

    private ArrayList<MultiItemEntity> generateData() {
        int lv0Count = 1;
        int lv1Count = 3;
        int personCount = 5;

        String[] nameList = {"Bob", "Andy", "Lily", "Brown", "Bruce"};

        ArrayList<MultiItemEntity> res = new ArrayList<>();
        FiltrateItem lv0 = new FiltrateItem();
        res.add(lv0);
        for (int j = 0; j < lv1Count; j++) {
            FiltrateItem1 lv1 = new FiltrateItem1("Level 1 item: " + j);
            for (int k = 0; k < nameList.length; k++) {
                lv1.addSubItem(new FiltrateItemContent(nameList[k]));
            }
            res.add(lv1);
        }
        return res;
    }

    @OnClick({R.id.iv_back})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                fragmentManager.popBackStack();//将当前fragment回退
                break;
        }
    }
}
