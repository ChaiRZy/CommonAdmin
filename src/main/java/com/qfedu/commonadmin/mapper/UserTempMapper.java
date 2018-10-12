package com.qfedu.commonadmin.mapper;

import com.qfedu.commonadmin.domain.UserTemp;
import org.apache.ibatis.annotations.Insert;

public interface UserTempMapper {

    @Insert("insert into t_usertemp (uid, starttime, days) values ( #{uid,jdbcType=INTEGER}, #{starttime,jdbcType=TIMESTAMP},  #{days,jdbcType=INTEGER})")
    int insert(UserTemp record);



}