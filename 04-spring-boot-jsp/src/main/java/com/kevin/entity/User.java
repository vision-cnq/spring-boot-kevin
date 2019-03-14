package com.kevin.entity;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/3/13
 */
public class User {

    private Integer userId;
    private String userName;
    private Integer userage;

    public User() {
    }

    public User(Integer userId, String userName, Integer userage) {
        this.userId = userId;
        this.userName = userName;
        this.userage = userage;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userage=" + userage +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }
}
