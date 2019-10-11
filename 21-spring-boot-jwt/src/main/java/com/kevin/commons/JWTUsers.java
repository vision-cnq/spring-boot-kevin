package com.kevin.commons;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 *      用户数据，在开发应该访问数据库验证用户
 * @createDate 2019/8/19
 */
public class JWTUsers {

    private static final Map<String,String> USERS = new HashMap<>();

    static {
        USERS.put("admin","123456");
    }

    /**
     * 是否可以登录
     * @param username
     * @param password
     * @return
     */
    public static boolean isLogin(String username, String password) {
        if (null == username || username.trim().length() == 0)
            return false;
        String obj = USERS.get(username);
        if (null == obj || !obj.equals(password))
            return false;
        return true;
    }
}
