package com.rhacp.security.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole(ADMIN)")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @PreAuthorize("hasRole(ADMIN)")
    @GetMapping
    public String greetUsers() {
        return "Hello User!";
    }
}
