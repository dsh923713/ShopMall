package com.zmq.shopmall.activity;

import android.view.View;
import android.widget.TextView;

import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/19.
 */

public class SetActivity extends BaseActivity {

    @BindView(R.id.tv_user_login)
    TextView tvUserLogin;
    @BindView(R.id.tv_vip_clup)
    TextView tvVipClup;
    @BindView(R.id.tv_plus_vip)
    TextView tvPlusVip;
    @BindView(R.id.tv_address_administration)
    TextView tvAddressAdministration;
    @BindView(R.id.tv_real_name_authentication)
    TextView tvRealNameAuthentication;
    @BindView(R.id.tv_account_security)
    TextView tvAccountSecurity;
    @BindView(R.id.tv_connected_account)
    TextView tvConnectedAccount;

    public SetActivity() {
        super(R.layout.activity_set);
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.tv_user_login})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_user_login:
                startActivity(LoginActivity.class);
                break;
            default:
                break;
        }
    }
}
