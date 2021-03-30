package com.demos.springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-30 16:13
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public MyInstantiationAwareBeanPostProcessor() {
        System.out.println("4.调用InstantiationAwareBeanPostProcessor实现类构造器--------->实例化InstantiationAwareBeanPostProcessor实现类");
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("5.在bean实例化之前：  调用InstantiationAwareBeanPostProcessor实现类postProcessBeforeInstantiation方法   " + beanName);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("7.在bean实例化之后：  调用InstantiationAwareBeanPostProcessor实现类postProcessAfterInstantiation方法    " + beanName);
        return false;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("6.  InstantiationAwareBeanPostProcessor调用postProcessProperties设置某个属性");
        return null;
    }
}
