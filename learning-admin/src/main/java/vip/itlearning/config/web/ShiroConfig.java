package vip.itlearning.config.web;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import vip.itlearning.config.shiro.MyShiroRealm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Description Shiro 的 Web 过滤器
 * @Author: yaw
 * @Date: 2018/2/7
 **/
@Configuration
public class ShiroConfig {

	/**
	  * @author: yaw
	  * @Description: 拦截器链
	  * @Date: 14:39 2018/2/7
	  * @Param: [securityManager]
	  * @return: org.apache.shiro.spring.web.ShiroFilterFactoryBean
	 **/
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 默认登录访问链接
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/index");
		// 没有权限的跳转的链接（未授权）
		shiroFilterFactoryBean.setUnauthorizedUrl("/global/error");
		/**
		 * 配置shiro拦截器链（顺序从上到下,优先级依次降低）
		 *
		 * anon  不需要认证（所有url都都可以匿名访问）
		 * authc 需要认证（所有url都必须认证通过才可以访问）
		 * user  验证通过或RememberMe登录的都可以
		 *
		 * 当应用开启了rememberMe时,用户下次访问时可以是一个user,但不会是authc,因为authc是需要重新认证的
		 */
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		// 配置不会被拦截的链接(静态文件、登录、错误、验证码)
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/global/sessionError", "anon");
		filterChainDefinitionMap.put("/kaptcha", "anon");
		//配置退出
		filterChainDefinitionMap.put("/logout", "logout");
		//过滤链定义，一般将/**放在最为下边
		filterChainDefinitionMap.put("/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	@Bean
	public MyShiroRealm myShiroRealm(){
		return new MyShiroRealm();
	}

	/**
	 * 安全管理器
	 */
	@Bean
	public DefaultWebSecurityManager securityManager(CookieRememberMeManager rememberMeManager, CacheManager cacheShiroManager, SessionManager sessionManager) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(this.myShiroRealm());
		securityManager.setCacheManager(cacheShiroManager);
		securityManager.setRememberMeManager(rememberMeManager);
		securityManager.setSessionManager(sessionManager);
		return securityManager;
	}

	/**
	 *  开启shiro aop注解支持.
	 *  使用代理方式;所以需要开启代码支持;
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}



/*	@Bean(name="simpleMappingExceptionResolver")
	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.setProperty("DatabaseException", "databaseError");//数据库异常处理
		mappings.setProperty("UnauthorizedException","403");
		r.setExceptionMappings(mappings);  // None by default
		r.setDefaultErrorView("error");    // No default
		r.setExceptionAttribute("ex");     // Default is "exception"
		//r.setWarnLogCategory("example.MvcLogger");     // No default
		return r;
	}*/
}