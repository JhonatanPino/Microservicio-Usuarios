package com.pragma.microserviciousuarios.infrastructure.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtClaimsModel {
    private String email;
    private String role;
    private Long id;
}
