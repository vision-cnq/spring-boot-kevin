package com.kevin.util.constants;

/**
 * @author caonanqing
 * @version 1.0
 * @description     通用常量类, 单个业务的常量请单开一个类, 方便常量的分类管理
 * @createDate 2019/6/26
 */
public class Constants {

    /**
     * 请求成功代码
     */
    public static final Integer CODE_SUCCESS = SuccessEnum.OK.getCode();
    /**
     * 请求成功消息
     */
    public static final String MSG_SUCCESS = SuccessEnum.OK.getMessage();
    /**
     * 请求失败代码
     */
    public static final Integer CODE_FAIL = ErrorEnum.E_500.getErrorCode();
    /**
     * 请求失败消息
     */
    public static final String MSG_FAIL = ErrorEnum.E_500.getErrorMsg();
    /**
     * session中存放用户信息的key值
     */
    public static final String SESSION_USER_INFO = "userInfo";
    public static final String SESSION_USER_PERMISSION = "userPermission";
}
