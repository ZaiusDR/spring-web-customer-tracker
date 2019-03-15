package info.esuarez.springwebcustomertracker.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.dialect.MySQL57Dialect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Properties;

@Configuration
public class SessionFactoryConfig {

    @Value("${factory.scanPath")
    private String scanPath;

    @Bean
    public LocalSessionFactoryBean sessionFactory(ComboPooledDataSource dataSource) {

        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();

        factory.setPackagesToScan(scanPath);
        factory.setDataSource(dataSource);

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", new MySQL57Dialect());
        hibernateProperties.put("hibernate.show_sql", true);
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.put("hibernate.temp.use_jdbc_metadata_defaults", false);
        factory.setHibernateProperties(hibernateProperties);

        return factory;
    }
}
