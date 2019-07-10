package com.demo.autoinject;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class TestController implements InitializingBean {

    @Autowired
    private TestService testService;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("我是动态注册的你,不是容器启动的时候注册的你");
    }

    public String toAction(String content){
        return "-->" +  testService.doService(content);
    }
}
