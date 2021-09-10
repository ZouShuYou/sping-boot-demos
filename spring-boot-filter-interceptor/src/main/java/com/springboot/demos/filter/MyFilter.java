package com.springboot.demos.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2021-09-10 10:36
 */
@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("开始执行过滤器");
        Long start = System.currentTimeMillis();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String s = httpServletRequest.getRequestURL().toString();
        if (s.contains("/user")){
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write("不允许访问此url");
            writer.flush();
            writer.close();
        }
        chain.doFilter(request, response);
        System.out.println("【过滤器】耗时 " + (System.currentTimeMillis() - start));
        System.out.println("结束执行过滤器");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
