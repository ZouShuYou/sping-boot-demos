package com.demos.springboot.contranst;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-18 17:27
 */
public enum  UserSexEnum {

    man("man") ,

    woman("woman");

    private String sex;

    UserSexEnum(String sex){
        this.sex = sex;
    }
}
