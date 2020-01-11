package com.kevin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kevin
 * @version 1.0
 * @description     springboot中服务端数据，数据效验
 * @createDate 2019/3/14
 */
@SpringBootApplication
public class ValidateApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidateApplication.class,args);
    }
}

/**
 * @Null，标注的属性值必须为空
 * @NotNull，标注的属性值不能为空
 * @AssertTrue，标注的属性值必须为true
 * @AssertFalse，标注的属性值必须为false
 * @Min，标注的属性值不能小于min中指定的值
 * @Max，标注的属性值不能大于max中指定的值
 * @DecimalMin，小数值，同上
 * @DecimalMax，小数值，同上
 * @Negative，负数
 * @NegativeOrZero，0或者负数
 * @Positive，整数
 * @PositiveOrZero，0或者整数
 * @Size，指定字符串长度，注意是长度，有两个值，min以及max，用于指定最小以及最大长度
 * @Digits，内容必须是数字
 * @Past，时间必须是过去的时间
 * @PastOrPresent，过去或者现在的时间
 * @Future，将来的时间
 * @FutureOrPresent，将来或者现在的时间
 * @Pattern，用于指定一个正则表达式
 * @NotEmpty，字符串内容非空
 * @NotBlank，字符串内容非空且长度大于0
 * @Email，邮箱
 * @Range，用于指定数字，注意是数字的范围，有两个值，min以及max
 */
