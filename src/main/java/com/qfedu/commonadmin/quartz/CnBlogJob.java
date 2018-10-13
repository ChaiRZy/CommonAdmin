package com.qfedu.commonadmin.quartz;

import com.qfedu.commonadmin.spider.CnBlogsPipeline;
import com.qfedu.commonadmin.spider.CnBlogsProcess;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

/**
 *@Author feri
 *@Date Created in 2018/10/13 15:16
 * 实现每日晚上10：点 爬虫爬取博客园文章
 */
public class CnBlogJob implements Job {
    //创建日志对象
    private Logger log=LoggerFactory.getLogger(CnBlogJob.class);
    private String url="https://www.cnblogs.com/";
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("爬虫爬取博客园文章开启……"+System.currentTimeMillis());
        JobDataMap jobDataMap=context.getJobDetail().getJobDataMap();
        CnBlogsProcess cnBlogsProcess= (CnBlogsProcess) jobDataMap.get("process");
        CnBlogsPipeline cnBlogsPipeline=(CnBlogsPipeline)jobDataMap.get("pipeline");
        new Spider(cnBlogsProcess).addUrl(url).addPipeline(cnBlogsPipeline).run();

    }
}
