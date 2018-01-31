package vip.itlearning.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * <p>数据库数据源配置</p>
 *
 * @author yaw
 * @date 2018/1/17 17:02
 */
@Configuration
public class DruidProperties {
    private Logger logger = LoggerFactory.getLogger(DruidProperties.class);


    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    //  下面为连接池的补充设置，应用到上面所有数据源中
    //  初始化大小，最小，最大
    private Integer initialSize = 2;
    private Integer minIdle = 1;
    private Integer maxActive = 20;

    //  配置获取连接等待超时的时间
    private Integer maxWait = 60000;

    //  配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    private Integer timeBetweenEvictionRunsMillis = 60000;

    //  配置一个连接在池中最小生存的时间，单位是毫秒
    private Integer minEvictableIdleTimeMillis = 300000;
    private String validationQuery = "SELECT 'x'";
    private Boolean testWhileIdle = true;
    private Boolean testOnBorrow = false;
    private Boolean testOnReturn = false;

    //  打开PSCache，并且指定每个连接上PSCache的大小
    private Boolean poolPreparedStatements = true;
    private Integer maxPoolPreparedStatementPerConnectionSize = 20;

    //  配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
    private String filters = "stat,wall,log4j";
    // 通过connectProperties属性来打开mergeSql功能；慢SQL记录
    private String connectionProperties;

    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(connectionProperties);

        return datasource;
    }

}