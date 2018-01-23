package vip.itlearning.system;

import org.junit.Test;
import vip.itlearning.base.BaseJunit;
import vip.itlearning.model.system.Role;
import vip.itlearning.model.system.User;
import vip.itlearning.repository.system.RoleRepository;
import vip.itlearning.repository.system.UserRepository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户测试
 */
public class UserTest extends BaseJunit {

    @Resource
    UserRepository userRepo;
    @Resource
    RoleRepository roleRepo;

    @Test
    public void userTest() throws Exception {
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("123");
        userRepo.save(user);
    }

    @Test
    public void deleteTest() throws Exception{
        userRepo.deleteAll();
    }

    @Test
    public void userRoleTest() throws Exception {
        User user1 = new User();
        user1.setUsername("11111");
        user1.setPassword("11111");

        User user2 = new User();
        user2.setUsername("22222");
        user2.setPassword("22222");

        Role role1 = new Role();
        role1.setName("1");
        Role role2 = new Role();
        role2.setName("2");
        Role role3 = new Role();
        role3.setName("3");

        role1.getRusers().add(user1);
        role1.getRusers().add(user2);
        role2.getRusers().add(user1);
        role2.getRusers().add(user2);
        role3.getRusers().add(user1);
        role3.getRusers().add(user2);

        user1.getUroles().add(role1);
        user1.getUroles().add(role2);
        user2.getUroles().add(role1);
        user2.getUroles().add(role2);
        user2.getUroles().add(role3);

        roleRepo.save(role1);
        roleRepo.save(role2);
        roleRepo.save(role3);
        userRepo.save(user1);
        userRepo.save(user2);
    }

}
