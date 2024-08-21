package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    DataSource dataSource;
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.requestMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated());
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));//disable  the  cookie
       // http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        http.headers(headers->headers.frameOptions(frameOptions->frameOptions.sameOrigin()));
        http.csrf(csrf->csrf.disable());
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
   /// persistig user detail i  data base authentication
    @Bean
    public UserDetailsService  userDetailsServiceDatabase()
    {
       // UserDetails user1= User.withUsername("user1").
         //       password("{noop}admin").roles("USER").build();

       // UserDetails user2= User.withUsername("user2").
              //  password("{noop}admin1").roles("ADMIN").build();


        UserDetails user1= User.withUsername("user1").
                password(passwordEncoder().encode("admin")).roles("USER").build();

        UserDetails user2= User.withUsername("user2").
                password(passwordEncoder().encode("admin1")).roles("ADMIN").build();

        JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user1);
        jdbcUserDetailsManager.createUser(user2);

        return  jdbcUserDetailsManager;

    }

@Bean
    public PasswordEncoder passwordEncoder()
{
    return  new BCryptPasswordEncoder();
}
}
