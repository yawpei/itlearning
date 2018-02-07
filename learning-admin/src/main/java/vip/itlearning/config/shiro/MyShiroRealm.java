package vip.itlearning.config.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import vip.itlearning.core.shiro.ShiroKit;
import vip.itlearning.core.shiro.ShiroUser;
import vip.itlearning.core.shiro.factory.ShiroFactroy;
import vip.itlearning.core.utils.ToolUtil;
import vip.itlearning.model.system.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
  * @author: yaw
  * @description: Realm
  * @date: 17:14 2018/2/7
 **/
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private ShiroFactroy shiroFactory;

    /**
     * @author: yaw
     * @description: 身份认证，也就是说验证用户输入的账号和密码是否正确
     * @date: 15:26 2018/2/7
     * @param: [token]
     * @return: org.apache.shiro.authc.AuthenticationInfo
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        User userInfo = shiroFactory.user(upToken.getUsername());
        ShiroUser shiroUser = shiroFactory.shiroUser(userInfo);
        return shiroFactory.info(shiroUser, userInfo, this.getName());
    }

    /**
     * @author: yaw
     * @description: 权限配置
     * @date: 15:26 2018/2/7
     * @param: [principals]
     * @return: org.apache.shiro.authz.AuthorizationInfo
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        List<Long> roles = shiroUser.getRoleList();
        // 角色标识集合、资源访问路径集合
        Set<String> roleNameset = new HashSet<>();
        Set<String> permissionset = new HashSet<>();
        for (Long roleId : roles) {
            List<String> permissions = shiroFactory.findPermissionsByRoleId(roleId);
            if (permissions != null) {
                for (String permission : permissions) {
                    if (ToolUtil.isNotEmpty(permission)) {
                        permissions.add(permission);
                    }
                }
            }
            String roleName = shiroFactory.findRoleNameByRoleId(roleId);
            roleNameset.add(roleName);
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleNameset);
        authorizationInfo.setStringPermissions(permissionset);
        return authorizationInfo;
    }
    /**
     * 设置认证加密方式
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(ShiroKit.hashAlgorithmName);//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(ShiroKit.hashIterations);//散列的次数，比如散列两次，相当于 md5(md5(""));
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }

}