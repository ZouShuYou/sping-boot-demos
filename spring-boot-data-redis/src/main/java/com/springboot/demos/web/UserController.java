package com.springboot.demos.web;

import com.springboot.demos.domain.User;
import com.springboot.demos.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-23 13:39
 */
@RestController
public class UserController {

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping(value = "/user")
    public void addUser(@RequestBody User user){
        redisUtils.hset("user",user.getUserName(),user);
    }
}
