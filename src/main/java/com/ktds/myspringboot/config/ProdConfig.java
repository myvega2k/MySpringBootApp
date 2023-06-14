package com.ktds.myspringboot.config;

import com.ktds.myspringboot.dto.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Profile("prod")
@Configuration
public class ProdConfig {
    @Bean("myCustomer")
    @Scope(value = "singleton")
    public Customer customer() {
        return new Customer("ProdMode",200);
    }
}
