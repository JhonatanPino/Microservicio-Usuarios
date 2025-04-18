package com.pragma.microserviciousuarios.application.dto.response;

public record UserResponse(Long id, String name, String lastName, String documentNumber, String phone, String birthDate, String email, String password) {
}
