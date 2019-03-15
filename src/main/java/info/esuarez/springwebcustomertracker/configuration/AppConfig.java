package info.esuarez.springwebcustomertracker.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("info.esuarez.springwebcustomertracker")
@PropertySource("classpath:application.yaml")
public class AppConfig {
}
