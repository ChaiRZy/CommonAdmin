package com.qfedu.commonadmin.mapper;

import com.qfedu.commonadmin.domain.CnBlogs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/10/13 10:03
 */
public interface CnBlogsMapper {
    @Insert("insert into t_cnblogs(title,author,headimg,summary,detailurl,createtime) values(#{title},#{author},#{headimg},#{summary},#{detailurl},#{createtime})")
    int insert(CnBlogs cnBlogs);

    @Select("select * from t_cnblogs")
    @ResultType(CnBlogs.class)
    List<CnBlogs> selectAll();
}
