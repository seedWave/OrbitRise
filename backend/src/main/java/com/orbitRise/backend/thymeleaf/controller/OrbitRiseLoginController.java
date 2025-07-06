package com.orbitRise.backend.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrbitRiseLoginController {

    @GetMapping("/orbitRise/login")
    public String login() {
        return "/orbitRise/login"; // templates/login.html (Thymeleaf 기준)
    }
}
