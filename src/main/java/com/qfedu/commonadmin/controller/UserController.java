package com.qfedu.commonadmin.controller;

import com.qfedu.commonadmin.common.ResultUtil;
import com.qfedu.commonadmin.domain.LoginLog;
import com.qfedu.commonadmin.domain.User;
import com.qfedu.commonadmin.service.UserService;
import com.qfedu.commonadmin.vo.MenuVo;
import com.qfedu.commonadmin.vo.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/10/12 14:14
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //登录
    @PostMapping("/userlogin.do")
    public R login(String rm,String name, String password, HttpServletRequest request){
        User user=userService.login(name,password);
        if(user!=null){
            //登录成功
            //记录登录日志
            LoginLog loginLog=new LoginLog();
            loginLog.setIp(request.getRemoteAddr());
            loginLog.setUid(user.getId());
            userService.saveLog(loginLog);
            //通知Shiro登录成功
            Subject subject=SecurityUtils.getSubject();
            UsernamePasswordToken token=new UsernamePasswordToken(name,password);
//            if(rm!=null && rm.length()>0) {
//                token.setRememberMe(true);
//            }
            subject.getSession().setAttribute("user",user);
            subject.login(token);
            return ResultUtil.setOK("登录成功");
        }else {
            return ResultUtil.setERROR("用户名或密码错误");
        }
    }
    //注册
    @PostMapping("userregister.do")
    public R save(User user){
        return userService.save(user);
    }

    //查询左菜单
    @GetMapping("usermenus.do")
    public List<MenuVo> menus(){
        User user= (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return userService.queryMenu(user.getId());
    }


}
