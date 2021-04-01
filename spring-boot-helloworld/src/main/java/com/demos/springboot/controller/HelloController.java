package com.demos.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-18 15:07
 */
@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "hello world spring boot";
    }
}
