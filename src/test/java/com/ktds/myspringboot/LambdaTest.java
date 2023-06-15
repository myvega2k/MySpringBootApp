package com.ktds.myspringboot;

import org.junit.jupiter.api.Test;

public class LambdaTest {

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



    }
}
