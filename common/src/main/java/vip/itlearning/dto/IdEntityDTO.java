package vip.itlearning.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author yaw
 * @date 2018/1/23 16:33
 */
public abstract class IdEntityDTO implements Serializable {
    private static final long serialVersionUID = -3566137051451971961L;
    @ApiModelProperty(
            value = "主键ID",
            position = 0
    )
    private Long id;

    public IdEntityDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public boolean isNew() {
        return this.id == null;
    }
}
