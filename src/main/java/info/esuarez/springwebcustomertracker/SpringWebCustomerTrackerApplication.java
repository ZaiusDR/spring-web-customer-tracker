package info.esuarez.springwebcustomertracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringWebCustomerTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebCustomerTrackerApplication.class, args);
    }

}
