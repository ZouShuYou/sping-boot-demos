package com.demos.springboot.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-30 15:58
 */
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private String address;

    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        System.out.println("6.实例化Bean------>通过类构造器----->调用Person的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Person 被【注入属性】注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setAddress(String address) {
        System.out.println("Person 被【注入属性】注入属性address");
        this.address = address;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("9.【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("8.【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = s;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("14.【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("11.属性赋值之后-------->【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    public void myInit(){
        System.out.println("12.【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    public void myDestroy(){
        System.out.println("15.【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }
}
