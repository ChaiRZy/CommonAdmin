package com.qfedu.commonadmin.spider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/10/13 09:37
 */
public class BkyProcess implements PageProcessor {

    private Site site=Site.me().setTimeOut(3000).setRetryTimes(3);
    //处理过程 核心  怎么处理网页内容
    @Override
    public void process(Page page) {
        //class=post_item  class=post_itembody  h3 a---内部文本
        List<String> list=page.getHtml().xpath("div[@class='post_item_body']/h3/a/text()").all();
        for(String s:list){
            System.err.println("文章标题："+s);
        }
        if(page.getUrl().get().equals("https://www.cnblogs.com/")) {
            List<String> links = page.getHtml().xpath("div[@class='pager']/a/@href").all();
            List<String> pages = page.getHtml().xpath("div[@class='pager']/a/text()").all();
            int last=Integer.parseInt(pages.get(pages.size()-2));
            String path=links.get(1);
            path=path.substring(1,path.lastIndexOf("/")+1);
            //System.err.println(path);
            //继续爬取的网址
            List<String> urls=new ArrayList<>();
            for(int i=2;i<=last;i++){
                urls.add(page.getUrl().get()+path+i);
            }
            //System.err.println(urls);
            page.addTargetRequests(urls);
        }


    }
    //站点信息 网站请求信息
    @Override
    public Site getSite() {
        return site;
    }

}
