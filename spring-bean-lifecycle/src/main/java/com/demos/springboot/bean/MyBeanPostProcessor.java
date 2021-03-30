package com.demos.springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-30 16:10
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        System.out.println("3.调用BeanPostProcessor实现类构造器----------->这是BeanPostProcessor实现类构造器！！");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("10.bean初始化之前------->BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("13.bean初始化之后-------->BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return null;
    }
}
