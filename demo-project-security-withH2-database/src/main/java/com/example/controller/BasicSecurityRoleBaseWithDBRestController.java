package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test1")
public class BasicSecurityRoleBaseWithDBRestController {

    @GetMapping(path = "/basic1")
    public  String basicSecurity()
    {
        return "basic security  configuration";
    }

    @GetMapping(path = "/user")
    @PreAuthorize("hasRole('USER')")
    public  String userEndpoint()
    {
        return "basic security  configuration and role base access user1";
    }
    @GetMapping(path = "/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public  String adminEndpoint()
    {
        return "basic security  configuration and role base admin endpoint";
    }

}
