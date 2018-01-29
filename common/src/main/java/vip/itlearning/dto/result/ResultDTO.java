//package vip.itlearning.dto.result;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModelProperty;
//
///**
// * @author yaw
// * @date 2018/1/23 16:22
// */
//public class ResultDTO<T> extends AbstractResultDTO {
//    private static final long serialVersionUID = 1668914867578552488L;
//    @ApiModelProperty(
//            value = "业务数据",
//            position = 1
//    )
//    private T data;
//
//    @JsonInclude(Include.NON_NULL)
//    @JsonProperty(
//            value = "data",
//            index = 2
//    )
//    public T getData() {
//        return this.data;
//    }
//
//    private void setData(T data) {
//        this.data = data;
//    }
//
//    public ResultDTO() {
//    }
//
//    ResultDTO(Status status) {
//        this.status = status;
//    }
//
//    public static ResultDTO<Void> success() {
//        ResultDTO<Void> result = new ResultDTO(Status.success);
//        return result;
//    }
//
//    public static ResultDTO<Void> failure(ResultError... errors) {
//        ResultDTO<Void> result = new ResultDTO(Status.failure);
//        result.setErrors(errors);
//        return result;
//    }
//
//    public static <T> ResultDTO<T> success(T data) {
//        ResultDTO<T> result = new ResultDTO(Status.success);
//        result.setData(data);
//        return result;
//    }
//
//    public static <T> ResultDTO<T> failure(T data, ResultError... errors) {
//        ResultDTO<T> result = new ResultDTO(Status.failure);
//        result.setData(data);
//        result.setErrors(errors);
//        return result;
//    }
//}
