package vip.itlearning.repository.system;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vip.itlearning.model.system.User;

import java.util.List;

/**
 * @author yaw
 * @date 2018/1/22 17:30
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    Page<User> findAllByUsernameLike(String username, Pageable pageable);

    User findByUsername(String username);

    User findByUsernameIgnoreCase(String username);

    List<User> findByUsernameLike(String username);

    User save(User user);

    Long deleteById(Integer id);

    Long deleteByUsername(String username);
}
