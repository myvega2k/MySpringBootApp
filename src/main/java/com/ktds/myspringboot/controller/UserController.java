package com.ktds.myspringboot.controller;

import com.ktds.myspringboot.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserEntityService service;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("users",service.listUser());
        return "index";
    }

    @GetMapping("/thymeleaf")
    public String leaf(Model model) {
        model.addAttribute("name","스프링부트");
        return "leaf";
    }
}
