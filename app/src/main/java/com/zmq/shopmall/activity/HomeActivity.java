package com.zmq.shopmall.activity;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jpeng.jptabbar.JPTabBar;
import com.jpeng.jptabbar.OnTabSelectListener;
import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseActivity;
import com.zmq.shopmall.fragmen.ClassifyFragment;
import com.zmq.shopmall.fragmen.HomeFragment;

import butterknife.BindView;

import static com.zmq.shopmall.R.id.tv_title;

public class HomeActivity extends BaseActivity {
    private JPTabBar mTabbar; //底部Tab
    @BindView(R.id.tv_city)
    TextView tvCity;//定位城市
    @BindView(tv_title)
    TextView tvTitle;//搜索的商品名称
    @BindView(R.id.tv_news)
    TextView tvNews; //消息
    @BindView(R.id.index_title_bar)
    RelativeLayout indexTitleBar; //顶部搜索栏

    private static final int resId = R.id.content;

    public HomeActivity() {
        super(R.layout.activity_home);
    }


    @Override
    protected void initView() {
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
     * 设置标题栏返回键
     *
     * @param resId
     * @param msg
     * @param listener
     */
    public void setLeftIcon(int resId, String msg, View.OnClickListener listener) {
        tvCity.setVisibility(View.VISIBLE);
        if (msg != null) {
            tvCity.setText(msg);
        }
        if (resId != 0) {
            Drawable drawable = ContextCompat.getDrawable(this, resId);
            // 这一步必须要做,否则不会显示.
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvCity.setCompoundDrawables(null, null, null, drawable);
        }
        if (listener != null) {
            tvCity.setOnClickListener(listener);
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
        if (title != null) {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        }
    }

    /**
     * 设置标题栏右控件
     *
     * @param resId
     * @param msg
     * @param listener
     */
    public void setRightIcon(int resId, String msg, View.OnClickListener listener) {
        tvNews.setVisibility(View.VISIBLE);
        Drawable drawable = ContextCompat.getDrawable(this, resId);
        if (msg != null) {
            tvNews.setText(msg);
        }
        // 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tvNews.setCompoundDrawables(null, null, null, drawable);
        if (listener != null) {
            tvNews.setOnClickListener(listener);
        }
    }
}
