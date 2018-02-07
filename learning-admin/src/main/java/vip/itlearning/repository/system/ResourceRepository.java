package vip.itlearning.repository.system;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.itlearning.model.system.Resource;

/**
 * @description TODO
 * @author: yaw
 * @date: 2018/2/7
 **/
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
