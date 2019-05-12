package com.hr.learn.service;

import com.hr.learn.mapper.UserMapper;
import com.hr.learn.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nick
 * @date 19-5-12 星期日 23:01
 **/
@Service
public class UserServiceImpl implements UserServiceI {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
