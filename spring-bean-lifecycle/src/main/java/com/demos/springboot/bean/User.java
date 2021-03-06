package com.demos.springboot.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-29 17:40
 */

@Data
public class User {

    @Value(value = "${user1.name1}")
    private String name;

    @Value(value = "${user1.age1}")
    private String age;

}
