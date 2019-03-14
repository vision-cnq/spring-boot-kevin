package com.kevin.model;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/3/14
 */
public class Users {
    private Integer userid;
    private String username;
    private Integer userage;
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getUserage() {
        return userage;
    }
    public void setUserage(Integer userage) {
        this.userage = userage;
    }
    public Users(Integer userid, String username, Integer userage) {
        super();
        this.userid = userid;
        this.username = username;
        this.userage = userage;
    }
    public Users() {
        super();
    }

}
