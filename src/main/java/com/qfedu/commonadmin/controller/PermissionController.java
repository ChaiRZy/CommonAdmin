package com.qfedu.commonadmin.controller;

import com.qfedu.commonadmin.domain.Permission;
import com.qfedu.commonadmin.domain.Role;
import com.qfedu.commonadmin.service.PermissionService;
import com.qfedu.commonadmin.service.RoleService;
import com.qfedu.commonadmin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2018/10/12 14:27
 */
@Service
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    //新增
    public R save(Permission permission){
        return permissionService.save(permission);
    }
}
