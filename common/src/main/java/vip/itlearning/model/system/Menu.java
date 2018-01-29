package vip.itlearning.model.system;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import vip.itlearning.model.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 菜单
 *
 * @author yaw
 * @date 2018/1/22 16:40
 */
@Setter
@Getter
@Entity
public class Menu extends BaseEntity {
    /**
     * 菜单编号
     */
    private String code;
    /**
     * 菜单父编号
     */
    private String pcode;
    /**
     * 当前菜单的所有父菜单编号
     */
    private String pcodes;
    /**
     * 菜单名称
     */
    @NotBlank
    private String name;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 资源路径
     */
    @NotBlank
    private String url;
    /**
     * 菜单排序号
     */
    private Integer num;
    /**
     * 菜单层级
     */
    private Integer levels;
    /**
     * 是否是菜单（1：是  0：不是）
     */
    private Integer ismenu;
    /**
     * 备注
     */
    private String tips;
    /**
     * 菜单状态 :  1:启用   0:不启用
     */
    private Integer status;

    /**
     * 资源类型，[menu|button]
     */
    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;

    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;
    /**
     * 是否打开:    1:打开   0:不打开
     */
    private Integer isopen;

    /**
     * 菜单角色关联
     */
    @ManyToMany(mappedBy = "rmenus")
    private List<Role> mroles = new ArrayList<Role>();

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + getId() +
                ", code=" + code +
                ", pcode=" + pcode +
                ", pcodes=" + pcodes +
                ", name=" + name +
                ", icon=" + icon +
                ", url=" + url +
                ", num=" + num +
                ", levels=" + levels +
                ", ismenu=" + ismenu +
                ", tips=" + tips +
                ", status=" + status +
                ", isopen=" + isopen +
                "}";
    }
}
