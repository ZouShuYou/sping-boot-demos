package com.demos.springboot;

import com.demos.springboot.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class SpringbootApplicationTests {

    @Test
    void contextLoads() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Object user = context.getBean("user");
        System.out.println(user.toString());
    }

}
