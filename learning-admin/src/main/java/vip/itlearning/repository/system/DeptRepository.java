package vip.itlearning.repository.system;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.itlearning.model.system.Dept;

/**
 * @description TODO
 * @author: yaw
 * @date: 2018/2/7
 **/
public interface DeptRepository extends JpaRepository<Dept, Long> {
}
