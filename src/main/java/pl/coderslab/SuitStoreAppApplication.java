package pl.coderslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) //https://www.baeldung.com/spring-boot-security-autoconfiguration NIE CHCIAŁ MI LOGIN PAGE ZNIKNĄĆ
public class SuitStoreAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuitStoreAppApplication.class, args);
    }

}
