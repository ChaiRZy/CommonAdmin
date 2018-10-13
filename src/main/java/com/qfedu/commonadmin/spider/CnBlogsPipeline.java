package com.qfedu.commonadmin.spider;


import com.qfedu.commonadmin.domain.CnBlogs;
import com.qfedu.commonadmin.service.CnBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/10/13 10:08
 * 基于WebMagic存储爬取结果到数据库中
 */
@Service
public class CnBlogsPipeline implements Pipeline {

    @Autowired
    private CnBlogsService cnBlogsService;
    @Override
    public void process(ResultItems resultItems, Task task) {
        List<CnBlogs> list= resultItems.get("data");
        for(CnBlogs cb:list){
            cnBlogsService.save(cb);
        }
        System.err.println("此次新增："+list.size());
    }
}
