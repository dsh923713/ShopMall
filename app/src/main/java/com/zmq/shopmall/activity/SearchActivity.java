package com.zmq.shopmall.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yinglan.keyboard.HideUtil;
import com.zmq.shopmall.R;
import com.zmq.shopmall.adapter.HotSearchAdapter;
import com.zmq.shopmall.base.BaseActivity;
import com.zmq.shopmall.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/10.
 */

public class SearchActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack; //返回
    @BindView(R.id.et_search)
    EditText etSearch; //搜索输入框
    @BindView(R.id.tv_search)
    TextView tvSearch; //搜索
    @BindView(R.id.rv_hot_search)
    RecyclerView rvHotSearch; //热搜列表

    private List<String> hotSearchList;
    private HotSearchAdapter hotSearchAdapter;

    public SearchActivity() {
        super(R.layout.activity_search);
    }

    @Override
    protected void initView() {
        HideUtil.init(this);
        setHotSearchList();
        hotSearchAdapter = new HotSearchAdapter(hotSearchList);
        rvHotSearch.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
        rvHotSearch.setAdapter(hotSearchAdapter);
        //设置item之间的间隔
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        rvHotSearch.addItemDecoration(decoration);
        hotSearchAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                showShortToast(hotSearchList.get(position)+"");
            }
        });

    }
    @OnClick({R.id.iv_back,R.id.tv_search})
    void onClick(View v){
        switch(v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_search:
                showShortToast("搜索");
                break;
            default:
                break;
        }
    }



    /**
     * 模拟热搜数据
     */
    private void setHotSearchList() {
        hotSearchList = new ArrayList<>();
        hotSearchList.add("无糖奶粉");
        hotSearchList.add("抽纸99-50");
        hotSearchList.add("数码收纳包");
        hotSearchList.add("计步器");
        hotSearchList.add("小米放大器");
        hotSearchList.add("茅台酒");
        hotSearchList.add("迷你洗衣机");
        hotSearchList.add("炼狱蝰蛇");
        hotSearchList.add("虾片");
        hotSearchList.add("肉脯199-100");
        hotSearchList.add("祛斑199-100");
        hotSearchList.add("月光宝盒");
        hotSearchList.add("洗衣机");
        hotSearchList.add("筹资");
        hotSearchList.add("硝酸铵");
    }
}
