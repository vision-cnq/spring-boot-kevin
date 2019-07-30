package com.kevin.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author caonanqing
 * @version 1.0
 * @description     因为vue项目的端口是8080，而且也没有方法直接可以访问到。
 * 想要获取到，只能触发前端路由，即在后端添加处理内容，把通过这个URL渲染出的index.html返回到浏览器。
 *
 * @createDate 2019/7/29
 */
@Component
public class ErrorConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/index.html");
        registry.addErrorPages(error404);
    }
}
