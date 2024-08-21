package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SpringSecurityWithH2Database
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringSecurityWithH2Database.class);
        System.out.println( "Hello World!" );
    }
}
