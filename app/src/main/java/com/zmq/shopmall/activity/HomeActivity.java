package com.zmq.shopmall.activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jpeng.jptabbar.JPTabBar;
import com.jpeng.jptabbar.OnTabSelectListener;
import com.zaaach.citypicker.CityPickerActivity;
import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseActivity;
import com.zmq.shopmall.fragmen.ClassifyFragment;
import com.zmq.shopmall.fragmen.HomeFragment;
import com.zmq.shopmall.fragmen.MyselfFragment;
import com.zmq.shopmall.fragmen.ShopTrolleyFragment;
import com.zmq.shopmall.fragmen.SpecialOfferFragment;

import butterknife.BindView;

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_title_name)
    TextView tvTitleName;
    @BindView(R.id.iv_news)
    ImageView ivNews;
    @BindView(R.id.index_title_bar)
    RelativeLayout indexTitleBar;
    private JPTabBar mTabbar; //底部Tab
    @BindView(R.id.tv_city)
    TextView tvCity;//定位城市
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch; //搜索
    @BindView(R.id.tv_news)
    TextView tvNews; //消息
    @BindView(R.id.iv_voice)
    ImageView ivVoice;//语音


    private HomeFragment homeFragment;
    private ClassifyFragment classifyFragment;
    private ShopTrolleyFragment shopTrolleyFragment;
    private MyselfFragment myselfFragment;

    private static final int resId = R.id.content;
    private static final int REQUEST_CODE_PICK_CITY = 1;


    public HomeActivity() {
        super(R.layout.activity_home);
    }


    @Override
    protected void initView() {
        ivNews.setOnClickListener(this);
        tvCity.setOnClickListener(this);
        rlSearch.setOnClickListener(this);
        tvNews.setOnClickListener(this);
        ivVoice.setOnClickListener(this);

        homeFragment = new HomeFragment();
        classifyFragment = new ClassifyFragment();
        shopTrolleyFragment = new ShopTrolleyFragment();
        myselfFragment = new MyselfFragment();
        setBottomTab();
    }

    /**
     * 设置底部导航栏
     */
    private void setBottomTab() {
        mTabbar = (JPTabBar) findViewById(R.id.tabbar);
        mTabbar.setTitles(R.string.home, R.string.classify, R.string.special_offer, R.string.shopping_trolley, R.string.myself)
                .setNormalIcons(R.mipmap.ic_home, R.mipmap.ic_classify, R.mipmap.ic_special_offer, R.mipmap
                        .ic_shopping_trolley, R.mipmap.ic_myself).setSelectedIcons(R.mipmap.ic_home_selected, R.mipmap
                .ic_classify_selected, R.mipmap.ic_special_offer_selected, R.mipmap.ic_shopping_trolley_selected, R.mipmap
                .ic_myself_selected).generate();
        mTabbar.setSelectedColor(ContextCompat.getColor(this, R.color.red));
        replaceFragment(resId, homeFragment);
        mTabbar.setTabListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int index) {
                switch (index) {
                    case 0:  //首页
                        replaceFragment(resId, homeFragment);
                        setLeftIcon(true);
                        setTitle("");
                        setRightIcon(true);
                        indexTitleBar.setVisibility(View.VISIBLE);
                        indexTitleBar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.blue));
                        break;
                    case 1:  //分类
                        replaceFragment(resId, classifyFragment);
                        setLeftIcon(true);
                        setTitle("");
                        setRightIcon(true);
                        indexTitleBar.setVisibility(View.VISIBLE);
                        indexTitleBar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.blue));
                        break;
                    case 2:  //特惠
                        replaceFragment(resId, new SpecialOfferFragment());
                        setLeftIcon(true);
                        setTitle("");
                        setRightIcon(true);
                        indexTitleBar.setVisibility(View.VISIBLE);
                        indexTitleBar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.colorAccent));
                        break;
                    case 3:  //购物车
                        replaceFragment(resId, shopTrolleyFragment);
                        setLeftIcon(false);
                        setTitle("购物车");
                        setRightIcon(false);
                        indexTitleBar.setVisibility(View.VISIBLE);
                        indexTitleBar.setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.white));
                        break;
                    case 4:  //我的
                        replaceFragment(resId, myselfFragment);
                        indexTitleBar.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
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
     * 接收选择的城市
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
