package com.hr.learn;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nick on 19-5-10 星期五 22:49
 **/
public class HelloServiceTest {

    @Test
    public void sayHello() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        HelloService helloService = applicationContext.getBean(HelloService.class);
        String msg = helloService.sayHello();
        Assert.assertEquals("Hello", msg);
    }
}