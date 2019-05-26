package com.hr.learn.service;

import com.hr.learn.mapper.UserMapper;
import com.hr.learn.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nick
 * @date 19-5-12 星期日 23:01
 **/
@Service
public class UserServiceImpl implements UserServiceI {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getName());

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(int id) {
        User user1 = userMapper.findById(id);
        logger.info("第一次查询User, id:{}, Data:{}", id, user1);
        User user2 = userMapper.findById(id);
        logger.info("第二次查询User, id:{}, Data:{}", id, user2);
        return user2;
    }
}
