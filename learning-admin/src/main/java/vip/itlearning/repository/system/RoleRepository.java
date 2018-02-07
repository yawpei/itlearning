package vip.itlearning.repository.system;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.itlearning.model.system.Role;

import java.util.List;

/**
 * @author yaw
 * @date 2018/1/23 10:56
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
