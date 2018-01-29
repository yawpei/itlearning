//package vip.itlearning.dto.result;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModelProperty;
//import vip.itlearning.exception.CustomRuntimeException;
//
//import java.util.List;
//
///**
// * @author yaw
// * @date 2018/1/23 16:24
// */
//public class ListResultDTO<T> extends AbstractResultDTO {
//    private static final long serialVersionUID = 3562598749414336485L;
//    @ApiModelProperty(
//            value = "业务数据（List）",
//            position = 1
//    )
//    protected List<T> data;
//
//    @JsonInclude(Include.NON_NULL)
//    @JsonProperty(
//            value = "data",
//            index = 3
//    )
//    public List<T> getData() {
//        return this.data;
//    }
//
//    public void setData(List<T> data) {
//        this.data = data;
//    }
//
//    public ListResultDTO() {
//    }
//
//    ListResultDTO(Status status) {
//        this.status = status;
//    }
//
//    public static <T> ListResultDTO<T> success(List<T> listData) {
//        if (listData == null) {
//            throw new CustomRuntimeException("NullPointerException", "The formal parameter 'listData' cannot be null");
//        } else {
//            ListResultDTO<T> result = new ListResultDTO(Status.success);
//            result.setData(listData);
//            return result;
//        }
//    }
//
//    public static <T> ListResultDTO<T> failure(List<T> listData, ResultError... errors) {
//        ListResultDTO<T> result = new ListResultDTO(Status.failure);
//        result.setData(listData);
//        result.setErrors(errors);
//        return result;
//    }
//}
