package com.zj.refreshdemo.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zj.refreshdemo.R;
import com.zj.refreshdemo.entity.MessageEntity;

import androidx.recyclerview.widget.RecyclerView;
import cn.bingoogolapple.baseadapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * @author zhengjun
 * @desc
 * @create at 2019/12/16 10:14
 */
public class MainAdapter extends BGARecyclerViewAdapter<MessageEntity> {
    public MainAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.adapter_message_item);
    }

    @Override
    protected void fillData(BGAViewHolderHelper helper, int position, MessageEntity model) {
        ImageView imageView = helper.getImageView(R.id.iv_image);
        Glide.with(mContext)
                .load(model.getImgUrl())
                .apply(new RequestOptions())
                .into(imageView);
        helper.setText(R.id.tv_title, model.getTitle());
        helper.setText(R.id.tv_content, model.getContent());
        helper.setText(R.id.tv_time, model.getCreateTime());
    }
}
