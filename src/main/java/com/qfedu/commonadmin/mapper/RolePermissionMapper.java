package com.qfedu.commonadmin.mapper;

import com.qfedu.commonadmin.domain.RolePermission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

public interface RolePermissionMapper {

    @Delete("delete from t_rolepermission where rid=#{rid}")
    int deleteByRid(Integer rid);
    @Insert("insert into t_rolepermission (rid, pid) values (#{rid,jdbcType=INTEGER}, #{pid,jdbcType=INTEGER})")
    int insert(RolePermission record);

}