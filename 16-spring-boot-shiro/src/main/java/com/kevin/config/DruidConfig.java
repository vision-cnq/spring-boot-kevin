package com.kevin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author caonanqing
 * @version 1.0
 * @description     Druid配置类连接池
 * @createDate 2019/5/14
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource druid(){
        System.out.println("==========DruidConfig.druid()==========");
        return new DruidDataSource();
    }

    /**
     *  配置监控服务器
     **/
    @Bean
    public ServletRegistrationBean statViewServlet(){
        System.out.println("==========DruidConfig.statViewServlet()==========");

        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        // druid后台管理员用户
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","admin");
        // 是否能够重置数据
        initParams.put("resetEnable", "false");

        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     *  配置web监控的过滤器
     **/
    @Bean
    public FilterRegistrationBean webStatFilter(){
        System.out.println("==========DruidConfig.webStatFilter()==========");

        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则
        bean.addUrlPatterns("/*");
        Map<String,String> initParams = new HashMap<>();
        // 忽略过滤格式
        initParams.put("exclusions","*.js,*.css,*.icon,*.png,*.jpg,/druid/*");
        bean.setInitParameters(initParams);
        return  bean;
    }
}