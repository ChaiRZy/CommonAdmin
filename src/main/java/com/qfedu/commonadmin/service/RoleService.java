package com.qfedu.commonadmin.service;


import com.qfedu.commonadmin.domain.Role;
import com.qfedu.commonadmin.vo.R;

/**
 *@Author feri
 *@Date Created in 2018/10/12 14:23
 */
public interface RoleService {

    R save(Role role);
    //更新角色权限
    R updatePermission(int[] pids,int rid);

}
