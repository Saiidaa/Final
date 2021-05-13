package javaa.controller;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmptyFlyway {

    @Bean
    public Flyway flyway() {
        return flyway();
    }

}