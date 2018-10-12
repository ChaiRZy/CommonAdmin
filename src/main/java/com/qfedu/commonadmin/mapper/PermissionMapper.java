package com.qfedu.commonadmin.mapper;

import com.qfedu.commonadmin.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    @Insert("insert into t_permission (name, url,pers, parentid, icon, type,  createdate) values (#{name,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR},#{pers},  #{parentid,jdbcType=INTEGER}, #{icon,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, now())")
    @Options(useGeneratedKeys = true)
    int insert(Permission record);
    @Select("select * from t_permission where id=#{id}")
    Permission selectById(Integer id);

    //查询用户的权限
    @Select("select p.pers from t_permission p left join t_rolepermission rp on p.id=rp.pid left join t_userrole ur on rp.rid=ur.rid where ur.uid=#{uid};")
    @ResultType(String.class)
    List<String> selectByUid(int uid);

}