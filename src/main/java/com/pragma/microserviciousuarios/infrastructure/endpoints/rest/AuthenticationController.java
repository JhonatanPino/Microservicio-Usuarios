package com.pragma.microserviciousuarios.infrastructure.endpoints.rest;

import com.pragma.microserviciousuarios.application.dto.request.AuthenticationRequest;
import com.pragma.microserviciousuarios.application.dto.response.AuthenticationResponse;
import com.pragma.microserviciousuarios.application.services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(summary = "Authenticate a user")
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
