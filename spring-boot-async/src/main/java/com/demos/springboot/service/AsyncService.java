package com.demos.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-04-01 14:49
 */
@Service
public class AsyncService {
    private Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async("threadPoolTaskExecutor")
    public void testAsync(){
        sleep();
        logger.info("异步调用线程信息："+Thread.currentThread().getName());
    }

    @Async("threadPoolTaskExecutor")
    public Future<String> async(){
        sleep();
        logger.info("异步调用线程信息："+Thread.currentThread().getName());
        return new AsyncResult<>("异步调用成功");
    }

    public void testSync(){
        sleep();
        logger.info("同步调用线程信息："+Thread.currentThread().getName());
    }

    public void sleep(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
