package com.qfedu.commonadmin.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@Author feri
 *@Date Created in 2018/10/13 15:15
 */
@Configuration
public class QuartzConfig {

    //创建执行器
//    @Bean
//    public Scheduler createScheduler(){
//        try {
//            return StdSchedulerFactory.getDefaultScheduler();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
