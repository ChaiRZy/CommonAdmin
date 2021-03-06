package com.qfedu.commonadmin.service;

import com.qfedu.commonadmin.domain.LoginLog;
import com.qfedu.commonadmin.domain.User;
import com.qfedu.commonadmin.vo.MenuVo;
import com.qfedu.commonadmin.vo.R;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/10/12 11:34
 */
public interface UserService {

    //注册
    R save(User user);
    //校验是否存在
    R checkName(String name);
    //登录---账号是否存在临时无效
    User login(String name,String password);

    void saveLog(LoginLog loginLog);
    //更新角色
    R updateRole(int[] rids,int uid);


    List<MenuVo> queryMenu(int uid);


}
