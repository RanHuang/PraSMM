package com.hr.learn.controller;

import com.hr.learn.model.User;
import com.hr.learn.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nick
 * @date 19-5-12 星期日 23:02
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserServiceI userServiceI;

    /**
     * http://localhost:8080/springmvc/user/users
     * @return
     */
    @RequestMapping("/users")
    @ResponseBody
    public List<User> findAll() {
        List<User> lstUser = userServiceI.findAll();
        logger.info("查询所有user信息, size:{}, data:{}", lstUser.size(), lstUser);
        return lstUser;
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public User findById(@PathVariable("id") int id) {
        User user = userServiceI.findById(id);
        return user;
    }
}
