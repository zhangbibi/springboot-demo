package com.demo.service;

import com.demo.autoinject.TestController;
import com.demo.util.SpringContextUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Service;

@Service
public class AutoInjectService2 implements BeanDefinitionRegistry {

    @Override
    public void registerBeanDefinition(String s, BeanDefinition beanDefinition) throws BeanDefinitionStoreException {
//        //构造bean定义
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(TestController.class);
//        BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
//        //注册bean定义
//        registry.registerBeanDefinition("autoBean", beanDefinition);
//        TestController controller = (TestController) SpringContextUtil.getBean("autoBean");
//        controller.toAction("BeanDefinitionRegistryPostProcessor ......................");
    }

    @Override
    public void removeBeanDefinition(String s) throws NoSuchBeanDefinitionException {

    }

    @Override
    public BeanDefinition getBeanDefinition(String s) throws NoSuchBeanDefinitionException {
        return null;
    }

    @Override
    public boolean containsBeanDefinition(String s) {
        return false;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return new String[0];
    }

    @Override
    public int getBeanDefinitionCount() {
        return 0;
    }

    @Override
    public boolean isBeanNameInUse(String s) {
        return false;
    }

    @Override
    public void registerAlias(String s, String s1) {

    }

    @Override
    public void removeAlias(String s) {

    }

    @Override
    public boolean isAlias(String s) {
        return false;
    }

    @Override
    public String[] getAliases(String s) {
        return new String[0];
    }
}
