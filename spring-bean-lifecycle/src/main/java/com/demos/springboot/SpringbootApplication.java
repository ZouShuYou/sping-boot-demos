package com.demos.springboot;

import com.demos.springboot.bean.Person;
import com.demos.springboot.bean.User;
import com.demos.springboot.config.AppConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        System.out.println("现在开始初始化容器");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("容器初始化成功");

        Person person = context.getBean(Person.class);
        User user = context.getBean(User.class);

        System.out.println(person);
        System.out.println(user);

        System.out.println("现在开始关闭容器！");

        ((AbstractApplicationContext) context).registerShutdownHook();

    }

}
