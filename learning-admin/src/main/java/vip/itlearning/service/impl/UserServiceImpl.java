package vip.itlearning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.itlearning.model.system.User;
import vip.itlearning.repository.system.UserRepository;
import vip.itlearning.service.UserService;

import java.util.List;

/**
 * @author yaw
 * @date 2018/1/22 17:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public void changePassword(Long userId, String newPassword) {

    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<String> findPermissions(String username) {
        return null;
    }
}
