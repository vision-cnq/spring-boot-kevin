package com.kevin.util;

/**
 * @author caonanqing
 * @version 1.0
 * @description     判断数据是否为空
 * @createDate 2019/6/26
 */
public class StringTools {

    public static boolean isNullOrEmpty(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    public static boolean isNullOrEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }
}