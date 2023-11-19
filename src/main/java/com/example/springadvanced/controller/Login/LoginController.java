package com.example.springadvanced.controller.Login;


import com.example.springadvanced.models.UserCredentials;
import com.example.springadvanced.security.JWTService;
import com.example.springadvanced.security.UserDetailServiceExample;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sec/v1/security")
@RequiredArgsConstructor
public class LoginController
{
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final JWTService jwtService;
    private final UserDetailServiceExample detailService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@Valid @RequestBody UserCredentials uc){
        logger.info(uc.getUsername());
        Authentication authenticateLoc = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(uc.getUsername(),
                uc.getPassword()));
        return jwtService.generateJWT((UserDetails) authenticateLoc.getPrincipal());
    }
}
