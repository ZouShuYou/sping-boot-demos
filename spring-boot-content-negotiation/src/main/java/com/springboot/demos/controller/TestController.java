package com.springboot.demos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-09-13 15:35
 */
@RestController
public class TestController {

    @GetMapping(value = "test", consumes = "text/properties")
    public Properties test(@RequestBody Properties properties){
        return properties;
    }
}
