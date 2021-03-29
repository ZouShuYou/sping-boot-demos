package com.springboot.demos.dao.one;


import com.springboot.demos.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-18 17:32
 */
@Mapper
public interface UserDao {

    @Select(value = "select id, userName, password, user_sex, nick_name from user")
    @Results({
        @Result(property = "id",column = "id"),
        @Result(property = "userName",column = "userName"),
        @Result(property = "userSex",column = "user_sex"),
        @Result(property = "nickName",column = "nick_name"),
    })
    User findUserByName(String userName);
}
