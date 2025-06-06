package com.pragma.microserviciousuarios.domain.ports.in;

public interface RoleValidatorPort {
    String extractRole(String token);
}