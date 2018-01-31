package vip.itlearning.model.system;

import lombok.Getter;
import lombok.Setter;
import vip.itlearning.model.jpa.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色
 *
 * @author yaw
 * @date 2018/1/22 15:54
 */
@Setter
@Getter
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

    @ManyToMany(mappedBy ="uroles")
    private Set<User> rusers = new HashSet<User>();

    @JoinTable(name = "role_menu", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<Menu> rmenus = new HashSet<Menu>();
}
