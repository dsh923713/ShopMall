package com.zmq.shopmall.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zmq.shopmall.R;
import com.zmq.shopmall.adapter.SearchDetailAdapter;
import com.zmq.shopmall.base.BaseActivity;
import com.zmq.shopmall.bean.SearchDetailBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/20.
 */

public class SearchDetailActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.et_search)
    TextView etSearch;
    @BindView(R.id.iv_voice)
    ImageView ivVoice;
    @BindView(R.id.iv_rv_style)
    ImageView ivRvStyle;
    @BindView(R.id.tv_synthesize)
    TextView tvSynthesize;
    @BindView(R.id.tv_sales_volume)
    TextView tvSalesVolume;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_filtrate)
    TextView tvFiltrate;
    @BindView(R.id.rv_search)
    RecyclerView rvSearch;

    private static int layoutResId = R.layout.rv_item_search_detail;;
    private List<SearchDetailBean> searchDetailBeen;
    private boolean isList;
    private SearchDetailAdapter detailAdapter;
    private GridLayoutManager gridLayoutManager;
    private LinearLayoutManager layoutManager;

    public SearchDetailActivity() {
        super(R.layout.activity_search_detail);
    }

    @Override
    protected void initView() {
        setSearchDetailBeen();
        gridLayoutManager = new GridLayoutManager(this, 2);
        layoutManager = new LinearLayoutManager(this);
        rvSearch.setLayoutManager(gridLayoutManager);
        detailAdapter = new SearchDetailAdapter(R.layout.rv_item_search_detail, searchDetailBeen);
        rvSearch.setAdapter(detailAdapter);
    }

    @OnClick({R.id.iv_rv_style})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_rv_style:
                if (!isList) {
                    isList = true;
                    layoutResId = R.layout.rv_item_search_detail_list;
                    ivRvStyle.setImageResource(R.mipmap.ic_list_normal);
                    rvSearch.setLayoutManager(layoutManager);
                    detailAdapter = new SearchDetailAdapter(R.layout.rv_item_search_detail_list, searchDetailBeen);
                } else {
                    isList = false;
                    layoutResId = R.layout.rv_item_search_detail;
                    ivRvStyle.setImageResource(R.mipmap.ic_list);
                    rvSearch.setLayoutManager(gridLayoutManager);
                    detailAdapter = new SearchDetailAdapter(R.layout.rv_item_search_detail, searchDetailBeen);
                }
                detailAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }

    private void setSearchDetailBeen() {
        searchDetailBeen = new ArrayList<>();
        searchDetailBeen.add(new SearchDetailBean(R.mipmap.ic_timg, "大的范德萨发撒范德萨范德萨士大夫按时发斯蒂芬", 125.00, 21525, 99));
        searchDetailBeen.add(new SearchDetailBean(R.mipmap.ic_timg, "的说法的是否打算放大师傅带伞啥地方的撒范德萨", 125.00, 21525, 99));
        searchDetailBeen.add(new SearchDetailBean(R.mipmap.ic_timg, "相册V型从V型充值V型从v司法撒旦法师打发啥的服务", 125.00, 21525, 99));
        searchDetailBeen.add(new SearchDetailBean(R.mipmap.ic_timg, "五色入围现场线程v的沙发斯蒂芬搜房网呃呃服务费", 125.00, 21525, 99));
        searchDetailBeen.add(new SearchDetailBean(R.mipmap.ic_timg, "的收费的算法那的沙发斯蒂芬为从v从v小县城V型", 125.00, 21525, 99));
        searchDetailBeen.add(new SearchDetailBean(R.mipmap.ic_timg, "大的范德萨发撒范德萨范德萨士大夫按时发斯蒂芬", 125.00, 21525, 99));
        searchDetailBeen.add(new SearchDetailBean(R.mipmap.ic_timg, "大的范德萨发撒范德萨范德萨士大夫按时发斯蒂芬", 125.00, 21525, 99));
        searchDetailBeen.add(new SearchDetailBean(R.mipmap.ic_timg, "大的范德萨发撒范德萨范德萨士大夫按时发斯蒂芬", 125.00, 21525, 99));
        searchDetailBeen.add(new SearchDetailBean(R.mipmap.ic_timg, "大的范德萨发撒范德萨范德萨士大夫按时发斯蒂芬", 125.00, 21525, 99));
        searchDetailBeen.add(new SearchDetailBean(R.mipmap.ic_timg, "大的范德萨发撒范德萨范德萨士大夫按时发斯蒂芬", 125.00, 21525, 99));
        searchDetailBeen.add(new SearchDetailBean(R.mipmap.ic_timg, "大的范德萨发撒范德萨范德萨士大夫按时发斯蒂芬", 125.00, 21525, 99));
    }
}
