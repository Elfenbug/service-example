package org.ibs.service.domain.config;

import lombok.extern.slf4j.Slf4j;
import org.ibs.service.domain.bussines.GreetingsService;
import org.ibs.service.domain.bussines.GreetingsServiceImpl;
import org.ibs.service.domain.bussines.GreetingsServiceImpl2;
import org.ibs.service.domain.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Slf4j
public class GreetingsServiceConfig {

    @Bean
    @Profile("!test")
    GreetingsService getGSImpl() {
        return new GreetingsServiceImpl(log);
    }

    @Bean
    @Profile("test")
    GreetingsService getGSImpl2() {
        return new GreetingsServiceImpl2(log);
    }

    @Bean
    Employee makeDefEmpl() {
        return new Employee(null, "Nikita", null, null, null,null,null);
    }
}
