package com.hr.learn.service;

import com.hr.learn.model.User;

import java.util.List;

/**
 * @author nick
 * @date 19-5-12 星期日 23:00
 **/
public interface UserServiceI {
    List<User> findAll();

    User findById(int id);
}
