package vip.itlearning.model.system;

import lombok.Data;
import vip.itlearning.model.jpa.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;

/**
 * <p>
 * 操作日志
 * </p>
 *
 * @author yaw
 * @date 2018/1/22 15:54
 */
@Data
@Entity
public class OperationLog extends BaseEntity {

    /**
     * 日志类型
     */
    private String logtype;
    /**
     * 日志名称
     */
    private String logname;
    /**
     * 用户id
     */
    private Integer userid;
    /**
     * 类名称
     */
    private String classname;
    /**
     * 方法名称
     */
    private String method;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 是否成功
     */
    private String succeed;
    /**
     * 备注
     */
    private String message;

    @Override
    public String toString() {
        return "OperationLog{" +
                "id=" + getId() +
                ", logtype=" + logtype +
                ", logname=" + logname +
                ", userid=" + userid +
                ", classname=" + classname +
                ", method=" + method +
                ", createtime=" + createtime +
                ", succeed=" + succeed +
                ", message=" + message +
                "}";
    }
}
