package com.ktds.myspringboot;

import com.ktds.myspringboot.dto.Customer;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {

    @Test
    void consumer_test() {
        //Immutable List
        List<Customer> customerList =
                List.of(new Customer("boot", 10),
                        new Customer("msa", 20),
                        new Customer("ktds", 50),
                        new Customer("wifi", 70));

        //1. Anonymous Inner Class
        customerList.forEach(new Consumer<Customer>() {
            @Override
            public void accept(Customer customer) {
                System.out.println(customer);
            }
        });
        //2. Lambda Expression
        customerList.forEach(cust -> System.out.println(cust));
        //3. Method Reference
        customerList.forEach(System.out::println);

        //Customer의 age 합계를 계산하기 (age >= 50)
        int sumOfAge =
                customerList.stream() //Stream<Customer>
                        .filter(customer -> customer.getAge() >= 50) //Stream<Customer>
                        //.mapToInt(customer -> customer.getAge()) //Stream<Integer>
                        .mapToInt(Customer::getAge)//IntStream
                        .sum();
        System.out.println("나이 합계 " + sumOfAge);
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
