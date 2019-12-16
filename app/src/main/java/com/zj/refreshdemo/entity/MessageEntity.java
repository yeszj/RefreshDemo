package com.zj.refreshdemo.entity;

/**
 * @author zhengjun
 * @desc
 * @create at 2019/12/16 10:04
 */
public class MessageEntity {
    private String imgUrl;
    private String title;
    private String createTime;
    private String content;

    public MessageEntity(String imgUrl, String title, String createTime, String content) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.createTime = createTime;
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
