package com.pragma.microserviciousuarios.infrastructure.adapter.persistence;

import com.pragma.microserviciousuarios.domain.models.UserModel;
import com.pragma.microserviciousuarios.domain.ports.out.JwtProviderPort;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtProviderAdapter implements JwtProviderPort {
    @Value("${security.jwt.secret}")
    private String secret;

    @Value("${security.jwt.expirationMillis}")
    private long expiration;

    @Override
    public String generateToken(UserModel user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getRole().getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
