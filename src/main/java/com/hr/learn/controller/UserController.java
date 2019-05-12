package com.hr.learn.controller;

import com.hr.learn.model.User;
import com.hr.learn.service.UserServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nick
 * @date 19-5-12 星期日 23:02
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserServiceI userServiceI;

    @RequestMapping("/findAll")
    public String findAll() {
        List<User> lstUser = userServiceI.findAll();
        for (User user : lstUser) {
            System.out.println("id: " + user.getId());
            System.out.println("name: " + user.getName());
        }
        return "hello";
    }
}
