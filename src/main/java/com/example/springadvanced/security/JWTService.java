package com.example.springadvanced.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JWTService {
    private Key key;
    private static final Logger logger = LoggerFactory.getLogger(JWTService.class);
    public JWTService(){
        key= Keys.hmacShaKeyFor("JWTexasdfasdfqweasdfqweasdfqwefasdfqwefasdfefasdfqwef33321".getBytes());
    }
    public String generateJWT(UserDetails details) {
        return Jwts.builder()
                .subject(details.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30)))
                .claim("xyz", "deneme")
                .signWith(key)
                .compact();
    }
    public Jws<Claims> validate(String token){
        JwtParser jwtparserloc = Jwts.parser().verifyWith((SecretKey) key).build();
        Jws<Claims> claimsJws =null;
        try {
            claimsJws = jwtparserloc.parseSignedClaims(token);
            return claimsJws;
        }catch (Exception eParam){
            logger.error("[JWTService][validate]-> *Error* : " + eParam.getMessage(),
                    eParam);
            return null;
        }

    }
}
