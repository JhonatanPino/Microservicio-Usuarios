package com.pragma.microserviciousuarios.application.dto.response;

public record AuthenticationResponse(String token) {
    public String getToken() {
        return token;
    }
}
