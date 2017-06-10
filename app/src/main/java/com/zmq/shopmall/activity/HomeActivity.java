package com.zmq.shopmall.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jpeng.jptabbar.JPTabBar;
import com.jpeng.jptabbar.OnTabSelectListener;
import com.zaaach.citypicker.CityPickerActivity;
import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseActivity;
import com.zmq.shopmall.fragmen.ClassifyFragment;
import com.zmq.shopmall.fragmen.HomeFragment;

import butterknife.BindView;

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private JPTabBar mTabbar; //底部Tab
    @BindView(R.id.tv_city)
    TextView tvCity;//定位城市
    @BindView(R.id.tv_title)
    TextView tvTitle;//搜索商品
    @BindView(R.id.tv_news)
    TextView tvNews; //消息
    @BindView(R.id.index_title_bar)
    RelativeLayout indexTitleBar; //顶部搜索栏

    private static final int resId = R.id.content;
    private static final int REQUEST_CODE_PICK_CITY = 1;

    public HomeActivity() {
        super(R.layout.activity_home);
    }


    @Override
    protected void initView() {
        setBottomTab();
        tvCity.setOnClickListener(this);
        tvTitle.setOnClickListener(this);
        tvNews.setOnClickListener(this);
    }

    /**
     * 设置底部导航栏
     */
    private void setBottomTab() {
        mTabbar = (JPTabBar) findViewById(R.id.tabbar);
        mTabbar.setTitles(R.string.home, R.string.classify, R.string.special_offer, R.string.shopping_trolley, R.string.myself)
                .setNormalIcons(R.mipmap.ic_home, R.mipmap.ic_classify, R.mipmap.ic_special_offer, R.mipmap.ic_shopping_trolley, R.mipmap.ic_myself)
                .setSelectedIcons(R.mipmap.ic_home_selected, R.mipmap.ic_classify_selected, R.mipmap.ic_special_offer_selected, R.mipmap
                        .ic_shopping_trolley_selected, R.mipmap.ic_myself_selected)
                .generate();
        mTabbar.setSelectedColor(ContextCompat.getColor(this, R.color.red));
        replaceFragment(resId, new HomeFragment());
        mTabbar.setTabListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int index) {
                switch (index) {
                    case 0:  //首页
                        replaceFragment(resId, new HomeFragment());
                        break;
                    case 1:  //分类
                        replaceFragment(resId, new ClassifyFragment());
                        break;
                    case 2:  //特惠
                        replaceFragment(resId, new HomeFragment());
                        break;
                    case 3:  //购物车
                        replaceFragment(resId, new HomeFragment());
                        break;
                    case 4:  //我的
                        replaceFragment(resId, new HomeFragment());
                        break;
                    default:
                        break;
                }
            }
        });
    }

    /**
     * 设置标题栏左侧按键
     *
     * @param resId
     * @param msg
     */
    public void setLeftIcon(int resId, String msg) {
        if (resId == 0 && TextUtils.isEmpty(msg)) {
            tvCity.setVisibility(View.GONE);
            return;
        }
        tvCity.setVisibility(View.VISIBLE);
        tvCity.setText(msg);
        if (resId != 0) {
            Drawable drawable = ContextCompat.getDrawable(this, resId);
            // 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvCity.setCompoundDrawables(null, drawable, null, null);
        }
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(int resId, String title) {
        if (resId != 0) {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setBackgroundResource(resId);
        }
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        }
    }

    /**
     * 设置标题栏右控件
     *
     * @param resId
     * @param msg
     */
    public void setRightIcon(int resId, String msg) {
        if (resId == 0 && TextUtils.isEmpty(msg)) {
            tvNews.setVisibility(View.GONE);
            return;
        }
        tvNews.setVisibility(View.VISIBLE);
        tvNews.setText(msg);
        if (resId != 0) {
            // 这一步必须要做,否则不会显示.
            Drawable drawable = ContextCompat.getDrawable(this, resId);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvNews.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_city:
                startActivityForResult(CityPickerActivity.class, REQUEST_CODE_PICK_CITY);
                break;
            case R.id.tv_title:
                startActivity(SearchActivity.class);
                break;
            case R.id.tv_news:
                startActivity(NewsActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 接收选择的城市
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
