package com.zmq.shopmall.activity;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zmq.shopmall.R;
import com.zmq.shopmall.adapter.GoodsSkuAdapter;
import com.zmq.shopmall.adapter.ItemTitlePagerAdapter;
import com.zmq.shopmall.base.BaseActivity;
import com.zmq.shopmall.bean.GoodsSkuBean;
import com.zmq.shopmall.fragmen.GoodsCommentFragment;
import com.zmq.shopmall.fragmen.GoodsDetailFragment;
import com.zmq.shopmall.fragmen.GoodsInfoFragment;
import com.zmq.shopmall.widget.CustomPopWindow;
import com.zmq.shopmall.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.shaohui.bottomdialog.BaseBottomDialog;
import me.shaohui.bottomdialog.BottomDialog;
import ren.qinc.numberbutton.NumberButton;

/**
 * Created by Administrator on 2017/6/7.
 */

public class GoodsDetailsActivity extends BaseActivity implements View.OnClickListener, GoodsSkuAdapter.GetSkuListener {
    @BindView(R.id.ll_back)
    LinearLayout llBack; //返回
    @BindView(R.id.psts_tabs)
    public PagerSlidingTabStrip pstsTabs; //顶部导航栏
    @BindView(R.id.tv_title)
    public TextView tvTitle; //商品标题
    @BindView(R.id.vp_content)
    public NoScrollViewPager vpContent; //内容容器
    @BindView(R.id.iv_more)
    ImageView ivMore; //更多菜单
    @BindView(R.id.iv_shape)
    ImageView ivShape; //分享
    @BindView(R.id.tv_contact_the_seller)
    TextView tvContactTheSeller; //联系卖家
    @BindView(R.id.tv_shop)
    TextView tvShop; //店铺
    @BindView(R.id.tv_follow)
    TextView tvFollow; //分享
    @BindView(R.id.tv_shopping_trolley)
    TextView tvShoppingTrolley; //购物车
    @BindView(R.id.tv_into_shopping_trolley)
    TextView tvIntoShoppingTrolley; //加入购物车

    private CustomPopWindow mCustomPopWindow;//顶部更多弹窗
    private BaseBottomDialog dialog; //底部购买弹窗
    private NumberButton numberButton; //增减按钮
    private RecyclerView rvGoodsSku; //商品属性

    private List<Fragment> fragmentList = new ArrayList<>();//fragment数组
    private List<GoodsSkuBean> goodsSkuBeanList;
    private List<GoodsSkuBean.GoodsSkuChild> goodsSkuChildList;


    public GoodsDetailsActivity() {
        super(R.layout.activity_goods_details);
    }

