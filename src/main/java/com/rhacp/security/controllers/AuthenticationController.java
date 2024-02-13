package com.rhacp.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @GetMapping("/register")
    public String register() {
        return "Welcome to the registration page!";
    }

    @GetMapping("/login")
    public String login() {
        return "Welcome to the login page.";
    }
}
