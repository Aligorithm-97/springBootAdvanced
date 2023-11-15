package com.example.springadvanced.security;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Service
public class UserDetailServiceExample implements UserDetailsService {
    private final BCryptPasswordEncoder passwordEncoder;
    private Map<String, UserDetails> users = new ConcurrentHashMap<>();

    public UserDetailServiceExample(BCryptPasswordEncoder passwordEncoderParam) {
        passwordEncoder = passwordEncoderParam;
        users.put("aligorithm",
                User.builder()
                        .username("ali")
                        .password(passwordEncoderParam.encode("123456"))
                        .roles("ADMIN")
                        .build());
        users.put("ahmet",
                User.builder()
                        .username("ahmet")
                        .password(passwordEncoderParam.encode("123456"))
                        .roles("USER")
                        .build());
    }
    private UserDetails cloneUser(UserDetails userDetailsParam) {
        return User.builder()
                .username(userDetailsParam.getUsername())
                .password(userDetailsParam.getPassword())
                .authorities(userDetailsParam.getAuthorities())
                .build();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Logger logger;
        UserDetails userDetailsLoc = users.get(username);
        if (userDetailsLoc == null) {
            throw new UsernameNotFoundException("Böyle bir user yok");
        }
        return cloneUser(userDetailsLoc);
    }
}
