package vip.itlearning.core.shiro.factory;

import org.apache.commons.collections.functors.ConstantFactory;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.itlearning.common.enums.Status;
import vip.itlearning.core.shiro.ShiroUser;
import vip.itlearning.core.utils.ToolUtil;
import vip.itlearning.model.system.Dept;
import vip.itlearning.model.system.Resource;
import vip.itlearning.model.system.Role;
import vip.itlearning.model.system.User;
import vip.itlearning.repository.system.DeptRepository;
import vip.itlearning.repository.system.ResourceRepository;
import vip.itlearning.repository.system.RoleRepository;
import vip.itlearning.repository.system.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroFactroy implements IShiro {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private DeptRepository deptRepo;
    @Autowired
    private RoleRepository roleRepo;


    @Override
    public User user(String username) {

        User user = userRepo.findByUsername(username);

        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
        // 账号被冻结
        if (user.getStatus() != Status.OK) {
            throw new LockedAccountException();
        }
        return user;
    }

    @Override
    public ShiroUser shiroUser(User user) {
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setId(user.getId());            // 账号id
        shiroUser.setUsername(user.getUsername());// 账号
        shiroUser.setDeptId(user.getDeptid());    // 部门id
        Dept dept = deptRepo.findOne(user.getDeptid());
        String deptName = "";
        if (ToolUtil.isNotEmpty(dept) && ToolUtil.isNotEmpty(dept.getFullname())) {
            deptName = dept.getFullname();
        }
        shiroUser.setDeptName(deptName);// 部门名称
        shiroUser.setName(user.getRealname());        // 用户名称

        List<Role> roles = user.getUroles();// 角色集合
        List<Long> roleList = new ArrayList<>();
        List<String> roleNameList = new ArrayList<String>();
        for (Role role : roles) {
            roleList.add(role.getId());
            roleNameList.add(role.getName());
        }
        shiroUser.setRoleList(roleList);
        shiroUser.setRoleNames(roleNameList);
        return shiroUser;
    }

    @Override
    public List<String> findPermissionsByRoleId(Long roleId) {
        Role role = roleRepo.findOne(roleId);
        List<String> permisstion = null;
        if (ToolUtil.isNotEmpty(role) && ToolUtil.isNotEmpty(role.getRresource())) {
            List<Resource> resources = role.getRresource();
            for (Resource resource : resources) {
                permisstion.add(resource.getUrl());
            }
        }
        return permisstion;
    }

    @Override
    public String findRoleNameByRoleId(Long roleId) {
        String rokeName = "";
        Role role = roleRepo.findOne(roleId);
        if (ToolUtil.isNotEmpty(role) && ToolUtil.isNotEmpty(role.getName())) {
            rokeName =role.getName();
        }
        return rokeName;
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
        String credentials = user.getPassword();
        // 密码加盐处理
        String source = user.getCredentialsSalt();
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }

}
