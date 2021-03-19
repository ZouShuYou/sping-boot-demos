package com.springboot.demos.service;


import com.springboot.demos.dao.UserDao;
import com.springboot.demos.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public User findByUserName(String userNmae) {
        return userDao.findUserByName(userNmae);
    }
}
