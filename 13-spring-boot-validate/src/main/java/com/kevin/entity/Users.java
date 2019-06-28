package com.kevin.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 * @author kevin
 * @version 1.0
 * @description     在实体类添加效验规则
 *              springboot使用了hibernate-validate效验规则
 * @createDate 2019/3/14
 */
public class Users {

    /**
     * @NotBlank：判断字符串是否为为null或者是空串（去掉首尾空格）
     * @NotEmpty：判断字符串是否为null或者是空串（不会去掉首尾空格）
     * @Length：判断字符的长度（最大或者最小）
     * @Min：判断数值最小值
     * @Max：判断数值最大值
     * @Email：判断邮箱是否合法
     *
     */

    // 一个属性可以加多个效验
    @NotBlank(message = "用户名不能为空")   // 非空校验
    @Length(min=2,max=6,message = "最小长度为二位，最大长度为六位")    // 长度最小不能小于2位，最大不能大于6位
    private String name;
    @NotBlank(message = "密码不能为空")   // 密码非空效验
    private String password;
    @Min(value = 0,message = "最小年龄不能小于0岁")
    @Max(value = 150,message = "最大年龄不能大于150岁")
    private Integer age;
    @Email
    private String email;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
