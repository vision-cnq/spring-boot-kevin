package com.kevin.config;

import com.kevin.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author caonanqing
 * @version 1.0
 * @description     将拦截器配置到项目中
 * @createDate 2019/7/29
 */
@SpringBootConfiguration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 将我们自定义的拦截器添加到项目SpringBoot中，对所有路径都进行拦截。（/index.html除外）
        registry.addInterceptor(getInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/static/**");
    }
}
