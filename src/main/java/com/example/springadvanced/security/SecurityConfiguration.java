package com.example.springadvanced.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurityparam, UserDetailServiceExample service) throws  Exception{
       return httpSecurityparam.getSharedObject(AuthenticationManagerBuilder.class)
               .userDetailsService(service)
               .and()
               .build();
    }

    @Bean
    public JWTFilter jwtFilter() {
        return new JWTFilter();
    }
    @Bean
    public SecurityFilterChain configureSec(HttpSecurity httpSecurityparam) throws Exception {
        return httpSecurityparam.authorizeRequests()
                .antMatchers("/api/**")
                .hasAnyRole("ADMIN","USER")
                .antMatchers("/h2-console/**","/actuator/**","/swagger-ui/**","/v3/api-docs/**","/favicon.ico","/sec/v1/security/login","/counter/increase")
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
                .addFilterBefore(jwtFilter(),
                        UsernamePasswordAuthenticationFilter.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers().frameOptions().disable().and()
                .build();
    }
    @Bean
    public JWTService jwtService() {
        return new JWTService();
    }
}
