package info.esuarez.springwebcustomertracker;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebCustomerTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebCustomerTrackerApplication.class, args);
    }

}
