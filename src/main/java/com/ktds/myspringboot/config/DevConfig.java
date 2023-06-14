package com.ktds.myspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
}
