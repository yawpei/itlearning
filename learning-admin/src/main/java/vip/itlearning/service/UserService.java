package vip.itlearning.service;

import vip.itlearning.model.system.User;

/**
 * @author yaw
 * @date 2018/1/22 17:43
 */
public interface UserService {
    public User findByUsername(String username);
}
