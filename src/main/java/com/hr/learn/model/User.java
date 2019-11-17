package com.hr.learn.model;

import java.io.Serializable;

/**
 * @author nick
 * @date 19-5-12 星期日 22:56
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 8215689540106690525L;

    private int id;
    private String name;
    private String account;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
