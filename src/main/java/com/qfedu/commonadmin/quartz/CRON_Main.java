package com.qfedu.commonadmin.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.swing.table.TableRowSorter;

/**
 *@Author feri
 *@Date Created in 2018/10/13 14:57
 * 基于CRON表达式
 */
public class CRON_Main {
    public static void main(String[] args) throws SchedulerException {
        //执行器
        Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
        //表达式：每隔3秒执行一次
       // String cron="0/3 * * * * ? ";
        //每年10月的每个周六 间隔1秒
        //String cron="0/1 * * ? 10 7 ";
        //每天早上6点，间隔4小时
        //String cron="0 0 6/4 * 10 ? ";
        //每月的最后一个工作日
        String cron="0 0 * LW 10 ? ";

        //触发器
        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("t3","g1").
                withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
        //作业详情
        JobDetail jobDetail=JobBuilder.newJob(SleepJob.class).build();
        //设置
        scheduler.scheduleJob(jobDetail,trigger);
        //执行
        scheduler.start();
    }
}
