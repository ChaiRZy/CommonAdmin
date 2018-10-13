package com.qfedu.commonadmin.controller;

import com.qfedu.commonadmin.common.ResultUtil;
import com.qfedu.commonadmin.quartz.CnBlogJob;
import com.qfedu.commonadmin.spider.CnBlogsPipeline;
import com.qfedu.commonadmin.spider.CnBlogsProcess;
import com.qfedu.commonadmin.vo.R;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

/**
 *@Author feri
 *@Date Created in 2018/10/13 10:34
 */
@RestController
public class CnBlogsController {
//    String url="https://www.cnblogs.com/";
    @Autowired
    private CnBlogsPipeline cnBlogsPipeline;
    @Autowired
    private CnBlogsProcess cnBlogsProcess;

    @Autowired
    private Scheduler scheduler;

    //开启爬虫  爬取数据  定时
    @GetMapping("blogstart.do")
    public R start() throws SchedulerException {
        String cron="0 0 22 * * ?";
        Trigger trigger=TriggerBuilder.newTrigger().withIdentity("pccnBlogs","pc").
                withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
        JobDetail jobDetail=JobBuilder.newJob(CnBlogJob.class).withIdentity("pccnblogjob","jobs").build();
        JobDataMap jobDataMap=jobDetail.getJobDataMap();
        jobDataMap.put("process",cnBlogsProcess);
        jobDataMap.put("pipeline",cnBlogsPipeline);
        JobKey jobKey=jobDetail.getKey();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
        return new R(200,"任务启动成功",jobKey);
    }
    //结束任务
    @GetMapping("blogstop.do")
    public R stop(JobKey jobKey) throws SchedulerException {
        if(scheduler.checkExists(jobKey)){
            scheduler.pauseJob(jobKey);
            scheduler.deleteJob(jobKey);
        }
        return ResultUtil.setOK("爬虫任务取消");
    }
}
