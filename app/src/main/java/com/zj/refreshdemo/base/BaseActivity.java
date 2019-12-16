package com.zj.refreshdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.zj.module_refresh.MyRefreshLayout;
import com.zj.module_refresh.view.NoMoreDataFootView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author zhengjun
 * @desc
 * @create at 2019/12/16 09:53
 */
public abstract class BaseActivity extends AppCompatActivity {
    public NoMoreDataFootView footView;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getLayoutId());
        footView = new NoMoreDataFootView(mContext);
        initData();
    }

    protected abstract int getLayoutId();

    public abstract void initData();

    //数据加载结束
    public void setDataLoadFinish(int pageNum, int size, MyRefreshLayout refreshLayout) {
        if (pageNum == 1) {
            if (size > 0) {
                footView.setFootViewState(NoMoreDataFootView.FOOT_HIDE);
            } else {
                footView.setFootViewState(NoMoreDataFootView.FOOT_NO_DATA);
                refreshLayout.finishLoadMoreWithNoMoreData();
            }
            endRefreshing(refreshLayout);
        } else {
            if (size <= 0) {
                footView.setFootViewState(NoMoreDataFootView.FOOT_NO_MORE);
                refreshLayout.finishLoadMoreWithNoMoreData();
            } else {
                footView.setFootViewState(NoMoreDataFootView.FOOT_HIDE);
                endLoadingMore(refreshLayout);
            }
        }
    }

    //加载数据出错时显示的view
    public void loadDataFail(int pageNum, final MyRefreshLayout refreshLayout) {
        if (pageNum == 1) {
            footView.setFootViewState(NoMoreDataFootView.FOOT_LOAD_ERROR);
            endRefreshing(refreshLayout);
            footView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    beginRefreshing(refreshLayout);
                }
            });
        }
    }

    //开始刷新
    public void beginRefreshing(MyRefreshLayout refreshLayout) {
        refreshLayout.autoRefresh();
    }

    //结束刷新
    public void endRefreshing(MyRefreshLayout refreshLayout) {
        refreshLayout.finishRefresh();
    }

    //加载更多结束
    public void endLoadingMore(MyRefreshLayout refreshLayout) {
        refreshLayout.finishLoadMore();
    }
}
