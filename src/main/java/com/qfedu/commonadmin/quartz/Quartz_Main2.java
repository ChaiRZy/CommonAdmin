package com.qfedu.commonadmin.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 *@Author feri
 *@Date Created in 2018/10/13 14:37
 * 日历触发器
 */
public class Quartz_Main2 {
    public static void main(String[] args) throws SchedulerException {
        //执行器
        Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
        //触发器
        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("t2","g1").withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInMinutes(1)).startNow().build();
        //作业
        JobDetail jobDetail=JobBuilder.newJob(SleepJob.class).build();
        //设置
        scheduler.scheduleJob(jobDetail,trigger);
        //开启
        scheduler.start();

    }
}
