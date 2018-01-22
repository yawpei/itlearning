package vip.itlearning.system;

import org.junit.Test;
import vip.itlearning.base.BaseJunit;
import vip.itlearning.model.system.Role;
import vip.itlearning.model.system.User;
import vip.itlearning.repository.UserRepository;

import javax.annotation.Resource;

/**
 * 用户测试
 *
 */
public class UserTest extends BaseJunit {

    @Resource
    UserRepository userRepo;

    @Test
    public void userTest() throws Exception {
        Role role = new Role();
    }

}
