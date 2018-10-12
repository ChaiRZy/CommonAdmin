package com.qfedu.commonadmin.manager;

import com.qfedu.commonadmin.common.PassUtil;
import com.qfedu.commonadmin.common.ResultUtil;
import com.qfedu.commonadmin.domain.LoginLog;
import com.qfedu.commonadmin.domain.User;
import com.qfedu.commonadmin.mapper.LoginLogMapper;
import com.qfedu.commonadmin.mapper.UserMapper;
import com.qfedu.commonadmin.service.UserService;
import com.qfedu.commonadmin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
