package com.ktds.myspringboot.service;

import com.ktds.myspringboot.dto.UserRequest;
import com.ktds.myspringboot.dto.UserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserEntityServiceTest {
    @Autowired
    UserEntityService service;

    @Test
    void user_insert() {
        UserRequest request = UserRequest.builder()
                .name("스프링")
                .email("spring@aa.com")
                .build();
        UserResponse response = service.insertUser(request);
        System.out.println("response = " + response);
    }
}