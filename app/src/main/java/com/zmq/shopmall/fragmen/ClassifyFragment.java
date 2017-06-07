package com.zmq.shopmall.fragmen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zmq.shopmall.R;
import com.zmq.shopmall.adapter.ClassifyLeftAdapter;
import com.zmq.shopmall.adapter.ClassifyRightAdapter;
import com.zmq.shopmall.base.BaseFragment;
import com.zmq.shopmall.bean.ClassifyLeftBean;
import com.zmq.shopmall.bean.ClassifyRightBean;
import com.zmq.shopmall.bean.ClassifyRightItemBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/6/6.
 */

public class ClassifyFragment extends BaseFragment {
    @BindView(R.id.rv_classify_left)
    RecyclerView rvClassifyLeft; //左侧分类栏
    @BindView(R.id.rv_classify_right)
    RecyclerView rvClassifyRight; //右侧分类内容


    List<ClassifyLeftBean> rvLeftData; //左侧分类数据
    private ClassifyLeftAdapter leftAdapter;//左侧适配器
    private List<ClassifyRightBean> rvRightData; //右侧内容
    private List<ClassifyRightItemBean> rvRightItemData;//右侧子项内容
    private ClassifyRightAdapter rightAdapter;//右侧适配器

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_classify, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        setRvRightItemData();
        setRvRightData();
        setRvLeftData();
        leftAdapter = new ClassifyLeftAdapter(rvLeftData);
        rightAdapter = new ClassifyRightAdapter(rvRightData);
        rvClassifyLeft.setLayoutManager(new LinearLayoutManager(activity));
        rvClassifyRight.setLayoutManager(new LinearLayoutManager(activity));
        rvClassifyLeft.setAdapter(leftAdapter);
        rvClassifyRight.setAdapter(rightAdapter);
        leftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { //左侧点击事件
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                rvRightData.clear();
//                ClassifyLeftBean leftBean = rvLeftData.get(position);
//                rvRightData.addAll(leftBean.getRightBeanList());
                rvClassifyLeft.scrollToPosition(position);
                leftAdapter.selectPosition(position);
                leftAdapter.notifyDataSetChanged();
                rightAdapter.notifyDataSetChanged();
            }
        });
        rightAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() { //右侧子布局点击事件
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                showShortToast(""+position);
            }
        });
    }

    /**
     * 模拟左侧分类栏数据
     */
    private void setRvLeftData() {
        rvLeftData = new ArrayList<>();
        rvLeftData.add(new ClassifyLeftBean("推荐分类",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("自家超市",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("全球购",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("男装",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("女装",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("男鞋",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("女鞋",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("内衣配饰",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("箱包手袋",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("美妆护理",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("钟表珠宝",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("手机数码",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("钟表珠宝",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("电脑办公",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("家用电器",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("食品生鲜",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("酒水饮料",rvRightData));
        rvLeftData.add(new ClassifyLeftBean("母婴童装",rvRightData));
    }

    private void setRvRightData(){
        rvRightData = new ArrayList<>();
        rvRightData.add(new ClassifyRightBean(R.mipmap.im1,true,false,"专场推荐",rvRightItemData));
        rvRightData.add(new ClassifyRightBean(R.mipmap.im1,false,true,"热门分类",rvRightItemData));
        rvRightData.add(new ClassifyRightBean(R.mipmap.im1,false,false,"休闲零食",rvRightItemData));
        rvRightData.add(new ClassifyRightBean(R.mipmap.im1,false,false,"京东生鲜",rvRightItemData));
        rvRightData.add(new ClassifyRightBean(R.mipmap.im1,false,false,"母婴用品",rvRightItemData));
    }

    private void setRvRightItemData(){
        rvRightItemData = new ArrayList<>();
        rvRightItemData.add(new ClassifyRightItemBean(R.mipmap.ic_launcher,"冰箱"));
        rvRightItemData.add(new ClassifyRightItemBean(R.mipmap.ic_launcher,"冰箱"));
        rvRightItemData.add(new ClassifyRightItemBean(R.mipmap.ic_launcher,"生鲜海鲜，零食饮料"));
        rvRightItemData.add(new ClassifyRightItemBean(R.mipmap.ic_launcher,"冰箱"));
        rvRightItemData.add(new ClassifyRightItemBean(R.mipmap.ic_launcher,"冰箱"));
        rvRightItemData.add(new ClassifyRightItemBean(R.mipmap.ic_launcher,"冰箱"));
    }
}
