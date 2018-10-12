package com.qfedu.commonadmin.controller;

import com.qfedu.commonadmin.domain.Role;
import com.qfedu.commonadmin.service.RoleService;
import com.qfedu.commonadmin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2018/10/12 14:27
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;
    //新增
    public R save(Role role){
        return roleService.save(role);
    }


}
