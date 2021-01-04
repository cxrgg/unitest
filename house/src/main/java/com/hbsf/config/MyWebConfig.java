package com.hbsf.config;

import com.hbsf.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 岑祥荣
        * @date 2019/12/26 13:35
        */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/page/**").excludePathPatterns("/page/sys/newEmp/**");
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/sys/newEmp/**");
    }
}
