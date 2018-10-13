package com.qfedu.commonadmin.manager;

import com.qfedu.commonadmin.common.PassUtil;
import com.qfedu.commonadmin.common.ResultUtil;
import com.qfedu.commonadmin.domain.LoginLog;
import com.qfedu.commonadmin.domain.Permission;
import com.qfedu.commonadmin.domain.User;
import com.qfedu.commonadmin.domain.UserRole;
import com.qfedu.commonadmin.mapper.LoginLogMapper;
import com.qfedu.commonadmin.mapper.PermissionMapper;
import com.qfedu.commonadmin.mapper.UserMapper;
import com.qfedu.commonadmin.mapper.UserRoleMapper;
import com.qfedu.commonadmin.service.UserService;
import com.qfedu.commonadmin.vo.MenuVo;
import com.qfedu.commonadmin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *@Author feri
 *@Date Created in 2018/10/12 11:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LoginLogMapper loginLogMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public R save(User user) {
        user.setPassword(PassUtil.md5(user.getPassword()));
        return ResultUtil.setRes(userMapper.insert(user));
    }

    @Override
    public R checkName(String name) {
        User user=userMapper.selectByName(name);
        if(user==null){
            //可用
            return ResultUtil.setOK("用户名可用");
        }else{
            return ResultUtil.setERROR("用户名不可用");
        }
    }

    @Override
    public User login(String name, String password) {
        User user=userMapper.selectByName(name);
        if(user!=null){
            System.out.println(user.getPassword()+"--->"+PassUtil.md5(password));
            //校验密码
            if(Objects.equals(user.getPassword(),PassUtil.md5(password))){
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveLog(LoginLog loginLog) {
        loginLogMapper.insert(loginLog);
    }

    @Override
    @Transactional
    public R updateRole(int[] rids, int uid) {
        userRoleMapper.deleteByUid(uid);
        for(int rid:rids){
            UserRole userRole=new UserRole();
            userRole.setRid(rid);
            userRole.setUid(uid);
            userRoleMapper.insert(userRole);
        }
        return ResultUtil.setOK("修改用户角色成功");
    }

    @Override
    public List<MenuVo> queryMenu(int uid) {
        List<Permission> total=permissionMapper.selectByMenuUid(uid);
        System.out.println(total);
        List<MenuVo> menuVos=new ArrayList<>();
        for(Permission p:total){
            if(p.getParentid()==-1){
                MenuVo menuVo=new MenuVo();
                menuVo.setParent(p);
                menuVo.setChildrens(new ArrayList<>());
                menuVos.add(menuVo);
            }else{
                //二级菜单
                int index=indexParent(menuVos,p);
                if(index>-1){
                    //找到上级菜单  将当前资源对象添加到对应的孩子中
                    menuVos.get(index).getChildrens().add(p);
                }
            }
        }
        return menuVos;
    }
    private int indexParent(List<MenuVo> menuVos,Permission permission){
        for(int i=0;i<menuVos.size();i++){
            if(menuVos.get(i).getParent().getId().intValue()==permission.getParentid().intValue()){
                return i;
            }
        }
        return -1;
    }

}
