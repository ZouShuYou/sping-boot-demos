package com.springboot.demos.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-23 13:38
 */
@Data
public class User implements Serializable {

    private Long id;
    private String userName;
    private String password;
    private String userSex;
    private String nickName;
}
