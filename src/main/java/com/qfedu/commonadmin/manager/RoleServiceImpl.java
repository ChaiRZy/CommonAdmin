package com.qfedu.commonadmin.manager;

import com.qfedu.commonadmin.common.ResultUtil;
import com.qfedu.commonadmin.domain.Role;
import com.qfedu.commonadmin.mapper.RoleMapper;
import com.qfedu.commonadmin.service.RoleService;
import com.qfedu.commonadmin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2018/10/12 14:25
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public R save(Role role) {
        return ResultUtil.setRes(roleMapper.insert(role));
    }

}
