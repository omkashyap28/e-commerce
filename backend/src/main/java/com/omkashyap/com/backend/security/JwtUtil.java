package com.omkashyap.com.backend.security;

import com.omkashyap.com.backend.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

  @Value("${jwt.secretKey}")
  private String SECRET;

  private SecretKey getSecretKey() {
    return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
  }

  public String generateAccessToken(User user) {
    return Jwts.builder()
        .setSubject(user.getEmail())
        .claim("userId", user.getPublicId())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 86400000))
        .signWith(SignatureAlgorithm.HS256, getSecretKey())
        .compact();
  }
}
