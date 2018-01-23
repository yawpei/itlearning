package vip.itlearning.dto;

import io.swagger.annotations.ApiModelProperty;
import vip.itlearning.model.jpa.Auditable;

import java.util.Date;

/**
 * @author yaw
 * @date 2018/1/23 16:36
 */
public class BaseEntityDTO extends IdEntityDTO implements Auditable {
    private static final long serialVersionUID = -7215272705246634319L;
    @ApiModelProperty(
            value = "创建人",
            position = 100
    )
    private String createdBy;
    @ApiModelProperty(
            value = "创建时间",
            position = 101
    )
    private Date createdDate;
    @ApiModelProperty(
            value = "最后修改人",
            position = 102
    )
    private String lastModifiedBy;
    @ApiModelProperty(
            value = "最后修改时间",
            position = 103
    )
    private Date lastModifiedDate;

    public BaseEntityDTO() {
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public final void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public final void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public final void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public final void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
