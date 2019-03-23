package com.kevin.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author kevin
 * @version 1.0
 * @description     Scheduled定时任务
 * @createDate 2019/3/20
 */
@Component
public class ScheduledDemo {

    /**
     * 定时任务方法
     *     @Scheduled：设置定时任务
     *     cron属性：cron表达式，定时任务触发是时间的一个字符串表达形式
     *
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void scheduledMethod(){
        // 设置每两秒启动一次
        System.out.println("定时器被触发"+new Date());
    }
}
