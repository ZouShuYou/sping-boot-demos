package com.demos.springboot.dao;

import com.demos.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-18 17:32
 */
@Mapper
public interface UserDao {

    User findUserByName(String userName);
}
