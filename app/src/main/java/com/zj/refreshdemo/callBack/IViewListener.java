package com.zj.refreshdemo.callBack;

/**
 * @author zhengjun
 * @desc
 * @create at 2019/12/16 10:02
 */
public interface IViewListener<V> {
    /**
     * 显示错误信息
     *
     * @param msg
     */
    void onFail(String code, String msg);

    void onSuccess(V response);
}
