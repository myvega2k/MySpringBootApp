package com.ktds.myspringboot.controller;

import com.ktds.myspringboot.dto.UserRequest;
import com.ktds.myspringboot.dto.UserResponse;
import com.ktds.myspringboot.dto.Users;
import com.ktds.myspringboot.service.UserEntityService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserEntityRestController {
    private final UserEntityService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "이 페이지는 로그인 없이 접근 할 수 있는 페이지입니다.";
    }

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest request) {
        return service.insertUser(request);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserResponse> listUser() {
        return service.listUser();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
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

    @GetMapping(value="/xml", produces = APPLICATION_XML_VALUE)
    public Users listUserXml() {
        Users users = new Users();
        users.setUsers(service.listUser());
        return users;
    }
}
