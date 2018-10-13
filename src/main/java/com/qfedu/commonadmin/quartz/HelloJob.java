package com.qfedu.commonadmin.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *@Author feri
 *@Date Created in 2018/10/13 14:22
 */
public class HelloJob implements Job {
    //任务执行的内容
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("重要的事情说三遍！！！："+System.currentTimeMillis());
    }
}
