package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;
import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/6/6.
 */

public class ClassifyFragment extends BaseFragment {
    @BindView(R.id.lv_classify)
    ListView lvClassify;
    @BindView(R.id.rv_classify)
    RecyclerView rvClassify;


    List<String> lvData;
    private CommonAdapter<String> lvAdapter;

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_classify, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        setListData();
        lvAdapter = new CommonAdapter<String>(activity, R.layout.lv_item_classify, lvData) {
            @Override
            protected void convert(ViewHolder holder, String item, int position) {
                holder.setText(R.id.rb_name, item);
            }
        };

    }

    private void setListData() {
        lvData = new ArrayList<>();
        lvData.add("推荐分类");
        lvData.add("自家超市");
        lvData.add("全球购");
        lvData.add("男装");
        lvData.add("女装");
        lvData.add("男鞋");
        lvData.add("女鞋");
        lvData.add("内衣配饰");
        lvData.add("箱包手袋");
        lvData.add("美妆护理");
        lvData.add("钟表珠宝");
        lvData.add("手机数码");
        lvData.add("电脑办公");
        lvData.add("家用电器");
        lvData.add("食品生鲜");
        lvData.add("酒水饮料");
        lvData.add("母婴童装");
    }
}
