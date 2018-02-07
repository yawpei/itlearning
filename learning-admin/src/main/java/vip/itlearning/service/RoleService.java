package vip.itlearning.service;

import java.util.List;

public interface RoleService {
    List<String> findRoles(Long... roleIds); //根据角色编号得到角色标识符列表
    List<String> findPermissions(Long[] roleIds); //根据角色编号得到权限字符串列表
}
