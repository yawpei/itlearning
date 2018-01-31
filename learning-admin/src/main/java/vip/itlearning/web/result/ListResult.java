package vip.itlearning.web.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import vip.itlearning.exception.CustomRuntimeException;

import java.util.List;

/**
 * @author yaw
 * @date 2018/1/26 14:06
 */
public class ListResult<T> extends AbstractResult {
    @ApiModelProperty(value = "业务数据(List)", position = 1)
    private List<T> data;

    @JsonProperty(value = "data", index = 1)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public ListResult() {
    }

    ListResult(Status status) {
        this.status = status;
    }

    public static <T> ListResult<T> success(List<T> listData) {
        if (listData == null) {
            throw new CustomRuntimeException("NullPointerException", "The formal parameter 'listData' cannot be null");
        } else {
            ListResult listResult = new ListResult(Status.success);
            listResult.setData(listData);
            return listResult;
        }
    }

    public static <T> ListResult<T> failure(List<T> listData, ResultError... errors) {
        ListResult listResult = new ListResult(Status.failure);
        listResult.setData(listData);
        listResult.setErrors(errors);
        return listResult;
    }
}
