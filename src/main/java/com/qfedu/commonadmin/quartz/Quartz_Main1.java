package com.qfedu.commonadmin.quartz;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

/**
 *@Author feri
 *@Date Created in 2018/10/13 14:23
 * 简单触发器
 */
public class Quartz_Main1 {
    public static void main(String[] args) throws SchedulerException {
        //1、创建执行器
        Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();
        //2、创建触发器
        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("t1","g1").
                withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(2,3)).
                startNow().build();
        //3、创建作业对象
        JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).build();
        //4、设置任务
        scheduler.scheduleJob(jobDetail,trigger);
        //5、启动任务
        scheduler.start();//启动
//        scheduler.pauseJob();//暂停
//        scheduler.resumeJob();//恢复
        //scheduler.shutdown();//停止

    }
}
