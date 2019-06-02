package com.context;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;

import java.util.List;

/**
 * @author nick
 * @date 19-6-2 星期日 12:12
 **/
public abstract class ShowData {
    protected StringBuilder sb;

    @Before
    public void before() {
        sb = new StringBuilder();
    }

    @After
    public void after() {
        System.out.println(sb.toString());
    }

    public <T> void showData(String info, T data) {
        sb.append(info).append("\n");
        sb.append(JSON.toJSONString(data)).append("\n");
    }

    public <T> void showData(String info, List<T> lstData) {
        sb.append(info).append(", data size:").append(lstData.size()).append("\n");
        sb.append(JSON.toJSONString(lstData)).append("\n");
    }
}
