package com.ktds.myspringboot.config;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DevConfigTest {
    @Autowired
    String hello;

    @Resource(name="hello")
    String hello2;

    @Test
    public void prototype_test() {
        assertNotSame(hello, hello2);
    }

    @Test @Disabled
    public void scope_test() {
        System.out.println("hello bean " + hello);
        //주소비교
        assertSame(hello, hello2);
    }
}