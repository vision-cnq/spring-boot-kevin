package com.kevin.util;

import com.alibaba.fastjson.JSONObject;
import com.kevin.config.exception.CommonJsonException;
import com.kevin.util.constants.Constants;
import com.kevin.util.constants.ErrorEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/**
 * @author caonanqing
 * @version 1.0
 * @description     后台接口系统常用的json工具类
 * @createDate 2019/6/27
 */
public class CommonUtil {

    /**
     * 返回一个info为空对象的成功消息的json
     */
    public static Result successJson() {
        return successJson(new JSONObject());
    }

    /**
     * 返回一个返回码为200的json
     */
    public static Result successJson(Object info) {
        Result result = Result.ok();
        result.addInfo("info", info);
        return result;
    }

    /**
     * 返回错误信息JSON
     */
    public static Result errorJson(ErrorEnum errorEnum) {
        Result result = Result.fail();
        result.addInfo("info", new JSONObject());
        return result;
    }

    /**
     * 查询分页结果后的封装工具方法
     *
     * @param list 查询分页对象list
     */
    public static <T> Result successPage(List<T> list) {
        Result result = successJson();
        HashMap<String,Object> info = new HashMap<String,Object>();
        info.put("list", list);
        result.addInfo("info", info);
        return result;
    }

    /**
     * 查询分页结果后的封装工具方法
     *
     *   请求参数json,此json在之前调用fillPageParam 方法时,已经将pageRow放入
     * @param list        查询分页对象list
     * @param totalCount  查询出记录的总条数
     */
    public static <T> Result successPage(List<T> list, int totalCount) {
        int totalPage = getPageCounts(10, totalCount);
        Result result = successJson();
        JSONObject info = new JSONObject();
        info.put("list", list);
        info.put("totalCount", totalCount);
        info.put("totalPage", totalPage);
        result.addInfo("info", info);
        return result;
    }

    /**
     * 将request参数值转为json
     */
    public static JSONObject request2Json(HttpServletRequest request) {
        JSONObject requestJson = new JSONObject();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            String[] pv = request.getParameterValues(paramName);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pv.length; i++) {
                if (pv[i].length() > 0) {
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(pv[i]);
                }
            }
            requestJson.put(paramName, sb.toString());
        }
        return requestJson;
    }

    /**
     * 将request转JSON
     * 并且验证非空字段
     */
    public static Result convert2JsonAndCheckRequiredColumns(HttpServletRequest request, String requiredColumns) {
        JSONObject jsonObject = request2Json(request);
        return hasAllRequired(jsonObject.toString(), requiredColumns);
    }

    /**
     * 验证是否含有全部必填字段
     *
     * @param requiredColumns 必填的参数字段名称 逗号隔开 比如"userId,name,telephone"
     */
    public static Result hasAllRequired(final String json, String requiredColumns) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        if (!StringTools.isNullOrEmpty(requiredColumns)) {
            //验证字段非空
            String[] columns = requiredColumns.split(",");
            String missCol = "";
            for (String column : columns) {
                Object val = jsonObject.get(column.trim());
                if (StringTools.isNullOrEmpty(val)) {
                    missCol += column + "  ";
                }
            }
            if (!StringTools.isNullOrEmpty(missCol)) {
                Result result = new Result();
                result.setCode(ErrorEnum.E_90003.getErrorCode());
                result.setMsg("缺少必填参数:" + missCol.trim());
                result.addInfo("info", new JSONObject());
                throw new CommonJsonException(result);
            }
        }
        return Result.ok();
    }


    /**
     * 获取总页数
     *
     * @param pageRow   每页行数
     * @param itemCount 结果的总条数
     */
    private static int getPageCounts(int pageRow, int itemCount) {
        if (itemCount == 0) {
            return 1;
        }
        return itemCount % pageRow > 0 ?
                itemCount / pageRow + 1 :
                itemCount / pageRow;
    }
}
