package com.demos.springboot.config;

import com.demos.springboot.bean.*;
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
@PropertySource(value = "classpath:/application.properties")
public class AppConfig {

    @Bean(name = "ppp",initMethod = "myInit",destroyMethod = "myDestroy")
    public Person getPerson(){
        Person person = new Person();
        person.setName("zst");
        person.setAddress("sz");
        return person;
    }

    @Bean
    public User user(){
        return new User();
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
