package com.zj.module_refresh.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zj.module_refresh.R;


/**
 * @author zhengjun
 * @desc 上拉加载更多  当无更多数据，没有数据时显示的footview
 * @create at 2018/8/24 16:17
 */

public class NoMoreDataFootView extends LinearLayout {
    Context context;
    TextView tv_foot;
    ImageView iv_empty;
    RelativeLayout rlParent;
    public final static int FOOT_NO_MORE = 1;   //显示底部footview 显示文案为 已经到底了
    public final static int FOOT_NO_DATA = 2;    //无数据
    public final static int FOOT_HIDE = 3;    //隐藏
    public final static int FOOT_LOAD_ERROR = 4; //加载出错

    public NoMoreDataFootView(Context context) {
        super(context);
        initView(context);
    }

    public NoMoreDataFootView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        LayoutInflater.from(getContext()).inflate(R.layout.footview_nomore_data, this, true);
        tv_foot = findViewById(R.id.tv_foot);
        iv_empty = findViewById(R.id.iv_empty);
        rlParent = findViewById(R.id.rlParent);
    }

    public int getFootViewState() {
        return state;
    }

    int state;

    public void setFootViewState(int state) {
        this.state = state;
        switch (state) {
            case FOOT_NO_MORE:
                tv_foot.setVisibility(VISIBLE);
                tv_foot.setText("-没有更多了-");
                iv_empty.setVisibility(GONE);
                break;
            case FOOT_LOAD_ERROR:
                tv_foot.setVisibility(VISIBLE);
                iv_empty.setVisibility(VISIBLE);
                iv_empty.setImageResource(R.mipmap.ic_nodata);
                tv_foot.setText("加载出错，请下拉刷新页面");
                break;
            case FOOT_HIDE:
                tv_foot.setVisibility(GONE);
                iv_empty.setVisibility(GONE);
                break;
            case FOOT_NO_DATA:
                tv_foot.setVisibility(VISIBLE);
                iv_empty.setVisibility(VISIBLE);
                iv_empty.setImageResource(R.mipmap.ic_nodata);
                tv_foot.setText("暂无数据");
                break;
        }
    }

    /**
     * @desc 设置没有内容时显示的文案
     * @author zhengjun
     * @created at 2018/9/6 10:11
     */
    public void setFootText(String text) {
        tv_foot.setText(text);
    }

    //设置背景颜色
    public void setCustomBackGroudnColor(int colorId) {
        rlParent.setBackgroundColor(getResources().getColor(colorId));
    }
}
