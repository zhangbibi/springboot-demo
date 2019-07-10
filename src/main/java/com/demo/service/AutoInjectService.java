package com.demo.service;

import com.demo.autoinject.TestController;
import com.demo.util.SpringContextUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Service;

@Service
public class AutoInjectService implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //构造bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(TestController.class);
        BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
        //注册bean定义
        registry.registerBeanDefinition("autoBean", beanDefinition);
        TestController controller = (TestController) SpringContextUtil.getBean("autoBean");
        controller.toAction("BeanDefinitionRegistryPostProcessor ......................");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        // 注册Bean实例，使用supply接口, 可以创建一个实例，并主动注入一些依赖的Bean；当这个实例对象是通过动态代理这种框架生成时，就比较有用了

       /* BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(AutoFacDIBean.class, () -> {
            AutoFacDIBean autoFacDIBean = new AutoFacDIBean("autoFac");
            autoFacDIBean.setAutoBean(factory.getBean("autoBean", AutoBean.class));
            autoFacDIBean.setOriginBean(factory.getBean("originBean", OriginBean.class));
            return autoFacDIBean;
        });
        BeanDefinition beanDefinition = builder.getRawBeanDefinition();
        ((DefaultListableBeanFactory) factory).registerBeanDefinition("autoFacDIBean", beanDefinition);*/
    }
}
