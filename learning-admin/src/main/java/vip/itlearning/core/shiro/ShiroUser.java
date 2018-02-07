package vip.itlearning.core.shiro;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author: yaw
 * @description: 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * @date: 15:39 2018/2/7
 **/
@Setter
@Getter
public class ShiroUser implements Serializable {
    public Long id;          // 主键ID
    public String username;      // 用户名
    public String name;         // 姓名
    public Long deptId;      // 部门id
    public List<Long> roleList; // 角色集
    public String deptName;        // 部门名称
    public List<String> roleNames; // 角色名称集
}
