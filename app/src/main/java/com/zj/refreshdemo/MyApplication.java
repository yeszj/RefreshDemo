package com.zj.refreshdemo;

import android.app.Application;

import com.zj.module_refresh.manager.RefreshManager;
import com.zj.module_refresh.processor.SmartRefreshProcessor;

/**
 * @author zhengjun
 * @desc
 * @create at 2019/12/16 09:48
 */
public class MyApplication extends Application {
    static {
        RefreshManager.init(new SmartRefreshProcessor());
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
