package com.context;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author nick
 * @date 19-5-29 星期三 22:40
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:redis-context.xml"})
public class RedisTestContext {
}
