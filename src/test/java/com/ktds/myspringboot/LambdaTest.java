package com.ktds.myspringboot;

import com.ktds.myspringboot.dto.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LambdaTest {

    @Test
    void consumer_test() {
        List.of(new Customer("boot",10), new Customer("msa",20));
    }

    @Test
    void runnable_test () {
        //1. Anonymous Inner Class
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Inner Class 형태로 재정의함");
            }
        });
        t1.start();
        //2. Lambda Expression
        Thread t2 = new Thread(() -> System.out.println("람다함수 형태로 재정의함"));
        t2.start();


    }
}
