package com.qfedu.commonadmin.mapper;

import com.qfedu.commonadmin.domain.Role;
import org.apache.ibatis.annotations.Insert;

public interface RoleMapper {

    @Insert(" insert into t_role (rname, rinfo) values ( #{rname,jdbcType=VARCHAR}, #{rinfo,jdbcType=VARCHAR})")
    int insert(Role record);

}