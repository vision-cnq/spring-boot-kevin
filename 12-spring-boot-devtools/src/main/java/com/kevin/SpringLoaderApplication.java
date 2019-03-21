package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kevin
 * @version 1.0
 * @description     热部署方式一：SpringLoader
 *          以maven插件方式使用SpringLoader
 *      SpringLoader缺点：只能对java代码生效，对html等页面代码不起作用
 *      注意：这种方式的缺点是SpringLoader热部署程序是在系统后台形式运行。
 *      这个时候需要手动关闭该进程，不然会抛出端口占用的异常
 * @createDate 2019/3/20
 */
/*@SpringBootApplication
public class SpringLoaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLoaderApplication.class,args);
    }
}*/
