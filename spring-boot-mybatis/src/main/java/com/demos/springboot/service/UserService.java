package com.demos.springboot.service;

import com.demos.springboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-18 17:35
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public Map findByUserName(String userNmae) {
        Map<String, Object> map = userDao.findUserByName(userNmae);

        return map;

    }
}
