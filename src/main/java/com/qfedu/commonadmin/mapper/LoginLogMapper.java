package com.qfedu.commonadmin.mapper;

import com.qfedu.commonadmin.domain.LoginLog;
import org.apache.ibatis.annotations.Insert;

public interface LoginLogMapper {
    @Insert(" insert into t_loginlog (uid, createtime, ip) values ( #{uid,jdbcType=INTEGER},now(), #{ip,jdbcType=VARCHAR})")
    int insert(LoginLog record);

}