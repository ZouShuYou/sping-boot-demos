package com.demos.springboot;

import com.demos.springboot.bean.User;
import com.demos.springboot.config.AppConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = (User) context.getBean(User.class);
        System.out.println(user.getClass().getName());
        System.out.println(user.getAge());
        System.out.println(user.getName());
    }

}
