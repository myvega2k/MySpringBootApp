package com.ktds.myspringboot.controller;

import com.ktds.myspringboot.dto.UserRequest;
import com.ktds.myspringboot.service.UserEntityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserEntityService service;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("users",service.listUser());
        return "index";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid UserRequest user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }
        service.insertUser(user);
        model.addAttribute("users", service.listUser());
        return "index";
    }

    @GetMapping("/thymeleaf")
    public String leaf(Model model) {
        model.addAttribute("name","스프링부트");
        return "leaf";
    }
}
