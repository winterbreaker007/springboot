package com.blackwater.blackwaterbillingmanagementsystem.security;

import com.blackwater.blackwaterbillingmanagementsystem.service.MyUserDetailsService;
import com.blackwater.blackwaterbillingmanagementsystem.utils.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Created by samgi on 4/8/2021.
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

  @Autowired
  private MyUserDetailsService myUserDetailsService;

  @Autowired
  private JwtUtil jwtUtil;

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws ServletException, IOException {
    final String authorizationHeader = httpServletRequest.getHeader("Authorization");

    String username = null;
    String jwt = null;

    if (Objects.nonNull(authorizationHeader) && authorizationHeader.startsWith("Bearer ")){
      jwt = jwtUtil.getJwtFromHeader(authorizationHeader);
      try{
        username = jwtUtil.extractUsername(jwt);
      } catch (ExpiredJwtException ex){
        logger.info("Token expired");
      }
    }

    if(Objects.nonNull(username) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())){
      UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(username);

      if(jwtUtil.validToken(jwt, userDetails)){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,
            userDetails.getAuthorities());
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
      }
    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
