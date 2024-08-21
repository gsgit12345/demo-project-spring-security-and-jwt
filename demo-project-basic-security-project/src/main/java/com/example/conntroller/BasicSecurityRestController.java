package com.example.conntroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test1")
public class BasicSecurityRestController {

    @GetMapping(path = "/basic1")
    public  String basicSecurity()
    {
        return "basic security  configuration";
    }
}
