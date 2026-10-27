package com.eazybytes.eazybytes.util;

import com.eazybytes.eazybytes.constansts.ApplicationConstant;
import com.eazybytes.eazybytes.entity.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final Environment env;

    public String generateJwtToken(Authentication authentication) {
        String jwt = "";
        String secret = env.getProperty(ApplicationConstant.JWT_SECRET_KEY , ApplicationConstant.JWT_SECRET_DEFAULT_VALUE);
        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        Customer customer = (Customer) authentication.getPrincipal();
        jwt = Jwts
                .builder()
                .issuer("Eazy Bank")
                .subject("JWT Token")
                .claim("username" , customer.getName())
                .claim("email" , customer.getEmail())
                .claim("mobileNumber" , customer.getMobileNumber())
                .claim("roles" , authentication.getAuthorities().
                        stream().map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining(",")))
                .issuedAt(new java.util.Date())
                .expiration(new java.util.Date((new java.util.Date()).getTime() + 60 * 60 * 1000) )
                .signWith(secretKey)
                .compact();

        return jwt;
    }
}
