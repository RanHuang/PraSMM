package com.hr.learn.model.praise;

import java.io.Serializable;

/**
 * @author nick
 * @date 19-6-2 星期日 11:16
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 3981393706442493693L;

    private String id;
    private String name;
    private String account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
