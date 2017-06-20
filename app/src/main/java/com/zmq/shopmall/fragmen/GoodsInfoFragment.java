package com.zmq.shopmall.fragmen;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.zmq.shopmall.R;
import com.zmq.shopmall.activity.GoodsDetailsActivity;
import com.zmq.shopmall.adapter.GoodsCommentAdapter;
import com.zmq.shopmall.adapter.HomeFootAdapter;
import com.zmq.shopmall.base.BaseFragment;
import com.zmq.shopmall.bean.GoodsCommentBean;
import com.zmq.shopmall.bean.RecommendBean;
import com.zmq.shopmall.utils.GlideImageLoader;
import com.zmq.shopmall.widget.SlideDetailsLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import chihane.jdaddressselector.BottomDialog;
import chihane.jdaddressselector.OnAddressSelectedListener;
import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;

/**
 * 商品
 * Created by Administrator on 2017/6/7.
 */

public class GoodsInfoFragment extends BaseFragment implements SlideDetailsLayout.OnSlideDetailsListener,
        OnAddressSelectedListener,GoodsDetailsActivity.AttributeListener {
    @BindView(R.id.iv_banner)
    Banner ivBanner; //轮播图
    @BindView(R.id.tv_goods_title)
    TextView tvGoodsTitle; //商品标题
    @BindView(R.id.tv_new_price)
    TextView tvNewPrice; //商品价格
    @BindView(R.id.tv_current_goods)
    TextView tvCurrentGoods; //已选的商品属性
    @BindView(R.id.ll_current_goods)
    LinearLayout llCurrentGoods; //选择的商品属性显示栏
    @BindView(R.id.tv_delivery_address)
    TextView tvDeliveryAddress; //收货地址
    @BindView(R.id.tv_spot_goods_content)
    TextView tvSpotGoodsContent;  //商品约定条例
    @BindView(R.id.tv_goods_quality)
    TextView tvGoodsQuality;//商品重量
    @BindView(R.id.tv_goods_quality_content)
    TextView tvGoodsQualityContent; //商品重量数值
    @BindView(R.id.tv_comment_count)
    TextView tvCommentCount; //评论人数
    @BindView(R.id.tv_good_comment)
    TextView tvGoodComment; //商品评论
    @BindView(R.id.rv_comment)
    RecyclerView rvComment;//评论列表
    @BindView(R.id.tv_all_comment)
    TextView tvAllComment; //查看全部评论
    @BindView(R.id.tv_inquire)
    TextView tvInquire; //疑问 问买过的人
    @BindView(R.id.iv_shop_icon)
    ImageView ivShopIcon; //店铺图标
    @BindView(R.id.tv_shop_name)
    TextView tvShopName; //店铺名称
    @BindView(R.id.tv_shop_introduce)
    TextView tvShopIntroduce; //店铺介绍
    @BindView(R.id.tv_goods_grade)
    TextView tvGoodsGrade; //商品评分
    @BindView(R.id.tv_serve_grade)
    TextView tvServeGrade; //服务评分
    @BindView(R.id.tv_logistics_grade)
    TextView tvLogisticsGrade; //物流评分
    @BindView(R.id.ll_shop_grade)
    LinearLayout llShopGrade; //店铺整体评分
    @BindView(R.id.tv_follow_num)
    TextView tvFollowNum; //关注人数
    @BindView(R.id.tv_all_shop)
    TextView tvAllShop; //全部商品数量
    @BindView(R.id.tv_shop_status)
    TextView tvShopStatus; //店铺动态
    @BindView(R.id.tv_server)
    TextView tvServer; //联系客服
    @BindView(R.id.tv_into_shop)
    TextView tvIntoShop; //进入店铺
    @BindView(R.id.tv_of_you_recommend)
    TextView tvOfYouRecommend; //为你推荐
    @BindView(R.id.tv_rank)
    TextView tvRank; //排行榜
    @BindView(R.id.rv_shop_of_you)
    RecyclerView rvShopOfYou;  //推荐或排行榜列表
    @BindView(R.id.tv_more_recommend)
    TextView tvMoreRecommend;//查看更多推荐或完整排行榜
    @BindView(R.id.tv_examine_image)
    TextView tvExamineImage; //上拉查看图文详情
    @BindView(R.id.nsv_goods)
    NestedScrollView nsvGoods; //滑动
    @BindView(R.id.sv_switch)
    SlideDetailsLayout sv_switch;  //上下布局切换封装类
    @BindView(R.id.rg_goods)
    RadioGroup rgGoods; //图文介绍按钮集合
    @BindView(R.id.rb_goods_introduce)
    RadioButton rbGoodsIntroduce; //图文介绍
    @BindView(R.id.rb_specification_parameter)
    RadioButton rbSpecificationParameter; //规格参数
    @BindView(R.id.rb_packaging_after_sale)
    RadioButton rbPackagingAfterSale; //包装售后
    @BindView(R.id.fl_content)
    FrameLayout flContent; //图文具体内容
    @BindView(R.id.fab_up_slide)
    FloatingActionButton fabUpSlide; //回到顶部
    @BindView(R.id.tv_no_comment)
    TextView tvNoComment; //暂无评价

    private GoodsDetailsActivity mActivity; //该活动对象
    private Fragment nowFragment; //图文当前显示对象
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager; //fragment管理器
    private GoodsDetailWebFragment goodsDetailWebFragment; //图文介绍
    private List<Integer> imageId;//图标集合
    private List<RecommendBean> recommendBeanList; //推荐列表数据
    private List<RecommendBean> rankList; //排行榜数据
    private List<RecommendBean> list = new ArrayList<>();
    private boolean isRecommend = true;
    private boolean isRank;
    private List<GoodsCommentBean> goodsCommentBeanList; //评论数据
    private List<GoodsCommentBean.GoodsCommentImage> imageList; //评论中的图片集合
    private BottomDialog dialog;//地址选择弹窗
    private HomeFootAdapter recommendAdapter;//推荐列表适配器

    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_goods_info, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        setBanner();
        SetListener();
        setGoodsDetail();
        setRgListener();
        fabUpSlide.hide();
        setGoodsCommentList();
        rvComment.setLayoutManager(new LinearLayoutManager(activity));
        rvComment.setAdapter(new GoodsCommentAdapter(goodsCommentBeanList));
        mActivity.GetAttributeListener(this);
        setRecommendData();
        setRankData();
        list.addAll(recommendBeanList);
        rvShopOfYou.setLayoutManager(new GridLayoutManager(activity, 3));
        recommendAdapter = new HomeFootAdapter(1,list);
        rvShopOfYou.setAdapter(recommendAdapter);
    }

    /**
     * 注册按钮点击监听事件
     */
    private void SetListener() {
        sv_switch.setOnSlideDetailsListener(this);
    }

    /**
     * 设置默认显示的商品tab
     */
    private void setGoodsDetail() {
        goodsDetailWebFragment = new GoodsDetailWebFragment(1);
        nowFragment = goodsDetailWebFragment;
        fragmentManager = getChildFragmentManager();
        //默认显示商品详情tab
        fragmentManager.beginTransaction().replace(R.id.fl_content, nowFragment).commitAllowingStateLoss();
    }

    /**
     * 切换Fragment
     * <p>(hide、show、add)
     *
     * @param fromFragment
     * @param toFragment
     */
    private void switchFragment(Fragment fromFragment, Fragment toFragment) {
        if (nowFragment != toFragment) {
            fragmentTransaction = fragmentManager.beginTransaction();
            if (!toFragment.isAdded()) {    // 先判断是否被add过
                fragmentTransaction.hide(fromFragment).add(R.id.fl_content, toFragment).commitAllowingStateLoss(); //
                // 隐藏当前的fragment，add下一个到activity中
            } else {
                fragmentTransaction.hide(fromFragment).show(toFragment).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
        }
    }

    /**
     * 设置radiogroup监听
     */
    private void setRgListener() {
        rgGoods.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (R.id.rb_goods_introduce == checkedId) { //商品介绍
                    rbGoodsIntroduce.setChecked(true);
                    rbGoodsIntroduce.setTextColor(ContextCompat.getColor(activity, R.color.red));
                    rbSpecificationParameter.setChecked(false);
                    rbSpecificationParameter.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    rbPackagingAfterSale.setChecked(false);
                    rbPackagingAfterSale.setTextColor(ContextCompat.getColor(activity, R.color.black));

                    switchFragment(nowFragment, goodsDetailWebFragment);
                    nowFragment = goodsDetailWebFragment;
                    return;
                }
                if (R.id.rb_specification_parameter == checkedId) { //规格参数
                    rbSpecificationParameter.setChecked(true);
                    rbSpecificationParameter.setTextColor(ContextCompat.getColor(activity, R.color.red));
                    rbGoodsIntroduce.setChecked(false);
                    rbGoodsIntroduce.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    rbPackagingAfterSale.setChecked(false);
                    rbPackagingAfterSale.setTextColor(ContextCompat.getColor(activity, R.color.black));


                    return;
                }
                if (R.id.rb_packaging_after_sale == checkedId) { //包装售后
                    rbPackagingAfterSale.setChecked(true);
                    rbPackagingAfterSale.setTextColor(ContextCompat.getColor(activity, R.color.red));
                    rbSpecificationParameter.setChecked(false);
                    rbSpecificationParameter.setTextColor(ContextCompat.getColor(activity, R.color.black));
                    rbGoodsIntroduce.setChecked(false);
                    rbGoodsIntroduce.setTextColor(ContextCompat.getColor(activity, R.color.black));


                    return;
                }
            }
        });
    }


    /**
     * 设置轮播模式
     */
    private void setBanner() {
        getImageList();
        //设置banner样式
        ivBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        ivBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        ivBanner.setImages(imageId);
        //设置banner动画效果
        ivBanner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        ivBanner.isAutoPlay(false);
        //设置指示器位置（当banner模式中有指示器时）
        ivBanner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        ivBanner.start();
    }

    /**
     * 添加头部轮播图
     */
    private void getImageList() {
        imageId = new ArrayList<>();
        imageId.add(R.mipmap.im1);
        imageId.add(R.mipmap.im2);
        imageId.add(R.mipmap.im3);
        imageId.add(R.mipmap.im4);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (GoodsDetailsActivity) context;
    }

    @OnClick({R.id.tv_of_you_recommend, R.id.tv_rank, R.id.fab_up_slide, R.id.tv_examine_image, R.id.tv_all_comment, R.id
            .tv_delivery_address, R.id.tv_more_recommend, R.id.tv_current_goods})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_delivery_address://选择地址
                setAddress();
                break;
            case R.id.tv_current_goods://选择商品属性
                mActivity.setBottomPop();
                break;
            case R.id.tv_all_comment: //查看全部评论
                mActivity.vpContent.setCurrentItem(2);
                break;
            case R.id.tv_of_you_recommend://推荐
                isRank = false;
                isRecommend = true;
                tvOfYouRecommend.setClickable(false);
                tvOfYouRecommend.setTextColor(ContextCompat.getColor(activity, R.color.red));
                tvRank.setTextColor(ContextCompat.getColor(activity, R.color.black));
                tvRank.setClickable(true);
                list.clear();
                list.addAll(recommendBeanList);
                recommendAdapter.notifyDataSetChanged();
                tvMoreRecommend.setText(getString(R.string.examine_more_recommend));
                break;
            case R.id.tv_rank://排行
                isRecommend = false;
                isRank = true;
                tvOfYouRecommend.setTextColor(ContextCompat.getColor(activity, R.color.black));
                tvRank.setTextColor(ContextCompat.getColor(activity, R.color.red));
                tvRank.setClickable(false);
                tvOfYouRecommend.setClickable(true);
                list.clear();
                list.addAll(rankList);
                recommendAdapter.notifyDataSetChanged();
                tvMoreRecommend.setText(getString(R.string.examine_full_rank));
                break;
            case R.id.tv_more_recommend://查看更多推荐或排行榜
                showShortToast("执行");
                break;
            case R.id.fab_up_slide:
                //点击滑动到顶部
                nsvGoods.smoothScrollTo(0, 0);
                sv_switch.smoothClose(true);
                break;
            case R.id.tv_examine_image: //上拉查看图文详情
                mActivity.vpContent.setCurrentItem(1);
                break;
            default:
                break;
        }
    }

    /**
     * 根据状态来动态改变UI
     */
    @Override
    public void onStatucChanged(SlideDetailsLayout.Status status) {
        if (status == SlideDetailsLayout.Status.OPEN) {
            //当前为图文详情页
            fabUpSlide.show();
            mActivity.vpContent.setNoScroll(true);
            mActivity.tvTitle.setVisibility(View.VISIBLE);
            mActivity.pstsTabs.setVisibility(View.GONE);
            setTextContent(R.mipmap.ic_down_up, "下拉收起图文详情");
        } else {
            //当前为商品详情页
            fabUpSlide.hide();
            mActivity.vpContent.setNoScroll(false);
            mActivity.tvTitle.setVisibility(View.GONE);
            mActivity.pstsTabs.setVisibility(View.VISIBLE);
            setTextContent(R.mipmap.ic_goto_up, "上拉查看图文详情");
        }
    }

    /**
     * 设置上拉下拉文字变化
     *
     * @param resId
     * @param content
     */
    private void setTextContent(int resId, String content) {
        tvExamineImage.setText(content);
        Drawable drawable = ContextCompat.getDrawable(activity, resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tvExamineImage.setCompoundDrawables(drawable, null, null, null);
    }


    /**
     * 评论列表模拟数据
     */

    private void setGoodsCommentList() {
        setGoodsCommentImage();
        goodsCommentBeanList = new ArrayList<>();
        goodsCommentBeanList.add(new GoodsCommentBean(R.mipmap.im1, "GDS", 5, "大是大非的四渡赤水的范德萨发生分散东山岛", imageList));
        goodsCommentBeanList.add(new GoodsCommentBean(R.mipmap.ic_launcher, "GDS", 5, "大是大非的四渡赤水的范德萨发生分散东山岛", imageList));
        goodsCommentBeanList.add(new GoodsCommentBean(R.mipmap.ic_launcher, "GDS", 5, "大是大非的四渡赤水的范德萨发生分散东山岛", imageList));
        goodsCommentBeanList.add(new GoodsCommentBean(R.mipmap.ic_launcher, "GDS", 4, "大是大非的四渡赤水的范德萨发生分散东山岛", imageList));

    }

    /**
     * 评论列表图片模拟数据
     */
    private void setGoodsCommentImage() {
        imageList = new ArrayList<>();
        imageList.add(new GoodsCommentBean.GoodsCommentImage("http://pic.58pic.com/58pic/12/03/18/68w58PICjJP.jpg"));
        imageList.add(new GoodsCommentBean.GoodsCommentImage("http://pic.58pic.com/58pic/12/03/18/68w58PICjJP.jpg"));
        imageList.add(new GoodsCommentBean.GoodsCommentImage("http://pic.58pic.com/58pic/12/03/18/68w58PICjJP.jpg"));
        imageList.add(new GoodsCommentBean.GoodsCommentImage("http://pic.58pic.com/58pic/12/03/18/68w58PICjJP.jpg"));
    }

    /**
     * 设置收货地址
     */
    private void setAddress() {
        dialog = new BottomDialog(activity);
        dialog.setOnAddressSelectedListener(this);
        dialog.show();
    }

    @Override
    public void onAddressSelected(Province province, City city, County county, Street street) {
        String address = (province == null ? "" : province.name) + " -> " + (city == null ? "" : city.name) + " -> " + (county
                == null ? "" : county.name) + (street == null ? "" : " -> " + street.name);
        tvDeliveryAddress.setText(address);
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void setRecommendData() {
        recommendBeanList = new ArrayList<>();
        recommendBeanList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false,
                false));
        recommendBeanList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false,
                false));
        recommendBeanList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false,
                false));
        recommendBeanList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false,
                false));
        recommendBeanList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false,
                false));
        recommendBeanList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false,
                false));
        recommendBeanList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false,
                false));
        recommendBeanList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, false));
        recommendBeanList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false,
                false));
    }

    private void setRankData() {
        rankList = new ArrayList<>();
        rankList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏", 152.00, false, false, true));
        rankList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 102.00, false, false,
                true));
        rankList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 乐视TV超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, false,
                true));
        rankList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪王 戏枪 电玩道具黑色", 152.00, false, false, true));
        rankList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV品玩具体感游戏枪 电玩道具黑色", 152.00, false, false, true));
        rankList.add(new RecommendBean(R.mipmap.ic_timg, "产品玩具体感游戏枪 电玩道具黑色", 152.00, false, false, true));
        rankList.add(new RecommendBean(R.mipmap.ic_timg, "产品玩具体感游戏枪 电玩道具黑色", 152.00, false, false, true));
        rankList.add(new RecommendBean(R.mipmap.ic_timg, "产品玩具体感游戏枪 电玩道具黑色", 152.00, false, false, true));
        rankList.add(new RecommendBean(R.mipmap.ic_timg, "Letv/乐视LETV体感-超级枪V超级电视产品玩具体感游戏枪 电玩道具黑色", 152.00, false, false, true));
    }

    @Override
    public void getGoodsAttribute(String attribute) {
        tvCurrentGoods.setText(mActivity.attribute);
    }
}
