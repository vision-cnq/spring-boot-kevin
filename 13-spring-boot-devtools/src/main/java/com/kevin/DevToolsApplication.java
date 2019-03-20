package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kevin
 * @version 1.0
 * @description     热部署方式二：使用DevTools
 *      使用DevTools工具，作为热部署
 *  SpringLoader与DevTools的区别：
 *      SpringLoader：在部署项目时使用的热部署方式。
 *      DevTools：在部署项目时使用的是重新部署的方式。
 *
 *  DevTools只需要加入DevTools依赖项，不需要做别的操作，会自动生效。
 *  java文件修改则自动重启项目，因为重新编译成class文件。
 *  html等页面文件修改则不会自动重启项目，因为不需要重新编译
 *
 *  IDEA中如果加入devtools，但热部署并没有生效，有两个步骤
 *  1.需要在File-/Settings/Build,Execution,Deployent/Compiler/中勾选上Build project automatically选项
 *  2.同时按Shift+Ctrl+Alt+/   勾选上compiler.automake.allow.when.app.running选项
 *  这样就devtools就会生效了
 *
 * @createDate 2019/3/20
 */
@SpringBootApplication
public class DevToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevToolsApplication.class,args);
    }
}
