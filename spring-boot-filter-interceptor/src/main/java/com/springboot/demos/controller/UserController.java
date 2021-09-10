package com.springboot.demos.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demos.domain.User;
import com.springboot.demos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-18 17:34
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ResponseBody
    public User findByUserName(@RequestParam(value = "userName",required = true) String userNmae){
        return userService.findByUserName(userNmae);
    }


    @RequestMapping(value = "/jacksonSerialization",method = RequestMethod.GET)
    @ResponseBody
    public String jacksonSerialization() throws JsonProcessingException {
        User user = userService.findByUserName("zhangsan");
        String s = objectMapper.writeValueAsString(user);
        return s;
    }

    @RequestMapping(value = "/jacksonReSerialization",method = RequestMethod.GET)
    @ResponseBody
    public User readJsonString() throws JsonProcessingException {
        String s ="{\n" +
                "  \"id\": 1,\n" +
                "  \"userName\": \"zhangsan\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"userSex\": \"man\",\n" +
                "  \"nickName\": \"asdf\",\n" +
                "  \"birthday\": \"2000-09-11 00:00:00\"\n" +
                "}";
        User o = (User) objectMapper.readValue(s, User.class);
        return o;
    }


    @RequestMapping(value = "/customize",method = RequestMethod.GET)
    @ResponseBody
    public String customize() throws JsonProcessingException {
        String jsonStr = "[{\"userName\":\"mrbird\",\"password\":26},{\"userName\":\"scott\",\"password\":27}]";
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, User.class);
        List<User> list = objectMapper.readValue(jsonStr, javaType);
        String msg = "";
        for (User user : list) {
            msg += user.getUserName();
        }
        return msg;
    }
}
