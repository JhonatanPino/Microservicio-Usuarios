package com.pragma.microserviciousuarios.application.dto.response;

import java.time.LocalDateTime;

public record SaveUserResponse(String message, LocalDateTime time) {
}
