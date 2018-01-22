package vip.itlearning.model.system;

import lombok.Data;
import vip.itlearning.model.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * 用戶
 *
 * @author yaw
 * @date 2018/1/22 14:42
 */
@Data
@Entity
public class User extends BaseEntity {

    /**
     * 账号
     */
    @Column
    private String account;

    /**
     * 密码
     */
    @Column(nullable = false)
    private String password;

    /**
     * md5密码盐
     */
    @Column
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
    @Column
    private Integer sex;

    /**
     * 电子邮件
     */
    @Column
    private String email;

    /**
     * 电话
     */
    @Column
    private String phone;

    /**
     * 部门id
     */
    @Column
    private Integer deptid;

    /**
     * 状态(1：启用  2：冻结  3：删除）
     */
    @Column
    private Integer status;

    /**
     * 签名
     */
    @Column(length = 65535,columnDefinition="Text")
    private String introduction;

    /**
     * 角色
     */
    private String roleid;
}