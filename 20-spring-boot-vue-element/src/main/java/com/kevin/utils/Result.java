package com.kevin.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caonanqing
 * @version 1.0
 * @description     自定义响应结构
 * @createDate 2019/7/27
 */
public class Result<T> {

    private final static Integer CODE_SUCCESS = 200;
    private final static Integer CODE_FAIL = 500;
    private final static String MSG_SUCCESS = "操作成功";
    private final static String MSG_FAIL = "服务器错误";

    // 响应码
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Map<String,T> data = new HashMap<>();

    public static <T> Result<T> build(Integer status, String msg, String dataKey, T data) {
        return new Result<T>(status, msg, dataKey,data);
    }

    public static <T> Result<T> ok(String dataKey, T data) {
        return new Result<T>(dataKey, data);
    }

    public static <T> Result<T> ok() {
        return new Result<T>(CODE_SUCCESS, MSG_SUCCESS);
    }

    public static <T> Result<T> fail() {
        return new Result<T>(CODE_FAIL, MSG_FAIL);
    }

    public Result() {
    }

    public static <T> Result<T> build(Integer status, String msg) {
        return new Result<T>(status, msg);
    }

    public Result(Integer status, String msg) {
        this.code = status;
        this.msg = msg;
    }

    public Result(Integer status, String msg, String dataKey, T data) {
        this.code = status;
        this.msg = msg;
        this.data.put(dataKey,data);
    }

    public Result(String dataKey, T data) {
        this.code = CODE_SUCCESS;
        this.msg = MSG_SUCCESS;
        this.data.put(dataKey,data);
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

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String,T> getData() {
        return data;
    }

    public void addData(String dataKey, T data){
        if(dataKey == null || dataKey.length() == 0){
            throw new RuntimeException(" key can not be null ...");
        }
        this.data.put(dataKey,data);
    }



}
