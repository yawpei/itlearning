package vip.itlearning.web.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;
import vip.itlearning.exception.CustomRuntimeException;

import java.util.List;

/**
 * @author yaw
 * @date 2018/1/26 14:24
 */
public class PageResult<T> extends ListResult<T> {
    @ApiModelProperty(value = "分页信息", position = 2)
    private PageData pageable;

    @JsonProperty(value = "data", index = 2)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<T> getData() {
        return super.getData();
    }

    @JsonProperty(value = "pageable", index = 3)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public PageData getPageable() {
        return pageable;
    }

    public void setPageable(PageData pageable) {
        this.pageable = pageable;
    }

    public PageResult() {
    }

    PageResult(Status status) {
        super(status);
    }

    public static <T> PageResult<T> success(Page<T> pageData) {
        if (pageData == null) {
            throw new CustomRuntimeException("NullPointerException", "The formal parameter 'pageData' cannot be null");
        } else {
            PageResult<T> result = new PageResult(Status.success);
            result.setData(pageData.getContent());
            result.setPageable(PageData.convert(pageData));
            return result;
        }
    }

    public static <T> PageResult<T> success(List<T> listData, Page<?> pageData) {
        if (pageData == null) {
            throw new CustomRuntimeException("NullPointerException", "The formal parameter 'pageData' cannot be null");
        } else {
            PageResult<T> result = new PageResult(Status.success);
            result.setData(listData);
            result.setPageable(PageData.convert(pageData));
            return result;
        }
    }
}
