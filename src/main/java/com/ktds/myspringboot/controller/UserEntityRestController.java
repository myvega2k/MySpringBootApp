package com.ktds.myspringboot.controller;

import com.ktds.myspringboot.dto.UserRequest;
import com.ktds.myspringboot.dto.UserResponse;
import com.ktds.myspringboot.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

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

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable long id){
        return service.getUserById(id);
    }

    @GetMapping(value = "/email/{email}/",produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        return service.getUserByEmail(email);
    }
    @PatchMapping("/{email}")
    public UserResponse updateUser(@PathVariable String email,@RequestBody UserRequest request){
        return service.updateUser(email, request);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email){
        return service.deleteUser(email);
    }

}
