package com.kevin.config;

import com.kevin.quartz.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author kevin
 * @version 1.0
 * @description     Quartz配置类
 * @createDate 2019/3/20
 */
@Configuration
public class QuartzConfig {

    //1.创建Job对象
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factory = new JobDetailFactoryBean();
        // 关联我们自己的Job类
        factory.setJobClass(QuartzDemo.class);
        return factory;
    }

    // 2.创建Trigger对象。方式一：使用Cron Trigger，使用Cron表达式设置触发时间
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean factory = new CronTriggerFactoryBean();
        factory.setJobDetail(jobDetailFactoryBean.getObject());
        // 设置触发时间
        factory.setCronExpression("0/2 * * * * ?"); // 触发时间，每两秒触发一次
        return factory;
    }

    //3.创建Schrduler对象，想要调用Service，所以需要将MyAdaptableJobFactory对象实例化
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,
                                                     MyAdaptableJobFactory myAdaptableJobFactory){
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // 关联Trigger对象
        factory.setTriggers(cronTriggerFactoryBean.getObject());
        // 调用到MyAdaptableJobFactory并完成对象实例化
        factory.setJobFactory(myAdaptableJobFactory);
        return factory;
    }

    //3.创建Schrduler对象，不需要调用Service
    /*@Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean){
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // 关联Trigger对象
        factory.setTriggers(cronTriggerFactoryBean.getObject());
        return factory;
    }*/

    //2.创建Trigger对象。方式二：简单的Trigger，使用内置方法设置触发时间
    /*@Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        SimpleTriggerFactoryBean factory = new SimpleTriggerFactoryBean();
        // 关联JobDetail对象
        factory.setJobDetail(jobDetailFactoryBean.getObject());
        // 该参数表示一个执行的毫秒数
        factory.setRepeatInterval(2000);
        // 重复次数
        factory.setRepeatCount(5);
        return factory;
    }

    //3.创建Schrduler对象
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean){
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // 关联Trigger对象
        factory.setTriggers(simpleTriggerFactoryBean.getObject());
        return factory;
    }*/



}
