package com.zj.module_refresh.processor;

import android.content.Context;

import com.zj.module_refresh.MyRefreshLayout;
import com.zj.module_refresh.callback.IRefreshCallBack;
import com.zj.module_refresh.view.NoMoreDataFootView;


/**
 * @author zhengjun
 * @desc
 * @create at 2019/8/16 11:32
 */
public interface IrefreshProcessor {
    void initRefresh(Context context, NoMoreDataFootView footView, boolean isLoadMore, MyRefreshLayout refreshLayout, IRefreshCallBack callback);
}
