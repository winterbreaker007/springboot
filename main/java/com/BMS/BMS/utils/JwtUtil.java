package com.blackwater.blackwaterbillingmanagementsystem.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by samgi on 4/8/2021.
 */
@Service
public class JwtUtil {
  @Value("${jwt.secret}")
  private String jwtSecret;

  @Value("${jwt.expiration.in.minutes}")
  private Integer expirationTimeInMinutes;

  @Value("${jwt.refresh.expiration.in.minutes}")
  private Integer refreshExpirationTimeInMinutes;

  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  public Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  public <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
  }

  public Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();

    Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();

    if (roles.contains(new SimpleGrantedAuthority("ADMIN"))) {
      claims.put("isAdmin", true);
    }
    if (roles.contains(new SimpleGrantedAuthority("USER"))) {
      claims.put("isUser", true);
    }

    return createToken(claims, userDetails.getUsername());
  }

  private String createToken(Map<String, Object> claims, String subject){
    return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expirationTimeInMinutes))
        .signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
  }

  private String createRefreshToken(Map<String, Object> claims, String subject){
    return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * refreshExpirationTimeInMinutes))
        .signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
  }

  public Boolean validToken(String token, UserDetails userDetails){
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

  public String getJwtFromHeader(String authHeader){
    return authHeader.substring(7);
  }

  public List<SimpleGrantedAuthority> getRolesFromToken(String token) {
    Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

    List<SimpleGrantedAuthority> roles = null;

    Boolean isAdmin = claims.get("isAdmin", Boolean.class);
    Boolean isUser = claims.get("isUser", Boolean.class);

    if (isAdmin != null && isAdmin) {
      roles = Collections.singletonList(new SimpleGrantedAuthority("ADMIN"));
    }

    if (isUser != null && isUser) {
      roles = Collections.singletonList(new SimpleGrantedAuthority("USER"));
    }
    return roles;

  }
}
