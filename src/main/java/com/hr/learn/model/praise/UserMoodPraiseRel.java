package com.hr.learn.model.praise;

import java.io.Serializable;

/**
 * @author nick
 * @date 19-6-2 星期日 11:24
 **/
public class UserMoodPraiseRel implements Serializable {
    private static final long serialVersionUID = 4242650782462240027L;

    private String id;
    private String userId;
    private String moodId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMoodId() {
        return moodId;
    }

    public void setMoodId(String moodId) {
        this.moodId = moodId;
    }

    @Override
    public String toString() {
        return "UserMoodPraiseRel{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", moodId='" + moodId + '\'' +
                '}';
    }
}
