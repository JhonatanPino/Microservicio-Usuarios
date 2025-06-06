package com.pragma.microserviciousuarios.infrastructure.security;

import com.pragma.microserviciousuarios.domain.ports.in.RoleValidatorPort;
import com.pragma.microserviciousuarios.infrastructure.security.utils.JwtUtil;
import org.springframework.stereotype.Component;

@Component
public class JwtRoleValidator implements RoleValidatorPort {

    private final JwtUtil jwtUtil;

    public JwtRoleValidator(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String extractRole(String token) {
        return jwtUtil.extractRole(token);
    }
}
