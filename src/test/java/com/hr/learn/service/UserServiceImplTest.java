package com.hr.learn.service;

import com.context.ServiceTestContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hr.learn.model.User;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nick
 * @date 19-5-15 星期三 21:11
 **/
public class UserServiceImplTest extends ServiceTestContext {
    @Resource
    private UserServiceI userService;

    @Test
    public void findAll() {
        List<User> lstUser = userService.findAll();
        System.out.println(lstUser);
        Assert.assertEquals(6, lstUser.size());
    }

    @Test
    public void testPageHelper() {
        int pageSize = 4;
        PageHelper.startPage(0, pageSize);
        List<User> lstUser = userService.findAll();
        PageInfo pageInfo = new PageInfo(lstUser);
        System.out.println(pageInfo);
        Assert.assertEquals(pageSize, lstUser.size());
    }
}