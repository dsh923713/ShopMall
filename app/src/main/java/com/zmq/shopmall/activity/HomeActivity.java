package com.zmq.shopmall.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.zaaach.citypicker.CityPickerActivity;
import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseActivity;
import com.zmq.shopmall.entity.TabEntity;
import com.zmq.shopmall.fragmen.ClassifyFragment;
import com.zmq.shopmall.fragmen.HomeFragment;
import com.zmq.shopmall.fragmen.MyselfFragment;
import com.zmq.shopmall.fragmen.ShopTrolleyFragment;
import com.zmq.shopmall.fragmen.SpecialOfferFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_title_name)
    TextView tvTitleName;//搜索标题框
    @BindView(R.id.iv_news)
    ImageView ivNews;//消息
    @BindView(R.id.index_title_bar)
    RelativeLayout indexTitleBar;//顶部标题栏
    @BindView(R.id.tv_city)
    TextView tvCity;//定位城市
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch; //搜索
    @BindView(R.id.tv_news)
    TextView tvNews; //消息
    @BindView(R.id.iv_voice)
    ImageView ivVoice;//语音
    @BindView(R.id.ctl_bottom)
    CommonTabLayout ctlBottom;//底部导航栏

    private String[] mTitles = {"首页", "分类", "特惠", "购物车", "我的"}; //标题
    private int[] mIconUnselectIds = {R.mipmap.ic_home, R.mipmap.ic_classify, R.mipmap.ic_special_offer, R.mipmap
            .ic_shopping_trolley, R.mipmap.ic_myself}; //未选中图标
    private int[] mIconSelectIds = {R.mipmap.ic_home_selected, R.mipmap.ic_classify_selected, R.mipmap
            .ic_special_offer_selected, R.mipmap.ic_shopping_trolley_selected, R.mipmap.ic_myself_selected}; //选中图标
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>(); //布局参数集合
    private ArrayList<Fragment> mFragments = new ArrayList<>();//fragment集合

    private HomeFragment homeFragment; //首页
    private ClassifyFragment classifyFragment;//分类
    private SpecialOfferFragment specialOfferFragment;//特惠
    private ShopTrolleyFragment shopTrolleyFragment;//购物车
    private MyselfFragment myselfFragment;//我的

    private static final int REQUEST_CODE_PICK_CITY = 1001;//city回调参数


    public HomeActivity() {
        super(R.layout.activity_home);
    }


    @Override
    protected void initView() {
        //注册点击事件
        ivNews.setOnClickListener(this);
        tvCity.setOnClickListener(this);
        rlSearch.setOnClickListener(this);
        tvNews.setOnClickListener(this);
        ivVoice.setOnClickListener(this);
        setBottomTab();
    }

    /**
     * 设置底部导航栏
     */
    private void setBottomTab() {
        homeFragment = new HomeFragment();
        classifyFragment = new ClassifyFragment();
        specialOfferFragment = new SpecialOfferFragment();
        shopTrolleyFragment = new ShopTrolleyFragment();
        myselfFragment = new MyselfFragment();
        //添加标题 已选图标 未选图标
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        //添加fragment
        mFragments.add(homeFragment);
        mFragments.add(classifyFragment);
        mFragments.add(specialOfferFragment);
        mFragments.add(shopTrolleyFragment);
        mFragments.add(myselfFragment);
        /**懒人模式**/
        ctlBottom.setTabData(mTabEntities, this, R.id.content, mFragments);
        ctlBottom.showMsg(3,11); //显示数量 最多显示到99
        ctlBottom.showDot(4);//显示红点
        /** 切换状态**/
        ctlBottom.setOnTabSelectListener(new com.flyco.tablayout.listener.OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                switch (position) {
                    case 0:  //首页
                        setLeftIcon(true);
                        setTitle("");
                        setRightIcon(true);
                        indexTitleBar.setVisibility(View.VISIBLE);
                        indexTitleBar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.blue));
                        break;
                    case 1:  //分类
                        setLeftIcon(true);
                        setTitle("");
                        setRightIcon(true);
                        indexTitleBar.setVisibility(View.VISIBLE);
                        indexTitleBar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.blue));
                        break;
                    case 2:  //特惠
                        setLeftIcon(true);
                        setTitle("");
                        setRightIcon(true);
                        indexTitleBar.setVisibility(View.VISIBLE);
                        indexTitleBar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.colorAccent));
                        break;
                    case 3:  //购物车
                        setLeftIcon(false);
                        setTitle("购物车");
                        setRightIcon(false);
                        indexTitleBar.setVisibility(View.VISIBLE);
                        indexTitleBar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.white));
                        break;
                    case 4:  //我的
                        indexTitleBar.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabReselect(int position) { //重复点击

            }
        });
    }

    /**
     * 设置标题栏左侧按键
     */
    public void setLeftIcon(boolean isShow) {
        if (isShow) {
            tvCity.setVisibility(View.VISIBLE);
        } else {
            tvCity.setVisibility(View.GONE);
        }
    }


    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            rlSearch.setVisibility(View.GONE);
            tvTitleName.setVisibility(View.VISIBLE);
            tvTitleName.setText(title);
        } else {
            rlSearch.setVisibility(View.VISIBLE);
            tvTitleName.setVisibility(View.GONE);
        }
    }


    /**
     * 设置标题栏右控件
     */
    public void setRightIcon(boolean isShow) {
        if (isShow) {
            tvNews.setVisibility(View.VISIBLE);
            ivNews.setVisibility(View.GONE);
        } else {
            tvNews.setVisibility(View.GONE);
            ivNews.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_city: //左侧定位
                startActivityForResult(CityPickerActivity.class, REQUEST_CODE_PICK_CITY);
                break;
            case R.id.rl_search: //中间标题/搜索栏
                startActivity(SearchActivity.class);
                break;
            case R.id.iv_voice: //中间标题/搜索栏
                showShortToast("语音");
                break;
            case R.id.tv_news://右侧消息
                startActivity(NewsActivity.class);
                break;
            case R.id.iv_news://右侧消息
                startActivity(NewsActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 回调显示选择的城市
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                tvCity.setText("" + city);
            }
        }
    }
}
