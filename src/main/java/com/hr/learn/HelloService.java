package com.hr.learn;

import org.springframework.stereotype.Service;

/**
 * @author nick on 19-5-10 星期五 22:46
 **/
@Service
public class HelloService {
    public String sayHello() {
        String msg = "Hello";
        System.out.println("Say: " + msg);
        return msg;
    }
}
