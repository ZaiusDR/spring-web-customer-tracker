package info.esuarez.springwebcustomertracker.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;


@Configuration
public class DataSourceConfig {

    @Value("${db.url}")
    private String url;

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Value("${pool.minSize}")
    private Integer poolMinSize;

    @Value("${pool.maxSize}")
    private Integer poolMaxSize;

    @Value("${pool.maxIdleTime}")
    private Integer poolMaxIdleTime;

    @Bean(destroyMethod = "close")
    public ComboPooledDataSource comboPooledDataSource(){

        ComboPooledDataSource ds = new ComboPooledDataSource();

        ds.setJdbcUrl(url);
        ds.setUser(user);
        ds.setPassword(password);
        ds.setMinPoolSize(poolMinSize);
        ds.setMaxPoolSize(poolMaxSize);
        ds.setMaxIdleTime(poolMaxIdleTime);
        return ds;
    }
}
