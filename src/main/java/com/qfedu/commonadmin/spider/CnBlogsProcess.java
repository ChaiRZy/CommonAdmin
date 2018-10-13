package com.qfedu.commonadmin.spider;

import com.qfedu.commonadmin.domain.CnBlogs;
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
@Service
public class CnBlogsProcess implements PageProcessor {
    private Site site=Site.me().setTimeOut(3000).setRetryTimes(3);
    //处理过程 核心  怎么处理网页内容
    @Override
    public void process(Page page) {
        //class=post_item  class=post_itembody  h3 a---内部文本
        //标题
        List<String> titles=page.getHtml().xpath("div[@class='post_item_body']/h3/a/text()").all();
        //详情路径
        List<String> detailUrls=page.getHtml().xpath("div[@class='post_item_body']/h3/a/@href").all();
        //作者
        List<String> authors=page.getHtml().xpath("div[@class='post_item_foot']/a/text()").all();
        //摘要
        List<String> summarys=page.getHtml().xpath("div[@class='post_item_body']/p[@class='post_item_summary']/text()").all();
        //头像
        List<String> headimgs=page.getHtml().xpath("div[@class='post_item_body']/p[@class='post_item_summary']/a/img/@src").all();
        //更新时间
        List<String> times=page.getHtml().xpath("div[@class='post_item_foot']/text()").all();
        System.out.println(titles.size());
        System.out.println(headimgs.size());
        System.out.println(summarys.size());
        System.out.println(authors.size());
        System.out.println(times.size());
        System.out.println(detailUrls.size());
        List<CnBlogs> list=new ArrayList<>();
        for(int i=0;i<titles.size();i++){
            CnBlogs cnBlogs=new CnBlogs();
            cnBlogs.setTitle(titles.get(i));
            cnBlogs.setAuthor(authors.get(i));
            String time=times.get(i).trim();
            cnBlogs.setCreatetime(time.substring(time.indexOf(' ')+1));
           // cnBlogs.setHeadimg(headimgs.get(i));
            cnBlogs.setDetailurl(detailUrls.get(i));
            cnBlogs.setSummary(summarys.get(i));
            list.add(cnBlogs);
        }
        //将处理结果传输到知道的额处理器中
        page.putField("data",list);

        if(page.getUrl().get().equals("https://www.cnblogs.com/")) {
            List<String> links = page.getHtml().xpath("div[@class='pager']/a/@href").all();
            List<String> pages = page.getHtml().xpath("div[@class='pager']/a/text()").all();
            int last=Integer.parseInt(pages.get(pages.size()-2));
            String path=links.get(1);
            path=path.substring(1,path.lastIndexOf("/")+1);
            //继续爬取的网址
            List<String> urls=new ArrayList<>();
            for(int i=2;i<=last;i++){
                urls.add(page.getUrl().get()+path+i);
            }
            //继续抓取指定的网页
            page.addTargetRequests(urls);
        }
    }
    //站点信息 网站请求信息
    @Override
    public Site getSite() {
        return site;
    }

}
