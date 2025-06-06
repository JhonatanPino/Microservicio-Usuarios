package com.pragma.microserviciousuarios.application.dto.request;

public record AuthenticationRequest(String email, String password) {
    public AuthenticationRequest {
        // Validations fields not Null and empty
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        // Validation for email
        if (!email.matches("^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
