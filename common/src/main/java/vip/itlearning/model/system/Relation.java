package vip.itlearning.model.system;

import lombok.Data;
import vip.itlearning.model.jpa.BaseEntity;

import javax.persistence.Entity;

/**
 * <p>
 * 角色和菜单关联表
 *
 * @author yaw
 * @date 2018/1/22 15:54
 */
@Data
@Entity
public class Relation extends BaseEntity {

    /**
     * 菜单id
     */
    private Long menuid;
    /**
     * 角色id
     */
    private Integer roleid;


    @Override
    public String toString() {
        return "Relation{" +
                "id=" + getId() +
                ", menuid=" + menuid +
                ", roleid=" + roleid +
                "}";
    }
}
