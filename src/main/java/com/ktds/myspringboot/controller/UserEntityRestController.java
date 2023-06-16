package com.ktds.myspringboot.controller;

import com.ktds.myspringboot.dto.UserRequest;
import com.ktds.myspringboot.dto.UserResponse;
import com.ktds.myspringboot.service.UserEntityService;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserEntityRestController {
    private final UserEntityService service;

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest request) {
        return service.insertUser(request);
    }

    @GetMapping
    public List<UserResponse> listUser() {
        return service.listUser();
    }
}
