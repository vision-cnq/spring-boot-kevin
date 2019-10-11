package com.kevin.utils;

/**
 * @author caonanqing
 * @version 1.0
 * @description         系统全局响应码
 * @createDate 2019/8/19
 */
public enum ResponseCodeEnum {

    /**
     * 请求成功
     */
    OK(200, "请求成功")
    /**
     *
     */
    , REQUEST_HANDING_EXCEPTION(400, "请求处理异常，请稍后再试")
    /**
     * 资源不存在
     */
    , RESOURCE_NOT_FOUND(404, "资源不存在")
    /**
     * 服务器错误
     * **/
    , INTERNAL_SERVER_ERROR(500, "服务器错误")
    /**
     * 请求路径不存在
     */
    , INTERNAL_NOT_FOUND(501, "请求路径不存在")
    /**
     * 权限不足
     */
    , INSUFFICIENT_PERMISSIONS(502, "权限不足")

    /**
     * 登录已过期,请重新登录
     */
    , LAND_EXPIRATION(20011, "登录已过期,请重新登录")
    /**
     * 请先登录
     */
    , LOGIN_EXPIRATION(20010, "请先登录")

    /**
     * 缺少必填参数
     */
    , LACK_OF_PARAMETER(30001, "缺少必填参数")

    /**
     * POST请求方法错误
     */
    , REQUEST_METHOD_ERROR(40001, "GET/POST请求方法错误")
    ;

    private int code;
    private String message;

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getMessageByCode(int code) {
        ResponseCodeEnum[] values = ResponseCodeEnum.values();
        for (ResponseCodeEnum ec : values) {
            if (ec.code == code) {
                return ec.message;
            }
        }
        return "";
    }

}
