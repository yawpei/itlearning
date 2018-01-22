package vip.itlearning.model.system;

import lombok.Data;
import vip.itlearning.model.jpa.BaseEntity;

import javax.persistence.Entity;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author yaw
 * @date 2018/1/22 16:40
 */

@Data
@Entity
public class Dept extends BaseEntity {

    /**
     * 排序
     */
    private Integer num;
    /**
     * 父部门id
     */
    private Integer pid;
    /**
     * 父级ids
     */
    private String pids;
    /**
     * 简称
     */
    private String simplename;
    /**
     * 全称
     */
    private String fullname;
    /**
     * 提示
     */
    private String tips;

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + getId() +
                ", num=" + num +
                ", pid=" + pid +
                ", pids=" + pids +
                ", simplename=" + simplename +
                ", fullname=" + fullname +
                ", tips=" + tips +
                ", version=" + getVersion() +
                "}";
    }
}
