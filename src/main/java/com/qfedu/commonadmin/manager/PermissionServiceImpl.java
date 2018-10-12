package com.qfedu.commonadmin.manager;

import com.qfedu.commonadmin.common.ResultUtil;
import com.qfedu.commonadmin.domain.Permission;
import com.qfedu.commonadmin.mapper.PermissionMapper;
import com.qfedu.commonadmin.service.PermissionService;
import com.qfedu.commonadmin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/10/12 14:26
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public R save(Permission permission) {
        return ResultUtil.setRes(permissionMapper.insert(permission));
    }

    @Override
    public List<String> queryByUid(int uid) {
        return permissionMapper.selectByUid(uid);
    }
}
