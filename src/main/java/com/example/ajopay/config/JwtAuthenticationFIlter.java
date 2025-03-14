package com.example.ajopay.config;

import com.example.ajopay.service.CustomUserDetailService;
import com.example.ajopay.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtAuthenticationFIlter  extends OncePerRequestFilter {
private final JwtService jwtService;
private final CustomUserDetailService customUserDetailService;

    public JwtAuthenticationFIlter(JwtService jwtService, CustomUserDetailService customUserDetailService) {
        this.jwtService = jwtService;
        this.customUserDetailService = customUserDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader == null ||
                !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
    }
    final String jwt=authorizationHeader.substring(7);
    final String userName= jwtService.extractuserName(jwt);


        System.out.println("Authorization Header: " + authorizationHeader);
        System.out.println("Extracted JWT: " + jwt);
        System.out.println("Extracted Username: " + userName);

    Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if (userName!= null && authentication == null) {
            UserDetails userDetails=customUserDetailService.loadUserByUsername(userName);

        if(jwtService.isTokenValid(jwt,userDetails)){
            UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );
            authenticationToken.setDetails(
                    new WebAuthenticationDetailsSource()
                            .buildDetails(request)
            );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }

    }
        filterChain.doFilter(request, response);
}
}

