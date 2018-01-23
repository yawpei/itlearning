package vip.itlearning.exception;

/**
 * @author yaw
 * @date 2018/1/23 16:29
 */
public class CustomRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -6019282202870674390L;
    private final String code;
    private Object[] params;

    public CustomRuntimeException(String code) {
        this.code = code;
    }

    public CustomRuntimeException(String code, Object... params) {
        this.code = code;
        this.params = params;
    }

    public CustomRuntimeException(String code, String defaultMessage) {
        super(defaultMessage);
        this.code = code;
    }

    public CustomRuntimeException(String code, String defaultMessage, Object... params) {
        super(defaultMessage);
        this.code = code;
        this.params = params;
    }

    public CustomRuntimeException(String code, String defaultMessage, Throwable cause) {
        super(defaultMessage, cause);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public Object[] getParams() {
        return this.params;
    }
}
