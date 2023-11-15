package com.example.springadvanced.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurityparam, UserDetailServiceExample service) throws  Exception{
       return httpSecurityparam.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(service).and().build();
    }
    @Bean
    public SecurityFilterChain configureSec(HttpSecurity httpSecurityparam) throws Exception {
        return httpSecurityparam.authorizeRequests()
                .antMatchers("/actuator/**")
                .anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .cors()
                .disable()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .build();
    }
}
