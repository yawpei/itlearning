package vip.itlearning.exception;


import vip.itlearning.web.result.ResultError;

/**
 * @author yaw
 * @date 2018/1/23 16:30
 */
public class RestResultRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1834909976499941887L;
    private ResultError[] errors;

    public RestResultRuntimeException(ResultError[] errors, String message) {
        super(message);
        this.setErrors(errors);
    }

    public ResultError[] getErrors() {
        return this.errors;
    }

    public void setErrors(ResultError[] errors) {
        this.errors = errors;
    }
}
