package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author kevin
 * @version 1.0
 * @description     SpringBoot整合Scheduled定时任务器
 *
 *      在pom.xml中加入Scheduled依赖包
 *      <!-- 添加Scheduled依赖包 -->
 *         <dependency>
 *             <groupId>org.springframework</groupId>
 *             <artifactId>spring-context-support</artifactId>
 *         </dependency>
 *
 * @createDate 2019/3/20
 */
@SpringBootApplication
@EnableScheduling       // 启动定时器
public class ScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledApplication.class,args);
    }

}
