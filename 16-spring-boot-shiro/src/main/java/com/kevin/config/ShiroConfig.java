package com.kevin.config;

import com.kevin.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author caonanqing
 * @version 1.0
 * @description     Shiro配置类
 * @createDate 2019/5/14
 */
@Configuration
public class ShiroConfig {

    /**
     * 加密方式配置
     * @return
     */
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        System.out.println("==========ShiroConfig.hashedCredentialsMatcher()==========");

        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        //是否存储为16进制
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

    /**
     * 认证器配置，身份认证realm
     * @param matcher
     * @return
     */
    //@Bean("userRealm")
    @Bean
    public UserRealm userRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher) {

        System.out.println("==========ShiroConfig.userRealm()==========");

        UserRealm userRealm = new UserRealm();
        userRealm.setCachingEnabled(true);
        //启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
        //userRealm.setAuthenticationCachingEnabled(true);
        //缓存AuthenticationInfo信息的缓存名称 在ehcache-shiro.xml中有对应缓存的配置
        //userRealm.setAuthenticationCacheName("authenticationCache");
        //启用授权缓存，即缓存AuthorizationInfo信息，默认false
        //userRealm.setAuthorizationCachingEnabled(true);
        //缓存AuthorizationInfo信息的缓存名称  在ehcache-shiro.xml中有对应缓存的配置
        //userRealm.setAuthorizationCacheName("authorizationCache");
        //配置自定义密码比较器
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    /**
     * Fliter工厂，设置对应的过滤条件和跳转条件
     *      * ShiroFilterFactoryBean 处理拦截资源文件问题。
     *      * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *      Filter Chain定义说明
     *      1、一个URL可以配置多个Filter，使用逗号分隔
     *      2、当设置多个过滤器时，全部验证通过，才视为通过
     *      3、部分过滤器可指定参数，如perms，roles
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {

        System.out.println("==========ShiroConfig.shirFilter()==========");

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置 SecurityManager
        bean.setSecurityManager(securityManager);
        // 设置登录成功跳转Url
        bean.setSuccessUrl("/main");
        // 设置登录跳转Url
        bean.setLoginUrl("/toLogin");
        // 设置未授权提示Url
        bean.setUnauthorizedUrl("/error/unAuth");

        /**
         * 过滤链定义，从上向下顺序执行，一般将/**放在最为下边
         * anon：匿名用户可访问
         * authc：认证用户可访问
         * user：记住我和认证用户可访问
         * perms：对应权限可访问
         * roles：对应角色权限可访问
         **/
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login","anon");
        filterMap.put("/vip/**","roles[vip]");  // 表示该链接需要有vip这个角色才可以访问
        filterMap.put("/druid/**", "anon");
        filterMap.put("/static/**","anon");

        // 记住我或者认证通过可以访问的地址
        filterMap.put("/user/index","user");
        filterMap.put("/","user");
        // 退出过滤器
        filterMap.put("/logout", "logout");
        // 所有url都必须通过认证才可以访问
        filterMap.put("/**","authc");

        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    /**
     * 安全管理器配置，注入 securityManager，权限管理，配置主要是Realm的管理认证
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(HashedCredentialsMatcher hashedCredentialsMatcher) {

        System.out.println("==========ShiroConfig.getDefaultWebSecurityManager()==========");

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm.
        securityManager.setRealm(userRealm(hashedCredentialsMatcher));
        //注入缓存管理器;
        securityManager.setCacheManager(ehCacheManager());//这个如果执行多次，也是同样的一个对象;
        //注入记住我管理器;
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     *  开启@RequirePermission注解的配置，要结合DefaultAdvisorAutoProxyCreator一起使用，或者导入aop的依赖
     * @param securityManager
     * @return
     */
    /*@Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            @Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }*/

    /**
     * shiro缓存管理器;
     * 需要注入对应的其它的实体类中：
     * 1、安全管理器：securityManager
     * 可见securityManager是整个shiro的核心；
     * @return
     */
    @Bean
    public EhCacheManager ehCacheManager(){
        System.out.println("==========ShiroConfig.ehCacheManager()==========");

        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return cacheManager;
    }

    /**
     * cookie对象;
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie(){
        System.out.println("==========ShiroConfig.rememberMeCookie()==========");

        // 这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        // 记住我cookie生效时间10分钟 ,单位秒
        simpleCookie.setMaxAge(60*10);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        System.out.println("==========ShiroConfig.rememberMeManager()==========");

        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

}