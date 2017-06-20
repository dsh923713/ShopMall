package com.zmq.shopmall.activity;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.yinglan.keyboard.HideUtil;
import com.zmq.shopmall.R;
import com.zmq.shopmall.adapter.HotSearchAdapter;
import com.zmq.shopmall.base.BaseActivity;

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
    @BindView(R.id.iv_voice)
    ImageView ivVoice;
    @BindView(R.id.tv_search)
    TextView tvSearch; //搜索
    @BindView(R.id.rv_hot_search)
    RecyclerView rvHotSearch; //热搜列表

    private List<String> hotSearchList;
    private HotSearchAdapter hotSearchAdapter;
    private boolean isClear;

    public SearchActivity() {
        super(R.layout.activity_search);
    }

    @Override
    protected void initView() {
        HideUtil.init(this);
        setHotSearchList();
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
        layoutManager.setFlexWrap(FlexWrap.WRAP); //设置是否换行
        layoutManager.setFlexDirection(FlexDirection.ROW); //设置子元素的排列方向 默认水平排列
        layoutManager.setAlignItems(AlignItems.STRETCH);//沿副轴对齐(单行起作用) 高度充满
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);//沿主轴左对齐
        rvHotSearch.setLayoutManager(layoutManager);
        hotSearchAdapter = new HotSearchAdapter(hotSearchList);
        rvHotSearch.setAdapter(hotSearchAdapter);
        hotSearchAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                showShortToast(hotSearchList.get(position) + "");
            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0){
                    ivVoice.setImageResource(R.mipmap.cp_ic_search_clear);
                    isClear = true;
                }else {
                    ivVoice.setImageResource(R.mipmap.ic_voice);
                    isClear = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick({R.id.iv_back, R.id.tv_search, R.id.iv_voice})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_voice:
                if (isClear){
                    etSearch.setText("");
                }else {
                    showShortToast("语音");
                }
                break;
            case R.id.tv_search:
                startActivityAndFinish(SearchDetailActivity.class);
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
