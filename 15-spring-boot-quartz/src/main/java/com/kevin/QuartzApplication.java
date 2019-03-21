package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author kevin
 * @version 1.0
 * @description     SptingBoot整合Quart定时任务框架
 *      方式一：编写配置类
 *
 *      Quartz可以与javaee与javase应用程序结合使用，也可以单独使用。
 *      Quartz可以用来创建简单或为运行十个，百个，甚至是好几万个Jobs这样复杂的程序。Jobs可以做成标准的Java组件或EJBs。
 *
 *      Quartz的使用思路：
 *          job任务：你需要做什么事？
 *          Trigger触发器：你什么时候去做？
 *          Scheduler任务调度：你什么时候需要去做什么事？
 *
 *      在pom.xml中加入以下依赖包
 *          <!-- 添加Scheduled依赖包 -->
 *         <dependency>
 *             <groupId>org.springframework</groupId>
 *             <artifactId>spring-context-support</artifactId>
 *         </dependency>
 *         <!-- spring tx事务的依赖包 -->
 *         <dependency>
 *             <groupId>org.springframework</groupId>
 *             <artifactId>spring-tx</artifactId>
 *         </dependency>
 *         <!-- Quartz依赖包 -->
 *         <dependency>
 *             <groupId>org.quartz-scheduler</groupId>
 *             <artifactId>quartz</artifactId>
 *             <!-- 排除该依赖包内的slf4j-api依赖项 -->
 *             <exclusions>
 *                 <exclusion>
 *                     <artifactId>slf4j-api</artifactId>
 *                     <groupId>org.slf4j</groupId>
 *                 </exclusion>
 *             </exclusions>
 *         </dependency>
 * @createDate 2019/3/20
 */
@SpringBootApplication
@EnableScheduling       // 开启定时器
public class QuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class,args);
    }
}
