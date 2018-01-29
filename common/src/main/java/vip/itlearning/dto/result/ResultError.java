//package vip.itlearning.dto.result;
//
//import io.swagger.annotations.ApiModelProperty;
//
//import java.io.Serializable;
//
///**
// * @author yaw
// * @date 2018/1/23 16:21
// */
//public class ResultError implements Serializable {
//    @ApiModelProperty(
//            value = "字段名（字段校验类异常）",
//            position = 0
//    )
//    private String field;
//    @ApiModelProperty(
//            value = "异常消息",
//            position = 1
//    )
//    private String errmsg;
//    @ApiModelProperty(
//            value = "异常编码",
//            position = 2
//    )
//    private String errcode;
//
//    public ResultError() {
//    }
//
//    public ResultError(String errmsg, String field) {
//        this.field = field;
//        this.errmsg = errmsg;
//    }
//
//    public ResultError(String errcode, String errmsg, String field) {
//        this.field = field;
//        this.errcode = errcode;
//        this.errmsg = errmsg;
//    }
//
//    public String getField() {
//        return this.field;
//    }
//
//    public String getErrmsg() {
//        return this.errmsg;
//    }
//
//    public String getErrcode() {
//        return this.errcode;
//    }
//
//    public void setErrcode(String errcode) {
//        this.errcode = errcode;
//    }
//
//    public void setField(String field) {
//        this.field = field;
//    }
//
//    public void setErrmsg(String errmsg) {
//        this.errmsg = errmsg;
//    }
//
//    public String toString() {
//        return String.format("{errcode:%s, errmsg:%s, field:%s}", this.errcode, this.errmsg, this.field);
//    }
//}
