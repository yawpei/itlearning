package vip.itlearning.model.system;

import lombok.Getter;
import lombok.Setter;
import vip.itlearning.common.enums.Status;
import vip.itlearning.model.jpa.BaseEntity;

import javax.persistence.*;
import java.util.*;

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
     * 用户名
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * 名字
     */
    private String realname;

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
    private Long deptid;

    /**
     * 状态(1：启用  2：冻结  3：删除）
     */
    private Status status = Status.OK;

/*
     签名
    @Column(length = 65535, columnDefinition = "Text")
    private String introduction;*/

    /**
     * 角色
     */
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Role> uroles = new ArrayList<>();

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.salt;
    }
}