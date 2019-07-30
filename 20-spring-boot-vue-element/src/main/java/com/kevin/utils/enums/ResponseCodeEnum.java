package com.kevin.utils.enums;

/**
 * @author caonanqing
 * @version 1.0
 * @description     系统全局响应码
 * @createDate 2019/7/29
 */
public enum ResponseCodeEnum {

    /**
     * 请求成功
     */
    OK(200,"请求成功")
    /**
     * 请求异常
     */
    ,REQUEST_EXCEPTION(400,"请求处理异常，请稍后再试")
    /**
     * 账号或密码不正确
     */
    ,INCORRECT_ACCOUNT_OR_PASSWORD(401,"账号或密码不正确")
    /**
     * 资源不存在
     */
    ,RESOURCE_NOT_FOUND(404,"资源不存在")
    /**
     * 服务器错误
     */
    ,SERVER_ERROR(500,"服务器错误")
    /**
     * 请求路径不存在
     */
    ,REQUEST_PATH_NOT_FOUND(501,"请求路径不存在")
    /**
     * 权限不足
     */
    ,INSUFFICIENT_PERMISSIONS(502,"权限不足")
    /**
     * 登录已过期，请重新登录
     */
    , LAND_EXPIRATION(20011, "登陆已过期,请重新登陆")
    /**
     * 缺少必填参数
     */
    , LACK_OF_PARAMETER(30001, "缺少必填参数")
    /**
     * POST请求方法错误
     */
    , REQUEST_METHOD_ERROR(40001, "GET/POST请求方法错误")
    ;

    private Integer code;
    private String msg;

    ResponseCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    // 根据状态码获取状态信息
    public static String getMsgByCode(Integer code) {
        ResponseCodeEnum[] values = ResponseCodeEnum.values();
        for (ResponseCodeEnum ce:values) {
            if(ce.code == code)
                return ce.msg;
        }
        return "";
    }


}
