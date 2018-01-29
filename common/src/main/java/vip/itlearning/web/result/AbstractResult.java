package vip.itlearning.web.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yaw
 * @date 2018/1/26 13:40
 */
public class AbstractResult implements Serializable {
    @ApiModelProperty(value = "结果状态（成功 或 失败）", position = 0)
    protected AbstractResult.Status status;
    @ApiModelProperty(value = "异常信息", position = 10)
    protected ResultError[] errors;
    @ApiModelProperty(value = "系统处理时间戳（增量拉数据时使用）", position = 11)
    @JsonInclude(Include.NON_NULL)
    protected Date timestamp;

    public AbstractResult() {
    }

    @JsonProperty(value = "status", index = 0)
    public AbstractResult.Status getStatus() {
        return this.status;
    }

    @JsonInclude(Include.NON_NULL)
    @JsonProperty(value = "errors", index = 10)
    public ResultError[] getErrors() {
        return this.errors;
    }

    protected void setErrors(ResultError... errors) {
        this.errors = errors;
    }

    @JsonIgnore
    public boolean isFailure() {
        return AbstractResult.Status.failure == this.status;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return AbstractResult.Status.success == this.status;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @JsonIgnore
    public String errorsToString() {
        if (this.errors != null && this.errors.length > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append("Errors : [");
            ResultError[] var2 = this.errors;
            int var3 = var2.length;
            for (int var4 = 0; var4 < var3; ++var4) {
                ResultError error = var2[var4];
                builder.append(error.toString());
            }
            builder.append("]");
            return builder.toString();
        } else {
            return "errors : []";
        }
    }

    public static enum Status {
        success, failure;

        Status() {
        }
    }
}
