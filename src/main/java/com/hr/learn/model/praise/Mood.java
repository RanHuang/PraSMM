package com.hr.learn.model.praise;

import java.io.Serializable;
import java.util.Date;

/**
 * 说说
 * @author nick
 * @date 19-6-2 星期日 11:21
 **/
public class Mood implements Serializable {
    private static final long serialVersionUID = -8378626840050685488L;
    /**
     * 主键
     */
    private String id;
    /**
     * 内容
     */
    private String content;
    /**
     * 点赞数量
     */
    private Integer praiseNum;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 发布时间
     */
    private Date publishTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "Mood{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", praiseNum=" + praiseNum +
                ", userId='" + userId + '\'' +
                ", publishTime=" + publishTime +
                '}';
    }
}
