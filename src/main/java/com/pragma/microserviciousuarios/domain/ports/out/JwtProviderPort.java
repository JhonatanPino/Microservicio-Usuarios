package com.pragma.microserviciousuarios.domain.ports.out;

import com.pragma.microserviciousuarios.domain.models.UserModel;

public interface JwtProviderPort {
    String generateToken(UserModel user);
    boolean validateToken(String token);
    String getEmailFromToken(String token);
}
