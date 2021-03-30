package com.demos.springboot.config;

import com.demos.springboot.bean.MyBeanFactoryPostProcessor;
import com.demos.springboot.bean.MyBeanPostProcessor;
import com.demos.springboot.bean.MyInstantiationAwareBeanPostProcessor;
import com.demos.springboot.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-29 17:40
 */
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean(name = "ppp",initMethod = "myInit",destroyMethod = "myDestroy")
    public Person getPerson(){
        return new Person();
    }

    @Bean(name = "myBeanFactoryPostProcessor")
    public MyBeanFactoryPostProcessor getMyBeanFactoryPostProcessor(){
        return new MyBeanFactoryPostProcessor();
    }

    @Bean
    public MyBeanPostProcessor myBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean
    public MyInstantiationAwareBeanPostProcessor getMyInstantiationAwareBeanPostProcessor(){
        return  new MyInstantiationAwareBeanPostProcessor();
    }
}