    @Override
    protected void initView() {
        fragmentList.add(new GoodsInfoFragment());
        fragmentList.add(new GoodsDetailFragment());
        fragmentList.add(new GoodsCommentFragment());
        vpContent.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(), fragmentList, new String[]{"商品", "详情",
                "评论"}));
        vpContent.setOffscreenPageLimit(3);
        pstsTabs.setViewPager(vpContent);
        setListener();
    }

    /**
     * 注册按钮的点击事件
     */
    private void setListener() {
        llBack.setOnClickListener(this);
        ivShape.setOnClickListener(this);
        ivMore.setOnClickListener(this);
        tvContactTheSeller.setOnClickListener(this);
        tvShop.setOnClickListener(this);
        tvFollow.setOnClickListener(this);
        tvShoppingTrolley.setOnClickListener(this);
        tvIntoShoppingTrolley.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_back://返回
                finish();
                break;
            case R.id.iv_shape://分享
                break;
            case R.id.iv_more://更多
                setPopupWindow();
                break;
            case R.id.tv_contact_the_seller://联系客服
                break;
            case R.id.tv_shop://进入店铺
                break;
            case R.id.tv_follow://关注
                break;
            case R.id.tv_shopping_trolley://购物车
                break;
            case R.id.tv_into_shopping_trolley://加入购物车
                setBottomData();
                setBottomPop();
                break;
            default:
                break;
        }
    }

    private void setPopupWindow() {
        View view = LayoutInflater.from(this).inflate(R.layout.pop_goods_item_menu, null);
        //处理popWindow 显示内容及点击事件
        handleLogic(view);
        //创建并显示popupwindow
        mCustomPopWindow = new CustomPopWindow.PopupWindowBuilder(this).setView(view).create().showAsDropDown(ivMore, 0, 20);
    }

    /**
     * 设置底部购买弹窗
     */
    private void setBottomPop() {

        dialog = BottomDialog.create(getSupportFragmentManager()).setLayoutRes(R.layout.dia_goods_sku).setViewListener(new BottomDialog.ViewListener() {
            @Override
            public void bindView(View v) {
                numberButton = (NumberButton) v.findViewById(R.id.number_button);
                numberButton.setCurrentNumber(1); //设置当前数量
                numberButton.setBuyMax(5);//设置最大购买数量 不需要可以不设置
                TextView tvGoodsPrice = (TextView) v.findViewById(R.id.tv_goods_price); //价格
                TextView tvGoodsTitle = (TextView) v.findViewById(R.id.tv_goods_title); //商品标题
                ImageView ivClear = (ImageView) v.findViewById(R.id.iv_clear); //取消
                RoundedImageView rivGoodsIcon = (RoundedImageView) v.findViewById(R.id.riv_goods_icon); //商品图片
                rvGoodsSku = (RecyclerView) v.findViewById(R.id.rv_goods_sku);
                TextView tvBuy = (TextView) v.findViewById(R.id.tv_buy); //购买按钮
                TextView tvIntoShoppingTrolley = (TextView) v.findViewById(R.id.tv_into_shopping_trolley); //加入购物车
                //注册监听事件
                ivClear.setOnClickListener(clickListener);
                tvBuy.setOnClickListener(clickListener);
                tvIntoShoppingTrolley.setOnClickListener(clickListener);
                rvGoodsSku.setLayoutManager(new LinearLayoutManager(GoodsDetailsActivity.this));
                GoodsSkuAdapter goodsSkuAdapter = new GoodsSkuAdapter(goodsSkuBeanList);
                rvGoodsSku.setAdapter(goodsSkuAdapter);
                goodsSkuAdapter.GetSku(GoodsDetailsActivity.this);

            }
        }).setCancelOutside(false).show();
    }

    /**
     * 底部购买弹窗点击事件
     */
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_clear:
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    break;
                case R.id.tv_buy:
                    showShortToast(numberButton.getNumber() + "--");
                    break;
                case R.id.tv_into_shopping_trolley:
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * 处理弹出显示内容、点击事件等逻辑
     *
     * @param contentView
     */
    private void handleLogic(View contentView) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCustomPopWindow != null) {
                    mCustomPopWindow.dissmiss();
                }
                switch (v.getId()) {
                    case R.id.tv_news: //消息
                        break;
                    case R.id.tv_home: //首页
                        startActivityAndFinish(HomeActivity.class);
                        break;
                    case R.id.tv_search: //搜索
                        startActivity(SearchActivity.class);
                        break;
                    case R.id.tv_my_follow: //我的关注
                        break;
                    case R.id.tv_browsing_history: //浏览记录
                        break;
                    default:
                        break;
                }
            }
        };
        contentView.findViewById(R.id.tv_news).setOnClickListener(listener);
        contentView.findViewById(R.id.tv_home).setOnClickListener(listener);
        contentView.findViewById(R.id.tv_search).setOnClickListener(listener);
        contentView.findViewById(R.id.tv_my_follow).setOnClickListener(listener);
        contentView.findViewById(R.id.tv_browsing_history).setOnClickListener(listener);
    }

    private void setBottomData() {
        goodsSkuBeanList = new ArrayList<>();
        goodsSkuChildList = new ArrayList<>();
        goodsSkuChildList.add(new GoodsSkuBean.GoodsSkuChild("黑色"));
        goodsSkuChildList.add(new GoodsSkuBean.GoodsSkuChild("白色"));
        goodsSkuChildList.add(new GoodsSkuBean.GoodsSkuChild("棕色"));
        goodsSkuChildList.add(new GoodsSkuBean.GoodsSkuChild("紫黑色"));
        goodsSkuChildList.add(new GoodsSkuBean.GoodsSkuChild("红色"));
        goodsSkuChildList.add(new GoodsSkuBean.GoodsSkuChild("粉色"));
        goodsSkuBeanList.add(new GoodsSkuBean("颜色", goodsSkuChildList));
        goodsSkuBeanList.add(new GoodsSkuBean("尺码", goodsSkuChildList));
    }

    @Override
    public void getSku(String skuName, String sku) {
        showShortToast(skuName + "--" + sku);
    }
}
