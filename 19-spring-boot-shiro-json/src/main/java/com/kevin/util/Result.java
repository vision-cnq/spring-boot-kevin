package com.kevin.util;

import com.kevin.util.constants.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caonanqing
 * @version 1.0
 * @description		自定义响应结构
 * @createDate 2019/6/26
 */
public class Result<T> {

    // 一级响应业务状态码 200 成功， 500 服务器错误。。。。
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Map<String,T> info = new HashMap<>();

    public static <T> Result<T> build(Integer status, String msg, String dataKey, T data) {
        return new Result<T>(status, msg, dataKey,data);
    }

    public static <T> Result<T> ok(String dataKey, T data) {
        return new Result<T>(dataKey, data);
    }

    public static <T> Result<T> ok() {
        return new Result<T>(Constants.CODE_SUCCESS, Constants.MSG_SUCCESS);
    }

    public static <T> Result<T> fail() {
        return new Result<T>(Constants.CODE_FAIL, Constants.MSG_FAIL);
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
        this.info.put(dataKey,data);
    }

    public Result(String dataKey, T data) {
        this.code = Constants.CODE_SUCCESS;
        this.msg = Constants.MSG_SUCCESS;
        this.info.put(dataKey,data);
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

    public Map<String,T> getInfo() {
        return info;
    }

    public void addInfo(String dataKey, T data){
        if(dataKey == null || dataKey.length() == 0){
            throw new RuntimeException(" key can not be null ...");
        }
        this.info.put(dataKey,data);
    }

}
