package com.demos.springboot.controller;

import com.demos.springboot.domain.User;
import com.demos.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-18 17:34
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public User findByUserName(@RequestParam(value = "userName",required = true) String userNmae){
        return userService.findByUserName(userNmae);
    }
}
