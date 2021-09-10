package com.springboot.demos.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.demos.contranst.UserSexEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
    @JsonProperty("sex")
    private UserSexEnum userSex;
    private String nickName;
    private Date birthday;
}
