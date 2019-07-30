package com.kevin.interceptor;

import com.kevin.entity.User;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author caonanqing
 * @version 1.0
 * @description     实现拦截器接口，在方法需要拦截的页面时执行
 * @createDate 2019/7/29
 */
public class LoginInterceptor implements HandlerInterceptor {

   Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requireAuthPages = {"index"};      // /index被拦截，重定向到/login

        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri,contextPath+"/");      // 去掉 /
        String page = uri;

        if(beginWith(page,requireAuthPages)) {
            User user = (User)session.getAttribute("user");
            logger.info("user: [{}], uri: {}",user,uri);
            // 判断user是否存在，不存在则转到login页面
            if(user == null) {
                response.sendRedirect("login");
                return false;
            }
        }
        return true;
    }

    // 判断是否需要拦截
    private boolean beginWith(String page, String[] requireAuthPages) {
        boolean result = false;
        for(String requiredAuthPage : requireAuthPages) {
            if(StringUtils.startsWith(page,requiredAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
