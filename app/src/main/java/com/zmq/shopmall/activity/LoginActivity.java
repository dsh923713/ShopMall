package com.zmq.shopmall.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/19.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_login)
    EditText etLogin; //用户框
    @BindView(R.id.iv_login_clear)
    ImageView ivLoginClear; //清除用户信息
    @BindView(R.id.et_password)
    EditText etPassword; //密码框
    @BindView(R.id.iv_isvisible)
    ImageView ivIsvisible; //密码是否可见按钮
    @BindView(R.id.iv_password_clear)
    ImageView ivPasswordClear; //清除密码信息
    @BindView(R.id.tv_login)
    TextView tvLogin; //登录
    @BindView(R.id.tv_phone_register)
    TextView tvPhoneRegister; //手机注册
    @BindView(R.id.tv_find_password)
    TextView tvFindPassword; //找回密码


    private boolean isEtLogin; //登录框是否有值
    private boolean isEtPassword; //密码框是否有值
    private boolean isvisible; //密码是否可见
    /**
     * 监听改变登录状态
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (isEtLogin && isEtPassword) {
                tvLogin.setClickable(true);
                tvLogin.setBackground(ContextCompat.getDrawable(LoginActivity.this, R.drawable.shape_login_red));
            } else {
                tvLogin.setClickable(false);
                tvLogin.setBackground(ContextCompat.getDrawable(LoginActivity.this, R.drawable.shape_login_gray));
            }
        }
    };

    public LoginActivity() {
        super(R.layout.activity_login);
    }

    @Override
    protected void initView() {
        setTitle("登录");
        setLeftIcon(R.mipmap.ic_back, "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setEditTextListener();
    }

    /**
     * 监听输入框文字长度变化
     */
    private void setEditTextListener() {
        //是否获取到焦点
        etLogin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus && etLogin.length() > 0) {
                    ivLoginClear.setVisibility(View.VISIBLE);
                } else {
                    ivLoginClear.setVisibility(View.GONE);
                }
            }
        });
        etLogin.addTextChangedListener(new TextWatcher() { //检测内容长度变化
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    ivLoginClear.setVisibility(View.VISIBLE);
                    isEtLogin = true;
                } else {
                    ivLoginClear.setVisibility(View.GONE);
                    isEtLogin = false;
                }
                handler.sendEmptyMessage(1);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus && etPassword.length() > 0) {
                    ivPasswordClear.setVisibility(View.VISIBLE);
                } else {
                    ivPasswordClear.setVisibility(View.GONE);
                }
            }
        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    ivPasswordClear.setVisibility(View.VISIBLE);
                    isEtPassword = true;
                } else {
                    ivPasswordClear.setVisibility(View.GONE);
                    isEtPassword = false;
                }
                handler.sendEmptyMessage(1);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @OnClick({R.id.iv_login_clear, R.id.iv_password_clear, R.id.iv_isvisible, R.id.tv_login, R.id.tv_phone_register, R.id
            .tv_find_password})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_login_clear://清除账户信息
                etLogin.setText("");
                break;
            case R.id.iv_password_clear://清除密码信息
                etPassword.setText("");
                break;
            case R.id.iv_isvisible: //密码是否可见
                if (!isvisible) {
                    isvisible = true;
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance()); //可见
                    ivIsvisible.setImageResource(R.mipmap.ic_visible);
                } else {
                    isvisible = false;
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());//不可见
                    ivIsvisible.setImageResource(R.mipmap.ic_invisible);
                }
                etPassword.setSelection(etPassword.getText().length());//光标显示在最后 不设置每次切换都会回到首位
                break;
            case R.id.tv_login: //登录
                showShortToast("登录");
                break;
            case R.id.tv_phone_register: //手机注册
                showShortToast("注册");
                break;
            case R.id.tv_find_password: //找回密码
                showShortToast("找回密码");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
