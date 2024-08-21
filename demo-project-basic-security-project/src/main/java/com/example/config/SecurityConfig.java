package com.example.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));//disable  the  cookie
       // http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
//Inmemory authentication
@Bean
    public UserDetailsService  userDetailsService()
    {
        UserDetails user1= User.withUsername("user1").
                password("{noop}admin").roles("USER").build();

        UserDetails user2= User.withUsername("user2").
                password("{noop}admin1").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user1,user2);

    }
}
