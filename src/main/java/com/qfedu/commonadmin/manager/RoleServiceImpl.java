package com.qfedu.commonadmin.manager;

import com.qfedu.commonadmin.common.ResultUtil;
import com.qfedu.commonadmin.domain.Role;
import com.qfedu.commonadmin.domain.RolePermission;
import com.qfedu.commonadmin.mapper.RoleMapper;
import com.qfedu.commonadmin.mapper.RolePermissionMapper;
import com.qfedu.commonadmin.service.RoleService;
import com.qfedu.commonadmin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *@Author feri
 *@Date Created in 2018/10/12 14:25
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Override
    public R save(Role role) {
        return ResultUtil.setRes(roleMapper.insert(role));
    }

    @Override
    @Transactional
    public R updatePermission(int[] pids, int rid) {
        rolePermissionMapper.deleteByRid(rid);
        for(int pid:pids){
            RolePermission rolePermission=new RolePermission();
            rolePermission.setPid(pid);
            rolePermission.setRid(rid);
            rolePermissionMapper.insert(rolePermission);
        }
        return ResultUtil.setOK("修改角色权限成功");
    }

}
