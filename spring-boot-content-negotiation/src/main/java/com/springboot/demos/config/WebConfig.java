package com.springboot.demos.config;

import com.springboot.demos.converter.MyHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-09-13 15:33
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
    
    
    @PostConstruct
    public void init(){

        List<HandlerMethodReturnValueHandler> argumentResolvers  = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newArgumentResolvers = new ArrayList<>(argumentResolvers.size() + 1);


    }


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0,new MyHttpMessageConverter());
    }
}
