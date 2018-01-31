package vip.itlearning.model.jpa;

/**
 * @author yaw
 * @date 2018/1/22 15:24
 */
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 抽象模型类（带审计功能）
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity extends IdEntity implements Auditable {
    private static final long serialVersionUID = -3001027287514807309L;

    /**
     * 创建人
     */
    @CreatedBy
    private String createdBy;

    /**
     * 创建日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    /**
     * 修改人
     */
    @LastModifiedBy
    private String lastModifiedBy;

    /**
     * 修改日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date lastModifiedDate;

    /**
     * 版本
     */
    @Version
    private long version;

    @Override
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public void setLastModifiedBy(final String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(final Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public long getVersion() {
        return this.version;
    }

    public void setVersion(final long version) {
        this.version = version;
    }
}
