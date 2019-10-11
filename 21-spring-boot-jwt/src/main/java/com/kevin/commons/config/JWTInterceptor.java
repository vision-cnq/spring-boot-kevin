package com.kevin.commons.config;

import com.kevin.commons.exception.CommonJsonException;
import com.kevin.utils.JWTUtils;
import com.kevin.utils.ResponseCodeEnum;
import com.kevin.utils.Result;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author caonanqing
 * @version 1.0
 * @description     Token验证拦截器
 * @createDate 2019/8/20
 */
@Component
public class JWTInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    JWTUtils jwtUtils;

    /**
     * 用户名标志
     */
    public static final String USER_KEY = "username";

    /**
     * 无需拦截该路径验证Token
     */
    public static final String[] NOT_CHECK_URL = new String[]{"/user/index","/user/login"};


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String servletPath = request.getServletPath();
        System.out.println("ServletPath: " + servletPath);
        // 不验证，通过
        boolean isNotCheck = isNotCheck(servletPath);
        if(isNotCheck) {
            return true;
        }
        // 需要进行验证
        String token = getToken(request);
        if(isBlank(token)) {
            Result result = new Result(ResponseCodeEnum.LAND_EXPIRATION.getCode(),ResponseCodeEnum.LAND_EXPIRATION.getMessage(),"header",jwtUtils.getHeader());
            throw new CommonJsonException(result);
        }

        // 获取签名信息
        Claims claims = jwtUtils.getClaimsToken(token);
        System.out.println("Token: " + claims);
        // 判断签名是否存在或过期
        boolean bool = claims == null || claims.isEmpty() || jwtUtils.isTokenExpired(claims.getExpiration());
        if(bool) {
            Result result = new Result(ResponseCodeEnum.LAND_EXPIRATION.getCode(),ResponseCodeEnum.LAND_EXPIRATION.getMessage(),"header",jwtUtils.getHeader());
            throw new CommonJsonException(result);
        }

        // 将签名中获取的用户信息放入request中
        request.setAttribute(USER_KEY,claims.getSubject());
        return true;
    }

    public boolean isNotCheck(String servletPath) {
        // 如果请求接口以/结尾，这去掉/
        servletPath = servletPath.endsWith("/") ? servletPath.substring(0, servletPath.lastIndexOf("/")) : servletPath;
        System.out.println("servletPath = " + servletPath);
        for (String path : NOT_CHECK_URL) {
            System.out.println("path = " + path);
            // path以/**结尾，servletPath以path前缀开头
            if(path.endsWith("/**")) {
                String pathStart = path.substring(0, path.lastIndexOf("/") + 1);
                System.out.println("pathStart = " + pathStart);
                if(servletPath.startsWith(pathStart)) {
                    return true;
                }

                String pathStart2 = path.substring(0,path.lastIndexOf("/"));
                System.out.println("pathStart2 = "+ pathStart2);
                if(servletPath.equals(pathStart2)) {
                    return true;
                }
            }

            if(servletPath.equals(path)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取请求的Token
     * @param request
     * @return
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(jwtUtils.getHeader());
        if(isBlank(token)){
            token = request.getParameter(jwtUtils.getHeader());
        }
        return token;
    }

    /**
     *  字符串都为空格、制表符、tab 的情况的判断
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                // 判断字符是否为空格、制表符、tab
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
}
