package com.qfedu.commonadmin.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import javax.validation.constraints.Size;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/10/13 09:10
 */
public class HelloProcess implements PageProcessor {
    private Site site=Site.me().setTimeOut(3000).setRetryTimes(3);
    //处理过程 核心  怎么处理网页内容
    @Override
    public void process(Page page) {
        //class=post_item  class=post_itembody  h3 a---内部文本
        System.err.println(page.getHtml().get());
        List<String> list=page.getHtml().xpath("div[@class='post_item_body']/h3/a/text()").all();
        for(String s:list){
            System.err.println("文章标题："+s);
        }
    }
    //站点信息 网站请求信息
    @Override
    public Site getSite() {
        return site;
    }
}
