package com.kevin.util.model;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * 处理嵌套查询结果时，MyBatis会根据bean定义的属性类型来初始化嵌套的成员变量，
 * 主要看其是不是Collection
 * 如果这里不定义，那么嵌套返回结果里就只能返回一对一的结果，而不是一对多的
 * @createDate 2019/6/26
 */
public class One2Many extends HashMap {
    private Set<String> roleList;
    private Set<String> menuList;
    private Set<String> permissionList;
    private Set<Integer> permissionIds;
    private List<HashMap> picList;
    private List<HashMap> menus;
    private List<HashMap> users;
    private List<HashMap> permissions;
}
