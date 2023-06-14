package com.ktds.myspringboot.config;

import com.ktds.myspringboot.dto.Customer;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DevConfigTest {
    @Autowired
    String hello;
    @Resource(name="hello")
    String hello2;

    @Autowired
    @Qualifier("myCustomer")
    Customer customer;

    @Resource(name="myCustomer")
    Customer customer2;

    @Test @Disabled
    public void prototype_customer_test() {
        assertNotSame(customer, customer2);
    }

    @Test @Disabled
    public void singleton_customer_test(){
        assertSame(customer, customer2);
    }

    @Test @Disabled
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