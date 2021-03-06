package com.demos.springboot.controller;

import com.demos.springboot.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-04-01 14:49
 */
@RestController
public class AsyncController {
    private Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    AsyncService asyncService;

    @GetMapping("/async")
    public String async() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        logger.info("当前线程信息："+Thread.currentThread().getName());
        logger.info("开始执行@Async注解标记的异步方法：" + start);
        Future<String> async = asyncService.async();
        long end = System.currentTimeMillis();

        logger.info("耗时：{}", end - start);
        return async.get();
    }

    @GetMapping("/sync")
    public void sync(){
        long start = System.currentTimeMillis();
        logger.info("当前线程信息："+Thread.currentThread().getName());
        logger.info("开始执行同步方法：" + start);
        asyncService.testSync();
        long end = System.currentTimeMillis();

        logger.info("耗时：{}", end - start);
    }
}
