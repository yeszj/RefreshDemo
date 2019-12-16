package com.zj.refreshdemo;

import android.widget.Toast;

import com.zj.module_refresh.MyRefreshLayout;
import com.zj.module_refresh.callback.IRefreshCallBack;
import com.zj.module_refresh.manager.RefreshManager;
import com.zj.refreshdemo.adapter.MainAdapter;
import com.zj.refreshdemo.base.BaseActivity;
import com.zj.refreshdemo.callBack.IViewListener;
import com.zj.refreshdemo.entity.MessageEntity;
import com.zj.refreshdemo.preseneter.MainPresenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActivity {
    MyRefreshLayout refreshLayout;
    RecyclerView recyclerView;
    MainPresenter presenter;
    private int pageNum;
    MainAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        findViewById();
        initView();
        initRefresh();
    }

    private void findViewById() {
        refreshLayout = findViewById(R.id.refresh);
        recyclerView = findViewById(R.id.recycleview);
    }

    private void initView() {
        presenter = new MainPresenter();
        adapter = new MainAdapter(recyclerView);
        adapter.addFooterView(footView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter.getHeaderAndFooterAdapter());
    }


    private void initRefresh() {
        RefreshManager.getInstance().initRefresh(this, footView, true, refreshLayout, new IRefreshCallBack() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                getData();
            }

            @Override
            public void onLoadMore() {
                pageNum++;
                getData();
            }
        });
        beginRefreshing(refreshLayout);
    }

    private void getData() {
        presenter.getMessageList(pageNum, new IViewListener<List<MessageEntity>>() {
            @Override
            public void onFail(String code, String msg) {
                Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(List<MessageEntity> response) {
                if (pageNum == 1) {
                    adapter.setData(response);
                } else {
                    adapter.addMoreData(response);
                }
                setDataLoadFinish(pageNum, response.size(), refreshLayout);
            }
        });
    }
}
