package com.hr.learn.model.praise;

import com.hr.learn.model.praise.Mood;

/**
 * @author nick
 * @date 19-6-2 星期日 17:21
 **/
public class MoodVO extends Mood {
    private String userName;
    private String userAccount;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }
}
