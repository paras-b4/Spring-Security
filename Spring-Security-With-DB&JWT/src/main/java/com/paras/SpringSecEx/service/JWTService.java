package com.paras.SpringSecEx.service;

import com.paras.SpringSecEx.model.student;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JWTService
{

    private String secretkey="";

    public JWTService()
    {
        try {
            KeyGenerator keyGen= KeyGenerator.getInstance("HmacSHA256");
            SecretKey sk= keyGen.generateKey();
            secretkey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String generateToken(student stud) {
        Map<String,Object> claims= new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(stud.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000* 60 * 60 * 20))
                .and()
                .signWith(getKey())
                .compact();


    }
     //// Get the signing key from the secret key
    private SecretKey getKey() {
        byte[] keyByte= Decoders.BASE64.decode(secretkey);
        return Keys.hmacShaKeyFor(keyByte);

    }



    // Extract username from the token
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Extract any claim (generic method)
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Extract all claims from the token
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // Validate the token with user details
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // Check if the token has expired
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extract the expiration date from the token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}

