package com.project1.shrio;

import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShrioConfig {
    /*
    * 创建shriofilterfactorybean
    * */
    @Bean(name = "sessionDAO")
    public MemorySessionDAO getMemorySessionDAO() {
        return new MemorySessionDAO();
    }

    @Bean(name = "sessionIdCookie")
    public SimpleCookie getSimpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("SHRIOSESSIONID");
        return simpleCookie;
    }

    //配置shiro session 的一个管理器
    @Bean(name = "sessionManager")
    public DefaultWebSessionManager getDefaultWebSessionManager() {
        DefaultWebSessionManager sessionManager = new MySessionManager();
        sessionManager.setSessionDAO(getMemorySessionDAO());
        sessionManager.setSessionIdCookie(getSimpleCookie());
        return sessionManager;
    }
    //配置session的缓存管理器
    @Bean(name = "shiroCacheManager")
    public MemoryConstrainedCacheManager getMemoryConstrainedCacheManager() {
        return new MemoryConstrainedCacheManager();
    }


    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 添加Shiro内置过滤器
        /*
         *   常用的过滤器：
         *       anon:   无需认证（登录）可以直接访问
         *       authc:  必须认证才可以访问
         *       user:   使用了rememberMe的功能才可以访问
         *       perms:  必须得到资源权限才可以访问
         *       role:   必须得到角色权限才可以访问
         *
         * */
        Map<String ,String> filterMap = new LinkedHashMap<String ,String >();

        filterMap.put("/user/add","authc");
        filterMap.put("/user/update","authc");
        filterMap.put("/user/add","perms[add]");
        filterMap.put("/user/find","perms[select]");
        //filterMap.put("/*","authc");


        //
        shiroFilterFactoryBean.setLoginUrl("/user/tologin");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/noAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /*
    * 创建defaultwebsecuritymanager
    * */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    /*
    * 创建realm
    * */
    @Bean(name = "userRealm")
    public UserRealm getrealm(){
        return new UserRealm();
    }

    /**
     *  开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启aop注解支持
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager((SecurityManager) securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
