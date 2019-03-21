package com.kevin.quartz;

import com.kevin.service.UsersService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kevin
 * @version 1.0
 * @description     Job执行的任务类
 * @createDate 2019/3/20
 */
public class QuartzDemo implements Job {

    @Autowired
    private UsersService usersService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //System.out.println("Execute..."+new Date());
        this.usersService.addUsers();
    }
}
