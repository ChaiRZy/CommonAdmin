package com.qfedu.commonadmin.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *@Author feri
 *@Date Created in 2018/10/13 14:42
 */
public class SleepJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.err.println("该睡觉了:"+System.currentTimeMillis()/1000);
    }
}
