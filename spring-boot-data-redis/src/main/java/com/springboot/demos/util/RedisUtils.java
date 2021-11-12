package com.springboot.demos.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-03-23 15:23
 */
@Component
public class RedisUtils {

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    public boolean expire(String key,long time){
        if (time > 0) {
            redisTemplate.expire(key,time, TimeUnit.SECONDS);
            return true;
        }
        return false;
    }

    public Long getExpire(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            return false;
        }

    }

    public void del(String... keys){
        if (keys!= null && keys.length>0){
            if (keys.length == 1){
                redisTemplate.delete(keys[0]);
            }else {
                redisTemplate.delete(Arrays.asList(keys));
            }
        }
    }

    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    public void hset(String key,String hashkey,Object val){
        redisTemplate.opsForHash().put(key,hashkey,val);
    }
}
