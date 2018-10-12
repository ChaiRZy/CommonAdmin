package com.qfedu.commonadmin.service;

import com.qfedu.commonadmin.domain.Permission;
import com.qfedu.commonadmin.vo.R;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/10/12 14:25
 */
public interface PermissionService {

    R save(Permission permission);
    List<String> queryByUid(int uid);
}
