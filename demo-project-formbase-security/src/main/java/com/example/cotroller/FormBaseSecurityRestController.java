package com.example.cotroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class FormBaseSecurityRestController {

    @GetMapping("/say")
    public String formBaseSecurity()
    {
        return "hello form base security";
    }
}

//http://localhost:8080/test/say