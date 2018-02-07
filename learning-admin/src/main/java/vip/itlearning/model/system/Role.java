package vip.itlearning.model.system;

import lombok.Getter;
import lombok.Setter;
import vip.itlearning.model.jpa.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
     * 别名（标识符）
     */
    private String tips;
    /**
     * 部门Id
     */
    private Integer deptid;

    /**
     * 是否可用
     */
    private boolean available;

    @ManyToMany(mappedBy ="uroles")
    private List<User> rusers = new ArrayList<>();

    @JoinTable(name = "role_resource", joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "resource_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Resource> rresource = new ArrayList<Resource>();
}
