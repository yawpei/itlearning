package vip.itlearning.model.system;

import lombok.Data;
import vip.itlearning.model.jpa.BaseEntity;

import javax.persistence.Entity;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author yaw
 * @date 2018/1/22 16:40
 */
@Data
@Entity
public class Dict extends BaseEntity {

    /**
     * 排序
     */
    private Integer num;
    /**
     * 父级字典
     */
    private Integer pid;
    /**
     * 名称
     */
    private String name;
    /**
     * 提示
     */
    private String tips;

    @Override
    public String toString() {
        return "Dict{" +
                "id=" + getId() +
                ", num=" + num +
                ", pid=" + pid +
                ", name=" + name +
                ", tips=" + tips +
                "}";
    }
}
