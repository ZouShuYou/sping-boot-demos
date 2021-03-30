package com.demos.springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-30 16:19
 */

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        System.out.println("1.执行BeanFactoryPostProcessor实现类构造器------->实例化BeanFactoryPostProcessor实现类！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("2.调用BeanFactoryPostProcessor实现类重写的方法------->BeanFactoryPostProcessor调用postProcessBeanFactory方法   这里可以对bean容器中的bean进行属性赋值");
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("ppp");
        beanDefinition.getPropertyValues().addPropertyValue("name","yxq");
    }
}
