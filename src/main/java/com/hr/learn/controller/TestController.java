package com.hr.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nick on 19-5-12 星期日 17:28
 **/
@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("/sayHello")
    public String sayHello() {
        return "hello";
    }
}
