//package vip.itlearning.dto.result;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModelProperty;
//import org.springframework.data.domain.Page;
//import vip.itlearning.exception.CustomRuntimeException;
//import vip.itlearning.web.result.PageData;
//
//import java.util.List;
//
///**
// * @author yaw
// * @date 2018/1/23 16:31
// */
//public class PageResultDTO<T> extends ListResultDTO<T> {
//    private static final long serialVersionUID = 1344404696341415238L;
//    @ApiModelProperty(
//            value = "分页信息",
//            position = 2
//    )
//    private PageData pageable;
//
//    @JsonInclude(Include.NON_NULL)
//    @JsonProperty(
//            value = "data",
//            index = 2
//    )
//    public List<T> getData() {
//        return super.getData();
//    }
//
//    @JsonInclude(Include.NON_NULL)
//    @JsonProperty(
//            value = "pageable",
//            index = 3
//    )
//    public PageData getPageable() {
//        return this.pageable;
//    }
//
//    public void setPageable(PageData pageable) {
//        this.pageable = pageable;
//    }
//
//    public PageResultDTO() {
//    }
//
//    PageResultDTO(Status status) {
//        super(status);
//    }
//
//    public static <T> PageResultDTO<T> success(Page<T> pageData) {
//        if (pageData == null) {
//            throw new CustomRuntimeException("NullPointerException", "The formal parameter 'pageData' cannot be null");
//        } else {
//            PageResultDTO<T> result = new PageResultDTO(Status.success);
//            result.setData(pageData.getContent());
//            result.setPageable(PageData.convert(pageData));
//            return result;
//        }
//    }
//
//    public static <T> PageResultDTO<T> success(List<T> listData, Page<?> pageData) {
//        if (pageData == null) {
//            throw new CustomRuntimeException("NullPointerException", "The formal parameter 'pageData' cannot be null");
//        } else {
//            PageResultDTO<T> result = new PageResultDTO(Status.success);
//            result.setData(listData);
//            result.setPageable(PageData.convert(pageData));
//            return result;
//        }
//    }
//}
