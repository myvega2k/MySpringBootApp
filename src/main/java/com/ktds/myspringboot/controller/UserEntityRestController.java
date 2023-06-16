package com.ktds.myspringboot.controller;

import com.ktds.myspringboot.dto.UserRequest;
import com.ktds.myspringboot.dto.UserResponse;
import com.ktds.myspringboot.service.UserEntityService;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserEntityRestController {
    private final UserEntityService service;

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest request) {
        return service.insertUser(request);
    }
}
