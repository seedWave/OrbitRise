package com.orbitRise.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SynapseLoginController {

    @GetMapping("/synapse/login")
    public String login() {
        return "/synapse/login"; // templates/login.html (Thymeleaf 기준)
    }
}
