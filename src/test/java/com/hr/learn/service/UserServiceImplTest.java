package com.hr.learn.service;

import com.hr.learn.JunitContext;
import com.hr.learn.model.User;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nick
 * @date 19-5-15 星期三 21:11
 **/
public class UserServiceImplTest extends JunitContext {
    @Resource
    private UserServiceI userService;

    @Test
    public void findAll() {
        List<User> lstUser = userService.findAll();
        System.out.println(lstUser);
        Assert.assertEquals(2, lstUser.size());
    }
}