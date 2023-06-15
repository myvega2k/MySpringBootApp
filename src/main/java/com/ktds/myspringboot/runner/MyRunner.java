package com.ktds.myspringboot.runner;

import com.ktds.myspringboot.dto.Customer;
import com.ktds.myspringboot.property.MyBootProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {
    @Value("${myboot.name}")
    private String name;
    @Value("${myboot.age}")
    private int age;

    @Autowired
    private MyBootProperties properties;

    @Autowired
    private Customer customer;

    @Autowired
    private Environment environment;

    Logger logger = LoggerFactory.getLogger(MyRunner.class);

    //java -jar target\MySpringBoot-App-0.0.1-SNAPSHOT.jar --myboot.name=Spring
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Logger 구현 클래스명 = " + logger.getClass().getName());
        logger.debug("Environment 사용 myboot.fullName = {} ", environment.getProperty("myboot.fullName"));
        logger.info("Customer Bean = {}", customer.getName());
        logger.debug("Properties getFullName 값 = {}", properties.getFullName());
        logger.debug("Properties getAGe 값 = {}", properties.getAge());
        logger.debug("환경변수 name 값 = {}", name);
        logger.debug("환경변수 age 값 = {}" , age);

        logger.info("Program Argument = {}", args.containsOption("foo"));
        logger.info("VM Argument = {}", args.containsOption("bar"));
    }
}
