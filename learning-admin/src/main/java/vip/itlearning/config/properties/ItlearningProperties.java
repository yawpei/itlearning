package vip.itlearning.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

import static vip.itlearning.core.utils.ToolUtil.getTempPath;
import static vip.itlearning.core.utils.ToolUtil.isEmpty;


/**
 * guns项目配置
 *
 * @author yaw
 * @Date 2017/5/23 22:31
 */
/**
  * @author: yaw
  * @description:  项目配置
  * @date: 17:20 2018/2/7
 **/
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "itlearning")
public class ItlearningProperties {

    private Boolean kaptchaOpen = false;

    private Boolean swaggerOpen = false;

    private String fileUploadPath;

    private Boolean haveCreatePath = false;

    private Boolean springSessionOpen = false;

    private Integer sessionInvalidateTime = 30 * 60;  //session 失效时间（默认为30分钟 单位：秒）

    private Integer sessionValidationInterval = 15 * 60;  //session 验证失效时间（默认为15分钟 单位：秒）

    // 多数据源
    private MutiDatasource mutiDatasource= new MutiDatasource();

    @Setter
    @Getter
    public static class MutiDatasource{
        private String defaultDataSourceName;
        private String url;
        private String username;
        private String password;
    }

    public String getFileUploadPath() {
        //如果没有写文件上传路径,保存到临时目录
        if (isEmpty(fileUploadPath)) {
            return getTempPath();
        } else {
            //判断有没有结尾符,没有得加上
            if (!fileUploadPath.endsWith(File.separator)) {
                fileUploadPath = fileUploadPath + File.separator;
            }
            //判断目录存不存在,不存在得加上
            if (haveCreatePath == false) {
                File file = new File(fileUploadPath);
                file.mkdirs();
                haveCreatePath = true;
            }
            return fileUploadPath;
        }
    }
}
