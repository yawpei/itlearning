package vip.itlearning.model.system;

import lombok.Data;
import vip.itlearning.model.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author yaw
 * @date 2018/1/22 15:54
 */
@Data
@Entity
public class Role extends BaseEntity {

    /**
     * 父角色id
     */
    private Integer pid;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 别名
     */
    private String tips;
    /**
     * 部门名称
     */
    private Integer deptid;
}
