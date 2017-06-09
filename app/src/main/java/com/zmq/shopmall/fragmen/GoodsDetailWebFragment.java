package com.zmq.shopmall.fragmen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zmq.shopmall.R;
import com.zmq.shopmall.base.BaseFragment;
import com.zmq.shopmall.widget.ItemWebView;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/6/9.
 */

@SuppressLint("ValidFragment")
public class GoodsDetailWebFragment extends BaseFragment {
    @BindView(R.id.iwv_goods_detail)
    ItemWebView iwvGoodsDetail;
    @BindView(R.id.wv_goods_detail)
    WebView wvGoodsDetail;
    private WebSettings webSettings;
    private int id;
    @SuppressLint("ValidFragment")
   public GoodsDetailWebFragment(int id){
        this.id = id;
    }
    @Override
    protected View initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_goods_detail_web, container, false);
        return view;
    }

    @Override
    protected void initView(View view) {
        String url = "http://m.okhqb.com/item/description/1000334264.html?fromApp=true";
        if (id == 1){
            iwvGoodsDetail.setVisibility(View.VISIBLE);
            wvGoodsDetail.setVisibility(View.GONE);
            iwvGoodsDetail.setFocusable(false);
            iwvGoodsDetail.loadUrl(url);
            webSettings = iwvGoodsDetail.getSettings();//获取webview控制器
            iwvGoodsDetail.setWebViewClient(new GoodsDetailWebViewClient());
        }else {
            iwvGoodsDetail.setVisibility(View.GONE);
            wvGoodsDetail.setVisibility(View.VISIBLE);
            wvGoodsDetail.setFocusable(false);
            wvGoodsDetail.loadUrl(url);
            webSettings = wvGoodsDetail.getSettings();//获取webview控制器
            wvGoodsDetail.setWebViewClient(new GoodsDetailWebViewClient());
        }
        webSettings.setLoadWithOverviewMode(true);//是否允许WebView度超出以概览的方式载入页面，默认false。
        webSettings.setBuiltInZoomControls(true);//是否使用内置的缩放机制
        webSettings.setLoadsImagesAutomatically(true);//WebView是否下载图片资源，默认为true。
        webSettings.setBlockNetworkImage(true);//是否禁止从网络（通过http和https URI schemes访问的资源）下载图片资源，默认值为false。
        webSettings.setUseWideViewPort(true);//WebView是否支持HTML的“viewport”标签或者使用wide viewport。
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);//重写使用缓存的方式，默认值LOAD_DEFAULT。

    }
    private class GoodsDetailWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            webSettings.setBlockNetworkImage(false);
        }
    }
}
