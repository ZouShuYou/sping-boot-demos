package com.demos.springboot.domain;

import com.demos.springboot.contranst.UserSexEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-18 17:25
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 8219877775570044039L;

    private Long id;
    private String userName;
    private String password;
    private UserSexEnum userSex;
    private String nickName;
}
