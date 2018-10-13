package com.qfedu.commonadmin.domain;

/**
 *@Author feri
 *@Date Created in 2018/10/13 10:02
 */
public class CnBlogs {
    private int id;
    private String title;
    private String author;
    private String headimg;
    private String summary;
    private String detailurl;
    private String createtime;

    @Override
    public String toString() {
        return "CnBlogs{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", headimg='" + headimg + '\'' +
                ", summary='" + summary + '\'' +
                ", detailurl='" + detailurl + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetailurl() {
        return detailurl;
    }

    public void setDetailurl(String detailurl) {
        this.detailurl = detailurl;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
