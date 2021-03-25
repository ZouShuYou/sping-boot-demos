package com.demos.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-18 17:32
 */
@Mapper
public interface UserDao {

    Map<String, Object> findUserByName(String userName);
}
