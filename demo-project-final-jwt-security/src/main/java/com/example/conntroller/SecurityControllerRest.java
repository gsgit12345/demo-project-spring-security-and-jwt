package com.example.conntroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityControllerRest {

    @GetMapping(path = "/hello")
    public String sayHello()
    {
        return "hello security controller";
    }
}
