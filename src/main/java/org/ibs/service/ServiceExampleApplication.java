package org.ibs.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJdbcRepositories
public class ServiceExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceExampleApplication.class, args);
    }

}
