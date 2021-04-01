package com.demos.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-04-01 15:04
 */
@Configuration
public class AsyncPoolConfig {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setCorePoolSize(4);
        taskExecutor.setKeepAliveSeconds(200);
        taskExecutor.initialize();
        taskExecutor.setThreadNamePrefix("asyncPools");
        return taskExecutor;
    }
}
