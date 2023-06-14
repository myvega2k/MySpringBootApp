package com.ktds.myspringboot.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Program Argument = " + args.containsOption("foo"));
        System.out.println("VM Argument = " + args.containsOption("bar"));
    }
}
