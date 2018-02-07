package vip.itlearning.service;

import vip.itlearning.model.system.User;

import java.util.List;

/**
 * @author yaw
 * @date 2018/1/22 17:43
 */
public interface UserService {
    public void changePassword(Long userId, String newPassword); //修改密码
    public User findByUsername(String username); //根据用户名查找用户
    public List<String> findPermissions(String username);// 根据用户名查找其权限
}
