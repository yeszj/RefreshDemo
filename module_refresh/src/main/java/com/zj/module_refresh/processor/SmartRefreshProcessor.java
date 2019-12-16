package com.zj.module_refresh.processor;

import android.content.Context;

import com.scwang.smart.refresh.footer.BallPulseFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.SpinnerStyle;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.zj.module_refresh.MyRefreshLayout;
import com.zj.module_refresh.R;
import com.zj.module_refresh.callback.IRefreshCallBack;
import com.zj.module_refresh.view.NoMoreDataFootView;

import androidx.annotation.NonNull;

/**
 * @author zhengjun
 * @desc SmartRefreshLayout代理类
 * @create at 2019/10/22 10:30
 */
public class SmartRefreshProcessor implements IrefreshProcessor {

    /**
     * @desc isLoadMore 是否允许加载更多
     * footView 无数据时显示view，加载更多结束且无更多数据时底部显示暂无更多
     * @author zhengjun
     * @created at 2019/12/16 9:59
     */
    @Override
    public void initRefresh(Context context, final NoMoreDataFootView footView, final boolean isLoadMore, final MyRefreshLayout refreshLayout, final IRefreshCallBack callback) {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout1) {
                refreshLayout.setEnableLoadMore(isLoadMore);
                callback.onRefresh();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout12) {
                if (footView != null) {
                    if (footView.getFootViewState() == NoMoreDataFootView.FOOT_HIDE) {
                        callback.onLoadMore();
                    } else {
                        refreshLayout.finishLoadMoreWithNoMoreData();
                    }
                } else {
                    callback.onLoadMore();
                }

            }
        });
        // 设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(context)
                .setSpinnerStyle(SpinnerStyle.Scale)
                .setAnimatingColor(context.getResources().getColor(R.color.colorPrimary)));

        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorBg, R.color.colorTextGrey);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        }));
        refreshLayout.setEnableLoadMore(isLoadMore);
    }
}
