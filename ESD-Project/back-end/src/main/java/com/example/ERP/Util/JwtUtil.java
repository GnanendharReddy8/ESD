package com.example.ERP.Util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "your256bitSecretKeyHereThatIsVerySecureAndLongEnough"; // Replace with a 256-bit secret
    private static final int TOKEN_VALIDITY = 60 * 60 * 1000; // 1 hour

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username, String department) {
        return Jwts.builder()
                .setSubject(username)
                .claim("department", department) // Add custom claims
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            logger.error("JWT Token has expired", e);
        } catch (UnsupportedJwtException e) {
            logger.error("JWT Token is unsupported", e);
        } catch (MalformedJwtException e) {
            logger.error("JWT Token is malformed", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT Token is empty or invalid", e);
        }
        return false;
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
