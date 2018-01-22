package vip.itlearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.itlearning.model.system.User;

import java.util.List;

/**
 * @author yaw
 * @date 2018/1/22 17:30
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    User findByUsername(String username);

    User findByUserNameIgnoreCase(String username);

    List<User> findByUsernameLike(String username);

    User save(User user);

    Long deleteById(Integer id);

    Long deleteByUsername(String username);
}
