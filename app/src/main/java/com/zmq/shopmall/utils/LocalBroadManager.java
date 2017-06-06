package com.zmq.shopmall.utils;

import android.support.v4.content.LocalBroadcastManager;

import com.zmq.shopmall.MyApplication;


/**
 * Created by Administrator on 2017/5/27.
 */

public class LocalBroadManager {
    private static LocalBroadcastManager broadcastManager = null;

    public static LocalBroadcastManager getInstance(){
        if (broadcastManager == null){
            broadcastManager = LocalBroadcastManager.getInstance(MyApplication.getInstance());
        }
        return broadcastManager;
    }
}
