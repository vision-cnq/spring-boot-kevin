package com.kevin.commons.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author caonanqing
 * @version 1.0
 * @description     WebMvc配置
 * @createDate 2019/8/21
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    JWTInterceptor jwtInterceptor;

    /**
     *  API接口拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/user/**");
    }


}
