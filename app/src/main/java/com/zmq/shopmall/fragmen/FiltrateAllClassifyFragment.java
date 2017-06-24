package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

/**
 * Created by Administrator on 2017/6/24.
 */

public class FiltrateAllClassifyFragment extends BaseFragment {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rv_filtrate_all_classify)
    RecyclerView rvFiltrateAllClassify;
    List<MultiItemEntity> data;

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_filtrate_all_classify, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        data = generateData();
        rvFiltrateAllClassify.setLayoutManager(new LinearLayoutManager(activity));
        rvFiltrateAllClassify.setAdapter(new FiltrateAllClassifyAdapter(data));
    }

    private ArrayList<MultiItemEntity> generateData() {
        int lv0Count = 9;
        int lv1Count = 3;
        int personCount = 5;

        String[] nameList = {"Bob", "Andy", "Lily", "Brown", "Bruce"};

        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < lv0Count; i++) {
            FiltrateItem lv0 = new FiltrateItem();
            for (int j = 0; j < lv1Count; j++) {
                FiltrateItem1 lv1 = new FiltrateItem1("Level 1 item: " + j);
                for (int k = 0; k < personCount; k++) {
                    lv1.addSubItem(new FiltrateItemContent(nameList[k]));
                }
                lv0.addSubItem(lv1);
            }
            res.add(lv0);
        }
        return res;
    }
}
