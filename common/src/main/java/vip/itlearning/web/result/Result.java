package vip.itlearning.web.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yaw
 * @date 2018/1/26 14:01
 */
public class Result<T> extends AbstractResult {
    @ApiModelProperty(value = "业务数据", position = 1)
    private T data;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty(value = "data",index = 2)
    public T getData() {
        return this.data;
    }

    private void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    Result(Status status) {
        this.status = status;
    }

    public static Result<Void> success() {
        Result<Void> result = new Result(Status.success);
        return result;
    }

    public static Result<Void> failure(ResultError... errors) {
        Result<Void> result = new Result(Status.failure);
        result.setErrors(errors);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result(Status.success);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> failure(T data, ResultError... errors) {
        Result<T> result = new Result(Status.failure);
        result.setData(data);
        result.setErrors(errors);
        return result;
    }
}
