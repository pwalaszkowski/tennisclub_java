package com.tennisclub.club.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public String exampleBean() {
        return "Example Bean";
    }
}