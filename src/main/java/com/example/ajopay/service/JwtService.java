package com.example.ajopay.service;

import com.example.ajopay.dto.RequestDto.LoginDto;
import com.example.ajopay.model.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private  String secretKey=null;

    public String generateToken(LoginDto loginDto) {
        Map<String,Object> claims = new HashMap<>();
        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(loginDto.getEmail())
                .issuer("Nofisat")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 10 *1000))
                .and()
                .signWith(generateKey())
                .compact();
    }

    private SecretKey generateKey() {
        byte[] decode= Decoders.BASE64.decode(getSecretKey());
        return Keys.hmacShaKeyFor(decode);
    }


    public String getSecretKey(){
        return secretKey="0peVI0UPWtmrtcOac7ECC08GJGfcB3Co+NE1dEF0yx8=";

    }

    public String extractuserName(String jwt) {
        return extractClaims(jwt ,Claims :: getSubject);
    }
 private <T> T extractClaims(String token, Function <Claims, T> claimsResolver) {
        Claims claims= extractClaims(token);
        return  claimsResolver.apply(claims);
 }

    private Claims extractClaims(String token) {
        return  Jwts
                .parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    public boolean isTokenValid(String token, UserDetails userDetails) {
        final  String email= extractuserName(token);
        return  (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return  extractExpiration(token).before(new Date());
    }

    private Date extractExpiration( String token) {
        return extractClaims(token,Claims::getExpiration);
    }








}
