package com.kevin.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @author kevin
 * @version 1.0
 * @description     想要调用service数据持久层需要重写createJobInstance，并将实例化对象注入到SpringIOC容器中
 *      如果不要要在Job任务类中调用service，则不需要重写该类
 * @createDate 2019/3/20
 */
@Component("myAdaptableJobFactory")     // 给注入SpringIOC的对象起个名称
public class MyAdaptableJobFactory extends AdaptableJobFactory {

    // AutowireCapableBeanFactory 可以将一个对象添加到SpringIOC容器中，并完成该对象注入
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    // 该方法需要将实例化的任务对象手动的添加到SpringIOC容器中并完成对象注入
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object obj = super.createJobInstance(bundle);
        // 将obj对象添加到SpringIOC容器中，并完成注入
        this.autowireCapableBeanFactory.autowireBean(obj);
        return obj;
    }
}
