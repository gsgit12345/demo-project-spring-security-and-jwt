package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication

public class BasicSecurityDemoApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(BasicSecurityDemoApp.class);
        System.out.println( "Hello World!" );
    }
}

// http://localhost:8081/test1/basic1