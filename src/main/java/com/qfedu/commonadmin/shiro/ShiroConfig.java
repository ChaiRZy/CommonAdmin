package com.qfedu.commonadmin.shiro;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2018/10/12 16:30
 */
@Configuration
public class ShiroConfig {


    @Bean
    public DefaultSecurityManager createManager(UserRealm userRealm){
        DefaultSecurityManager manager=new DefaultSecurityManager(userRealm);
        return manager;
    }
    @Bean
    public ShiroFilterFactoryBean createFb(DefaultSecurityManager manager){
        ShiroFilterFactoryBean filterFactoryBean=new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(manager);
        filterFactoryBean.setLoginUrl("login.html");
        filterFactoryBean.setSuccessUrl("index.html");
        filterFactoryBean.setUnauthorizedUrl("error.html");
        Map<String,String> map=new HashMap<>();
        map.put("login.html","anon");
        map.put("userlogin.do","anon");
        map.put("media/**","anon");
        map.put("/**","authc");
        filterFactoryBean.setFilterChainDefinitionMap(map);
        return filterFactoryBean;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor createAdvisor(DefaultSecurityManager manager){
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

}
