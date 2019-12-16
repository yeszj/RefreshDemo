package com.zj.refreshdemo.preseneter;

import android.os.Handler;

import com.zj.refreshdemo.callBack.IViewListener;
import com.zj.refreshdemo.entity.MessageEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengjun
 * @desc
 * @create at 2019/12/16 10:02
 */
public class MainPresenter {

    //模拟获取数据
    public void getMessageList(final int pageNum, final IViewListener<List<MessageEntity>> listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<MessageEntity> list = new ArrayList<>();
                if (pageNum == 1) {
                    for (int i = 0; i < 10; i++) {
                        MessageEntity entity = new MessageEntity("http://k.zol-img.com.cn/dcbbs/19511/a19510653_01000.jpg", "杀年猪啦！山里人家杀年猪吃庖汤，年前还要把腊肉寄给儿女", "2019-12-16", "12月14日，冬月十九，安康岚皋县石门镇乐景村，53岁的林期猛家要杀2头年猪，早早的乡亲们就来帮忙，8个男人拉着、抬着大肥猪去杀年猪。进入冬月秦巴山里的年味也渐渐浓了起来。");
                        list.add(entity);
                    }
                    listener.onSuccess(list);
                } else if (pageNum < 3) {
                    for (int i = 0; i < 10; i++) {
                        MessageEntity entity = new MessageEntity("https://inews.gtimg.com/newsapp_bt/0/10797571959/1000", "日本最可爱女大学出炉，18位选手她脱颖而出，这些选手你喜欢谁？", "2019-12-16", "临近年尾，日本陆续举行不同大型选美赛事，日前FRESH CAMPUS CONTEST2019比赛结果出炉，到底谁是本年度日本最可爱大学一年级女学生了？图为冠军获得者中川红叶，来自青山学院大学（モデルプレス）");
                        list.add(entity);
                    }
                    listener.onSuccess(list);
                } else {
                    listener.onSuccess(new ArrayList<MessageEntity>());
                }
            }
        }, 500);

    }
}
