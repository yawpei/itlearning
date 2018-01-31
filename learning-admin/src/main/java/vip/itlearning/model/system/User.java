package vip.itlearning.model.system;

import lombok.Getter;
import lombok.Setter;
import vip.itlearning.model.jpa.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用戶
 *
 * @author yaw
 * @date 2018/1/22 14:42
 */
@Setter
@Getter
@Entity
public class User extends BaseEntity {

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    @Column(nullable = false)
    private String password;

    /**
     * md5密码盐
     */
    private String salt;

    /**
     * 用户名
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * 生日
     */
    @Column
    private Date birthday;

    /**
     * 性别（1：男 2：女）
     */
    private Integer sex;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 部门id
     */
    private Integer deptid;

    /**
     * 状态(1：启用  2：冻结  3：删除）
     */
    private Integer status;

    /**
     * 签名
     */
    @Column(length = 65535, columnDefinition = "Text")
    private String introduction;

    /**
     * 角色
     */
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<Role> uroles = new HashSet<Role>();

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
}