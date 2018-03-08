package vip.itlearning.core.utils;

import vip.itlearning.config.properties.ItlearningProperties;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

    /**
     * 获取验证码开关
     */
    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(ItlearningProperties.class).getKaptchaOpen();
    }
}