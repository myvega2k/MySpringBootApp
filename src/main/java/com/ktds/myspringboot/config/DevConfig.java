package com.ktds.myspringboot.config;

import com.ktds.myspringboot.dto.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
@Profile("dev")
@Configuration
public class DevConfig {
    @Bean
    @Scope(value = "prototype")
    /**
     * Scope 의 종류
     *  Singleton, Prototype, Request, Session
     */
    public String hello() {
        return new String("Development Mode!!");
    }

    @Bean("myCustomer")
    @Scope(value = "singleton")
    public Customer customer() {
        return new Customer("DevMode",100);
    }
}
