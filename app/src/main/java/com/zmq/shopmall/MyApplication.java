package com.zmq.shopmall;

import android.app.Application;

/**
 * Created by Administrator on 2017/5/22.
 */

public class MyApplication extends Application {
    private static MyApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    /**
     * 获取单例application
     * @return
     */
    public static MyApplication getInstance(){
        return application;
    }
}
