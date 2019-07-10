package com.demo.resource;

import com.demo.autoinject.TestController;
import com.demo.service.AutoInjectService;
import com.demo.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallCSBController {

    @Autowired
    AutoInjectService autoInjectService;

    @GetMapping("/bean")
    public String registerBean() {
        //将applicationContext转换为ConfigurableApplicationContext
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) SpringContextUtil.getApplicationContext();

        // 获取bean工厂并转换为DefaultListableBeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();

        // 通过BeanDefinitionBuilder创建bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(TestController.class);

        // 设置属性userService,此属性引用已经定义的bean:userService,这里userService已经被spring容器管理了.
//        beanDefinitionBuilder.addPropertyReference("testService", "testService");

        // 注册bean
        defaultListableBeanFactory.registerBeanDefinition("testController", beanDefinitionBuilder.getRawBeanDefinition());


        TestController userController = (TestController) SpringContextUtil.getBean("testController");

        return userController.toAction("动态注册生成调用");

        //删除bean.
        //defaultListableBeanFactory.removeBeanDefinition("testService");
    }


}