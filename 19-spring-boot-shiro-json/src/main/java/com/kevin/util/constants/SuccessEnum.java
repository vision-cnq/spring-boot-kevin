package com.kevin.util.constants;

/**
 * @author caonanqing
 * @version 1.0
 * @description		成功枚举类
 * @createDate 2019/6/26
 */
public enum SuccessEnum {

    /**
     * 请求成功
     */
    OK(100, "请求成功")
    ;

    private int code;
    private String message;

    SuccessEnum(int code, String message) {
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
        SuccessEnum[] values = SuccessEnum.values();
        for (SuccessEnum ec : values) {
            if (ec.code == code) {
                return ec.message;
            }
        }
        return "";
    }

}
