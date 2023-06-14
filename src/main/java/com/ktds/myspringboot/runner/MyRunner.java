package com.ktds.myspringboot.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {
    @Value("${myboot.name}")
    private String name;
    @Value("${myboot.age}")
    private int age;

    //java -jar target\MySpringBoot-App-0.0.1-SNAPSHOT.jar --myboot.name=Spring
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("환경변수 name 값 = " + name);
        System.out.println("환경변수 age 값 = " + age);
        System.out.println("Program Argument = " + args.containsOption("foo"));
        System.out.println("VM Argument = " + args.containsOption("bar"));
    }
}
