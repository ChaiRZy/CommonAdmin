package com.qfedu.commonadmin.mapper;

import com.qfedu.commonadmin.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

public interface UserMapper {

    @Insert(" insert into t_user (no, username, password, createdate, flag) values ( #{no,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, now(), 1)")
    int insert(User record);
    @Select("select * from t_user where no=#{name} or username =#{name}")
    @ResultType(User.class)
    User selectByName(String name);
    @Update("update t_user set password=#{newpass} where id=#{uid} and password=#{oldpass}")
    int updatePass(@Param("uid") int uid, @Param("oldpass") String oldpass, @Param("newpass") String newPass);




}