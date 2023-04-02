package com.kbank.userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http.csrf().disable();
    //     http.authorizeRequests().antMatchers("/users/**").permitAll();
    // }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/users/**").permitAll()
            .and()
            .csrf().disable();

        return http.build();

    }
}
